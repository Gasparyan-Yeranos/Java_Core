package homework.medicalCenter.model;

import java.util.Objects;

public class Person {
    private String ID;
    private String name;
    private String surname;
    private String phone;

    public Person(){}
    public Person(String name, String surname, String ID, String phone) {
        this.name = name;
        this.surname = surname;
        this.ID = ID;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getID() {
        return ID;
    }
    public void setID(String ID) {
        this.ID = ID;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    @Override
    public String toString() {
        return "Person{" +
                "\n    Name='" + name +
                "\n    Surname='" + surname +
                "\n    ID='" + ID +
                "\n    Phone='" + phone +
                "\n}";
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(surname, person.surname) && Objects.equals(ID, person.ID) && Objects.equals(phone, person.phone);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, surname, ID, phone);
    }


}
