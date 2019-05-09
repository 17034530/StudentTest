package sg.edu.rp.c346.studenttest;

public class Student {
    private int id;
    private String name;
    private Double gpa;

    public Student(int id, String name, Double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    public int getId() {
        return id;
    }

    public String getname() {
        return name;
    }

    public Double getgpa() {
        return gpa;
    }
}
