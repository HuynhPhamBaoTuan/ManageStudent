package Controller;

import Common.Utility;
import Model.Student;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class Manager {

    public void findbyName(String name, ArrayList<Student> st_list) {
        boolean exist = false;
        for (Student st : st_list) {
            if (st.getName().equals(name) || st.getName().contains(name)) {
                st.print();
                exist = true;
            }
        }
        if (exist == false) {
            System.out.print("Student does not exist!");
        }
    }

    public void sort(ArrayList<Student> st_list, Student st) {
        Collections.sort(st_list, st);
    }

    public void print(ArrayList<Student> st_list) {
        for (Student st : st_list) {
            System.out.println(st.getName() + " | " + st.getSemester() + " | " + st.getCourse());
        }
        System.out.println();
    }

    public int findbyID(int id, ArrayList<Student> st_list) {
        for (Student st : st_list) {
            if (st.getID() == id) {
                st.print();
                return id;
            }
        }
        return 0;
    }

    public void update(int id, ArrayList<Student> st_list) {
        String name, course;
        int semester;
        for (Student st : st_list) {
            if (st.getID() == id) {
                name = Utility.GetString("Update student's name: ", false);
                st.setName(name);
                semester = Utility.getInt("Update student's semester: ");
                st.setSemester(semester);
                course = Utility.GetString("Update student's course: ", false);
                st.setCourse(course);
            }
        }
    }

    public void delete(int id, ArrayList<Student> st_list) {
        Iterator itr = st_list.iterator();
        while (itr.hasNext()) {
            Student st = (Student) itr.next();
            if (st.getID() == id) {
                itr.remove();
                System.out.println("Delete is done !!");
            }
        }
    }

    public void report(ArrayList<Student> st_list) {
        ArrayList<String> st_strlist = new ArrayList<>();
        for (Student st : st_list) {
            st_strlist.add(st.getName() + "|" + st.getCourse());
        }
        Set<String> st_strset = new HashSet<>(st_strlist);
        ArrayList<String> cour_report = new ArrayList<>();
        Iterator itr = st_strset.iterator();
        while (itr.hasNext()) {
            String row = (String) itr.next();
            cour_report.add(row + "|" + Collections.frequency(st_strlist, row));
        }
        for (String str : cour_report) {
            System.out.println(str);
        }
    }
}
