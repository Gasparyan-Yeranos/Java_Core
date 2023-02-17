package homework.employee;

import java.text.ParseException;
import java.util.Scanner;

public class EmployeeDemo {
    static Scanner scanner = new Scanner(System.in);
    static EmployeeStorage employeeList = new EmployeeStorage();
    static void printCommands(){
        System.out.println("Exit-------------------------------0");
        System.out.println("Add employee-----------------------1");
        System.out.println("Print all employee-----------------2");
        System.out.println("Search employee by employee Id-----3");
        System.out.println("Search employee by company---------4");
        System.out.println("Search employees by salary---------5");
        System.out.println("Change employee's position by ID---6");
        System.out.println("Print only active employees--------7");
        System.out.println("set employee as inactive by ID-----8");
        System.out.println("set employee as active by ID-------9");
    }
    public static void addEmployee() throws ParseException {
        System.out.println("Input name, surname, birth date, employee ID, salary, company, profession");
        String employeeDataStr = scanner.nextLine();
        String[] employeeData = employeeDataStr.split(", ");
        Employee employee = employeeList.getEmployeeByID(employeeData[2]);
        if(employee == null){
            Employee newEmployee = new Employee(employeeData[0],
                    employeeData[1],
                    employeeData[2],
                    employeeData[3],
                    employeeData[4],
                    employeeData[5],
                    employeeData[6]);
            employeeList.add(newEmployee);
            System.out.println("Employee was added to the list.");
        }else{
            System.err.println("Employee with ID \"" + "\" already exists:");
            System.err.println(employee);
        }
    }

    public static void main(String[] args) throws ParseException {
        employeeList.add( new Employee("Erik", "Gasparyan", "29/04/1978", "0A_002", "300", "Apple", "Manager") );
        employeeList.add( new Employee("John", "Smith", "29/12/1999", "9B_013", "200", "Google", "Worker") );
        employeeList.add( new Employee("Anna", "Smith", "31/01/1985", "3K_114", "250", "Microsoft", "Office worker") );
        boolean isRun = true;
        while(isRun){
            System.out.println();
            printCommands();
            String choose = scanner.nextLine();
            switch (choose){
                case "0": isRun = false;                           break;
                case "1": addEmployee();                           break;
                case "2": employeeList.print();                    break;
                case "3": employeeList.printByID();                break;
                case "4": employeeList.printByCompany();           break;
                case "5": employeeList.printBySalary();            break;
                case "6": employeeList.changePositionByID();       break;
                case "7": employeeList.printByStatus(true);  break;
                case "8": employeeList.inactivateByID();           break;
                case "9": employeeList.activateByID();             break;
                default: System.err.println("Wrong index, try again.");
            }
        }
    }

}
