package logic;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private List<Student> students = new ArrayList<>();
    private String groupName;
    private double[] monthPayment = new double[12];

    public void addMonthPayment(int month, double amount) {
        monthPayment[month - 1] = amount;
    }

    public void setGroupName(String groupNames) {
        groupName = groupNames;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public String getGroupName() {
        return groupName;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public double[] getMonthPayment() {
        return monthPayment;
    }

    public void setMonthPayment(double[] monthPayment) {
        this.monthPayment = monthPayment;
    }
}
