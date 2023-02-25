package homework.employee.storage;

import homework.employee.model.Company;
import homework.employee.model.Employee;

import java.util.Scanner;

public class EmployeeStorage {
    Scanner scanner = new Scanner(System.in);
    private Employee[] employees = new Employee[10];
    int size = 0;
    int length = 10;
    public void add(Employee employee) {
        if( size == length ){
            this.extend();
        }
        employees[size++] = employee;
    }
    private void extend() {
        length += 10;
        Employee[] tmp = new Employee[length];
        for (int i = 0; i < size; i++) {
            tmp[i] = employees[i];
        }
        employees = tmp;
        tmp = null;
    }
    public void print(){
        System.out.println();
        if(size==0){
            System.out.println("_______________________________");
            System.out.println("No employees have been input yet.");
        }
        for (int i = 0; i < size; i++) {
            System.out.println("_______________________________");
            System.out.println(employees[i]);
        }
        System.out.println("_______________________________");
    }
    public void printByID(){
        System.out.println("input employee ID:");
        String employeeID = scanner.nextLine();
        for (int i = 0; i < size; i++) {
            if ( employees[i].getEmployeeID().equals(employeeID) ) {
                System.out.println("_______________________________");
                System.out.println(employees[i]);
                System.out.println("_______________________________");
                return;
            }
        }
        System.out.println("Employee with ID \"" + employeeID + "\" can't be found.");
    }
    public void printByCompany(Company company){

        boolean found = false;
        for (int i = 0; i < size; i++) {
            if ( employees[i].getCompany().equals(company) ) {
                System.out.println("_______________________________");
                System.out.println(employees[i]);
                System.out.println("_______________________________");
                found = true;
                break;
            }
        }
        if (!found){
            System.out.println("Employees working in \"" + company + "\" can't be found.");
        }
    }
    public Employee getEmployeeByID(String ID){
        for (int i = 0; i < size; i++) {
            if(employees[i].getEmployeeID().equals(ID)){
                return employees[i];
            }
        }
        return  null;
    }
    public void printByStatus(boolean active){
        System.out.println("_______________________________");
        for (int i = 0; i < size; i++) {
            if(employees[i].isActive() == active){
                System.out.println(employees[i]);
                System.out.println("_______________________________");
            }
        }
    }
    public void printBySalary(){
        System.out.println("Input min and max:");
        String salaryRangeStr = scanner.nextLine();
        String salaryRange[] = salaryRangeStr.split(",");
        double min = Double.parseDouble(salaryRange[0]);
        double max = Double.parseDouble(salaryRange[1]);
        if(min > max){
            System.out.println("Min can't be larger than max.");
            System.out.println("Try again.");
            return;
        }
        for (int i = 0; i < size; i++) {
            if( employees[i].getSalary()>=min && employees[i].getSalary()<=max ){
                System.out.println("_______________________________");
                System.out.println(employees[i]);
            }
        }
        System.out.println("_______________________________");
    }
    public void changePositionByID(){
        System.out.println("Input employee ID:");
        String ID = scanner.nextLine();
        Employee employeeTmp = getEmployeeByID(ID);
        if( employeeTmp != null ){
            System.out.println("Input new position name:");
            String positionName = scanner.nextLine();
            employeeTmp.setPosition(positionName);
            System.out.println("The position of employee with ID \"" + ID + "\" was changed to " + positionName);
        }else{
            System.out.println("Employee with ID \"" + ID + "\" can't be found.");
        }
    }
    public void inactivateByID(){
        printByStatus(true);
        System.out.println("Input employee ID:");
        String ID = scanner.nextLine();
        Employee employeeTmp = getEmployeeByID(ID);
        if( employeeTmp != null && employeeTmp.isActive()){
            employeeTmp.setActive(false);
            employeeTmp.getCompany().setEmployees( employeeTmp.getCompany().getEmployees() - 1 );
        }else{
            System.out.println("Active employees with ID \"" + ID + "\" can't be found.");
        }
    }
    public void activateByID(){
        printByStatus(false);
        System.out.println("Input employee ID:");
        String ID = scanner.nextLine();
        Employee employeeTmp = getEmployeeByID(ID);
        if( employeeTmp != null && !employeeTmp.isActive()){
            employeeTmp.setActive(true);
            employeeTmp.getCompany().setEmployees( employeeTmp.getCompany().getEmployees() + 1 );
        }else{
            System.out.println("Inactive employees with ID \"" + ID + "\" can't be found.");
        }
    }
}
