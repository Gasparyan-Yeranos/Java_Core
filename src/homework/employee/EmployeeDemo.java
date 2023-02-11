package homework.employee;

import java.util.Scanner;

public class EmployeeDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeStorage employeeList = new EmployeeStorage();
        Employee poxos = new Employee("Poxos", "Poxosyan", "0A_002", "$300", "Apple", "Worker");
        employeeList.add(poxos);
        boolean isRun = true;
        System.out.println();
        while(isRun){
            System.out.println("Add employee: 1 \n" +
                    "Print all employee: 2 \n" +
                    "Search employee by employee Id: 3 \n" +
                    "Search employee by company: 4 \n" +
                    "Exit: 0");
            String choose = scanner.nextLine();
            switch (choose){
                case "0":
                    isRun = false;
                    break;
                case "1":
                    System.out.println("Input name:");
                    String name = scanner.nextLine();
                    System.out.println("Input surename:");
                    String surename = scanner.nextLine();
                    System.out.println("Input employee Id:");
                    String employeeID = scanner.nextLine();
                    System.out.println("Input salary:");
                    String salary = scanner.nextLine();
                    System.out.println("Input company:");
                    String company = scanner.nextLine();
                    System.out.println("Input position:");
                    String position = scanner.nextLine();
                    Employee employee = new Employee(name, surename, employeeID, salary, company, position);
                    employeeList.add(employee);
                    System.out.println("Employee added to the list");
                    break;
                case "2":
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
                default: System.out.println("Wrong index, try again.");
            }
            System.out.println("\n");
        }
    }

}
