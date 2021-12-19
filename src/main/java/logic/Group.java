package logic;

import java.util.ArrayList;

public class Group{
    public ArrayList<Student> students = new ArrayList<>();
    private String groupName;
    public double[] monthPayment = new double[12];

    public void addMonthPayment(int month, double amount) {
        monthPayment[month-1] = amount;
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

}
