package View;

import Controller.Manager;
import Controller.MnStudent;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Manager manager = new Manager();
        
        boolean loop = true;
        while (loop) {
            menu.add("1. Create new student");
            menu.add("2. Find and sort");
            menu.add("3. Update or delete");
            menu.add("4. Report");
            menu.add("5. Exit");
            
            menu.print();
            int choice = menu.getUserChoices();
            MnStudent mnStudent = new MnStudent();
            
            switch (choice) {
                case 1:
                    mnStudent.CreateNewStudent();
                    break;
                case 2:
                    mnStudent.Find_and_Sort();
                    break;
                case 3:
                    mnStudent.Update_or_Delete();
                    break;
                case 4:
                    mnStudent.report_st();
                    break;
                case 5:
                    loop = false;
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}