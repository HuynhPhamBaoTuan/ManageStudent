package Model;

import java.util.Comparator;

public class Student implements Comparator<Student> {

    private int ID;
    private String name;
    private int semester;
    private String course;

    public Student(int ID, String name, int semester, String course) {
        this.ID = ID;
        this.name = name;
        this.semester = semester;
        this.course = course;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public int getSemester() {
        return semester;
    }

    public String getCourse() {
        return course;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void print() {
        System.out.println(ID + " | " + name + " | " + semester + " | " + course);
    }

    @Override
    public int compare(Student st1, Student st2) {
        return st1.getName().compareTo(st2.getName());
    }
}
