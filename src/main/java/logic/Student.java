package logic;

public class Student {
    private String name;
    private String surname;
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Student)) {
            return false;
        }
        return ((Student)(obj)).getId() == this.id;
    }

    @Override
    public int hashCode() {
        return this.id;
    }
}
