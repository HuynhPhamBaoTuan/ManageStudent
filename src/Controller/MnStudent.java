package Controller;

import Common.Utility;
import Model.Student;
import java.util.ArrayList;

public class MnStudent {

    protected int id = 0, semester;
    protected String name, course;
    protected Manager manage = new Manager();
    protected ArrayList<Student> st_list = new ArrayList<>();

    public void CreateNewStudent() {
        boolean loop = true;
        System.out.println("Create a new student: ");
        do {
            id++;
            name = Utility.GetString("Enter student's name: ", false);
            semester = Utility.getInt("Enter student's semester: ");
            course = Utility.GetString("Enter student's course: ", false);
            Student st = new Student(id, name, semester, course);
            st_list.add(st);
            if (st_list.size() < 2) {
                System.out.println("You need to create at least 2 students");
            } else {
                if (Utility.GetYesNo("Do you want to continue (Y/N)?") == false) {
                    loop = false;
                }
            }
        } while (loop);
    }

    public void Find_and_Sort() {
        Student st = new Student(id, name, semester, course);
        System.out.println("Find a student by name: ");
        String input_name = Utility.GetString("Enter the name: ", false);
        manage.findbyName(input_name, st_list);
        System.out.println();
        System.out.println("Sort student list: ");
        manage.sort(st_list, st);
        manage.print(st_list);
    }

    public void Update_or_Delete() {
        int inputID = Utility.getInt("Enter student needed to update or delete's id: "), validID;
        if ((validID = manage.findbyID(inputID, st_list)) != 0) {
            do {
                String choice = Utility.GetString("(Do you want to update (U) or delete (D) student?", false);
                if (choice.equalsIgnoreCase("U")) {
                    manage.update(validID, st_list);
                    break;
                } else if (choice.equalsIgnoreCase("D")) {
                    manage.delete(validID, st_list);
                    break;
                } else {
                    System.out.println("Wrong input!!! Enter again!");
                }
            } while (true);
        }
    }

    public void report_st() {
        manage.report(st_list);
    }
}
