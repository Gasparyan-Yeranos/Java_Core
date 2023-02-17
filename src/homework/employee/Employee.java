package homework.employee;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Employee {
    private String name;
    private String surname;
    private String employeeID;
    private double salary;
    private String company;
    private String position;
    private boolean active;
    private Date dateOfBirth = new Date();
    private Date dateOfRegister = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    public Employee(){}
    public Employee(String name, String surname, String dateOfBirthday, String employeeID, String salary, String company, String position) throws ParseException {
        this.name = name;
        this.surname = surname;
        this.employeeID = employeeID;
        this.salary = Double.parseDouble(salary);
        this.company = company;
        this.position = position;
        this.active = true;
        this.dateOfRegister = new Date();
        this.dateOfBirth = sdf.parse(dateOfBirthday);
    }
    public String getName() {
        return this.name;
    }
    public String getSurname() {
        return this.surname;
    }
    public String getEmployeeID() {
        return this.employeeID;
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
    };
    public Date getDateOfRegister(){
        return  dateOfRegister;
    }
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }
    public void setSalary(double salary) {
        this.salary = salary;
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
                "    Name: " + name + "\n" +
                "    Surname: " + surname + "\n" +
                "    EmployeeID : " + employeeID + "\n" +
                "    Salary: " + salary + "\n" +
                "    Company: " + company + "\n" +
                "    Position: " + position + "\n" +
                "    Active: " + active + "\n" +
                "    Birthday: " + sdf.format(dateOfBirth) + "\n" +
                "    Registered in: " + dateOfRegister + "\n" +
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
                Objects.equals(employeeID, employee.employeeID) &&
                Objects.equals(company, employee.company) &&
                Objects.equals(position, employee.position) &&
                Objects.equals(active, employee.active) &&
                Objects.equals(dateOfBirth, employee.dateOfBirth) &&
                Objects.equals(dateOfRegister, employee.dateOfRegister);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, surname, employeeID, salary, company, position, active, dateOfBirth, dateOfRegister);
    }
}
