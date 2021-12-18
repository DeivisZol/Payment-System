package logic;

public class Group{
    Student[] students;
    protected String groupName;
    public double[] monthPayment = new double[12];

    public void addMonthPayment(int month, double amount) {
        monthPayment[month-1] = amount;
    }
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public String getGroupName() {
        return groupName;
    }
    public Student[] getStudents() {
        return students;
    }
}
