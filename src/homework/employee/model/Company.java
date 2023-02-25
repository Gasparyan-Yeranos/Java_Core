package homework.employee.model;

public class Company {
    private String id;
    private String name;
    private String address;
    private String phoneNumber;
    private int employees = 0;

    public Company(String name, String id, String address, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return id;
    }
    public String getName(){
        return name;
    }
    public String getAddress() {
        return address;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public int getEmployees() {
        return employees;
    }
    public void setEmployees(int employees) {
        this.employees = employees;
    }
    @Override
    public String toString() {
        return "Company{" +
                "    ID: " + id + "\n" +
                "    Name: " + name + "\n" +
                "    Address: '" + address + "\n" +
                "    Phone Number: '" + phoneNumber + "\'\n" +
                '}';
    }
}
