package logic;

public class Student {
    protected String name;
    protected String surname;
    protected int id;
    protected String group;


    public void Student(String name,String surname, int id, String group) {
        setGroup(group);
        setId(id);
        setName(name);
        setSurname(surname);
    }


    public void setGroup(String group) {
        this.group = group;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
