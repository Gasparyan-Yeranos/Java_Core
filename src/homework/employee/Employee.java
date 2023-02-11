package homework.employee;

import java.util.Locale;
import java.util.Objects;

public class Employee {
    private String name = "Unknown";
    private String surename = "Unknown";
    private String empleyeeID = "Unknown";
    private String salery = "Unknown";
    private String company = "Unknown";
    private String position = "Unknown";

    public String getName() {
        return this.name;
    }
    public String getSurename() {
        return this.surename;
    }
    public String getEmpleyeeID() {
        return this.empleyeeID;
    }
    public String getSalery() {
        return this.salery;
    }
    public String getCompany() {
        return this.company;
    }
    public String getPosition() {
        return this.position;
    }


    public void setName(String name) {
        this.name = name;
    }
    public void setSurename(String surename) {
        this.surename = surename;
    }
    public void setEmpleyeeID(String empleyeeID) {
        this.empleyeeID = empleyeeID;
    }
    public void setSalery(String salery) {
        this.salery = salery;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    public void setPosition(String position) {
        this.position = position;
    }

    public Employee(String name, String surename, String empleyeeID, String salery, String company, String position){
        this.name = name;
        this.surename =surename;
        this.empleyeeID = empleyeeID;
        this.salery = salery;
        this.company =company;
        this.position = position;
    }
    public Employee(){}

    @Override
    public String toString() {
        return ("Name: " + name + "\n" +
                "Surename: " + surename + "\n" +
                "Employee ID: " + empleyeeID + "\n" +
                "Salery: " + salery + "\n" +
                "Company: " + company + "\n" +
                "Position: " + position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return salery == employee.salery &&
                Objects.equals(name, employee.name) &&
                Objects.equals(surename, employee.surename) &&
                Objects.equals(empleyeeID, employee.empleyeeID) &&
                Objects.equals(company, employee.company) &&
                Objects.equals(position, employee.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surename, empleyeeID, salery, company, position);
    }

}
