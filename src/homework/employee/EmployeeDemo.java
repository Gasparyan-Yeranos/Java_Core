package homework.employee;

import java.util.Scanner;

public class EmployeeDemo {
    static Scanner scanner = new Scanner(System.in);
    static EmployeeStorage employeeList = new EmployeeStorage();
    public static void addEmployee(){
        System.out.println("Input name, surname, employee ID, salary, company, office worker");
        String employeeDataStr = scanner.nextLine();
        String[] employeeData = employeeDataStr.split(", ");
        Employee employee = employeeList.getEmployeeByID(employeeData[2]);
        if(employee == null){
            Employee newEmployee = new Employee(employeeData[0],
                    employeeData[1],
                    employeeData[2],
                    employeeData[3],
                    employeeData[4],
                    employeeData[5]);
            employeeList.add(newEmployee);
            System.out.println("Employee was added to the list.");
        }else{
            System.err.println("Employee with ID \"" + "\" already exists:");
            System.err.println(employee);
        }
    }
    public static void main(String[] args) {
        Employee poxos = new Employee("Poxos", "Poxosyan", "0A_002", "300", "Apple", "Worker");
        Employee employeeTmp;
        employeeList.add(poxos);
        boolean isRun = true;
        System.out.println();
        while(isRun){
            System.out.println("Add employee: 1 \n"  +
                               "Print all employee: 2 \n"  +
                               "Search employee by employee Id: 3 \n"  +
                               "Search employee by company: 4 \n"  +
                               "Search employees by salary: 5 \n"  +
                               "Change employee's position by ID: 6 \n" +
                               "Print only active employees: 7 \n" +
                               "set employee as not active by ID: 8 \n" +
                               "set employee as active by ID: 9 \n" +
                               "Exit: 0");
            String choose = scanner.nextLine();
            switch (choose){
                case "0":
                    isRun = false;
                    break;
                case "1":
                    addEmployee();
                    break;
                case "2":
                    System.out.println();
                    employeeList.print();
                    break;
                case "3":
                    System.out.println("input employee ID:");
                    String ID = scanner.nextLine();
                    employeeList.printByID(ID);
                    break;
                case "4":
                    System.out.println("Input company name:");
                    String companyName = scanner.nextLine();
                    employeeList.printByCompany(companyName);
                    break;
                case "5":
                    System.out.println("Input salary borders:");
                    String salary1 = scanner.nextLine();
                    String salary2 = scanner.nextLine();
                    employeeList.printBysalary(salary1, salary2);
                    break;
                case "6":
                    System.out.println("Input employee ID:");
                    String ID1 = scanner.nextLine();
                    employeeTmp = employeeList.getEmployeeByID(ID1);
                    if( employeeTmp != null ){
                        System.out.println("Input new position name:");
                        String positionName = scanner.nextLine();
                        employeeTmp.setPosition(positionName);
                        System.out.println("The position of employee with ID \"" + ID1 + "\" was changed to " + positionName);
                    }else{
                        System.out.println("Employee with ID \"" + ID1 + "\" can't be found.");
                    }
                    break;
                case "7":
                    employeeList.printIfIsActive();
                case "8":
                    System.out.println("Input employee ID:");
                    String ID2 = scanner.nextLine();
                    employeeTmp = employeeList.getEmployeeByID(ID2);
                    if( employeeTmp != null ){
                        employeeTmp.setActive(false);
                        System.out.println("Employee with ID \"" + ID2 + "\" is not active anymore.");
                    }else{
                        System.out.println("Active employees with ID \"" + ID2 + "\" can't be found.");
                    }
                    break;
                case "9":
                    System.out.println("Input employee ID:");
                    String ID3 = scanner.nextLine();
                    employeeTmp = employeeList.getEmployeeByID(ID3);
                    if( employeeTmp != null  && !employeeTmp.isActive() ){
                        employeeList.getEmployeeByID(ID3).setActive(true);
                        System.out.println("Employee with ID \"" + ID3 + "\" is active again.");
                    }else{
                        System.out.println("Not active employees with ID \"" + ID3 + "\" can't be found.");
                    }
                    break;
                default: System.err.println("Wrong index, try again.");
            }
            System.out.println("\n");
        }
    }

}
