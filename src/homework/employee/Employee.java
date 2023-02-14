package homework.employee;

import java.util.Locale;
import java.util.Objects;

public class Employee {
    private String name = "Unknown";
    private String surname = "Unknown";
    private String empleyeeID = "Unknown";
    private double salary = 0.0;
    private String company = "Unknown";
    private String position = "Unknown";
    private boolean active = true;

    public Employee(){}
    public Employee(String name, String surename, String empleyeeID, String salary, String company, String position){
        this.name = name;
        this.surname =surename;
        this.empleyeeID = empleyeeID;
        this.salary = Double.parseDouble(salary);
        this.company =company;
        this.position = position;
    }

    public String getName() {
        return this.name;
    }
    public String getSurname() {
        return this.surname;
    }
    public String getEmpleyeeID() {
        return this.empleyeeID;
    }
    public double getSalary() {
        return this.salary;
    }
    public String getCompany() {
        return this.company;
    }
    public String getPosition() {
        return this.position;
    }
    public boolean isActive() {
        return active;
    }



    public void setName(String name) {
        this.name = name;
    }
    public void setSurname(String surename) {
        this.surname = surename;
    }
    public void setEmpleyeeID(String empleyeeID) {
        this.empleyeeID = empleyeeID;
    }
    public void setSalary(double salery) {
        this.salary = salery;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Employee{\n" +
                "    Name: '" + name + "'\n" +
                "    Surname: '" + surname + "'\n" +
                "    EmpleyeeID : '" + empleyeeID + "'\n" +
                "    Salary: " + salary + "'\n" +
                "    Company: '" + company + "'\n" +
                "    Position: '" + position + "'\n" +
                "    Active: '" + active + "'\n" +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return salary == employee.salary &&
                Objects.equals(name, employee.name) &&
                Objects.equals(surname, employee.surname) &&
                Objects.equals(empleyeeID, employee.empleyeeID) &&
                Objects.equals(company, employee.company) &&
                Objects.equals(position, employee.position) &&
                Objects.equals(active, employee.active);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, surname, empleyeeID, salary, company, position, active);
    }

}
