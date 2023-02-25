package homework.employee;

import homework.employee.model.Company;
import homework.employee.model.Employee;
import homework.employee.storage.CompanyStorage;
import homework.employee.storage.EmployeeStorage;
import java.util.Date;
import java.text.ParseException;
import java.util.Scanner;

public class EmployeeDemo implements Commands{
    static Scanner scanner = new Scanner(System.in);
    static EmployeeStorage employeeList = new EmployeeStorage();
    static CompanyStorage companyStorage = new CompanyStorage();
    static void printCommands(){
        System.out.println("Exit-------------------------------" + EXIT);
        System.out.println("Add employee-----------------------" + ADD_EMPLOYEE);
        System.out.println("Print all employee-----------------" + PRINT_EMPLOYEES);
        System.out.println("Search employee by employee Id-----" + PRINT_EMPLOYEES_BY_ID);
        System.out.println("Search employee by company---------" + PRINT_EMPLOYEES_BY_COMPANY);
        System.out.println("Search employees by salary---------" + PRINT_EMPLOYEES_BY_SALARY);
        System.out.println("Change employee's position by ID---" + CHANGE_POSITION_BY_ID);
        System.out.println("Print only active employees--------" + PRINT_EMPLOYEES_IF_ACTIVE);
        System.out.println("set employee as inactive by ID-----" + INACTIVATE_BY_ID);
        System.out.println("set employee as active by ID-------" + ACTIVATE_BY_ID);
        System.out.println("add company------------------------" + ADD_COMPANY);
        System.out.println("print companies--------------------" + PRINT_COMPANIES);
    }
    public static void addEmployee() throws ParseException {
        if(companyStorage.getSize() == 0){
            System.out.println("input companies first.");
            return;
        }
        companyStorage.print();
        System.out.println("input company ID.");
        Company companyObj = companyStorage.companyByID( scanner.nextLine() );
        System.out.println("Input name, surname, birthday date(dd/mm/yyyy), employee ID, salary, profession");
        String employeeDataStr = scanner.nextLine();
        String[] employeeData = employeeDataStr.split(", ");
        Employee employee = employeeList.getEmployeeByID(employeeData[2]);
        if(employee == null){
            Employee newEmployee = new Employee(employeeData[0],
                    employeeData[1],
                    employeeData[2],
                    employeeData[3],
                    employeeData[4],
                    companyObj,
                    employeeData[5],
                    new Date());
            employeeList.add(newEmployee);
            companyObj.setEmployees( companyObj.getEmployees() + 1 );
            System.out.println("Employee was added to the list.");

        }else{
            System.err.println("Employee with ID \"" + "\" already exists:");
            System.err.println(employee);
        }
    }
    public static void addCompany(){
        System.out.println("Input company name, ID, address, phoneNumber");
        String companyStr = scanner.nextLine();
        String company[] = companyStr.split(", ");
        if(companyStorage.companyByID(company[1]) == null){
            companyStorage.add(new Company(company[0], company[1], company[2], company[3]));
            System.out.println("Company added.");
        }else{
            System.out.println("Company with ID \"" + company[1] + "\" already exists.");
        }
    }

    public static void main(String[] args) throws ParseException {
        Company company1 = new Company("Google", "AF0_5T", "some street", "012345678");
        employeeList.add( new Employee("Erik",  "Gasparyan", "29/04/1978",  "0A_001",  "600",  company1,     "Manager",       new Date()) );
        employeeList.add( new Employee("John",  "Smith",     "29/12/1999",  "9B_013",  "200",  company1,      "Worker",        new Date()) );
        employeeList.add( new Employee("Anna",  "Smith",     "31/01/1985",  "3K_114",  "250",  company1,  "Office worker", new Date()) );
        boolean isRun = true;
        while(isRun){
            System.out.println();
            printCommands();
            String choose = scanner.nextLine();
            switch (choose){
                case EXIT:                        isRun = false;                           break;
                case ADD_EMPLOYEE:                addEmployee();                           break;
                case PRINT_EMPLOYEES:             employeeList.print();                    break;
                case PRINT_EMPLOYEES_BY_ID:       employeeList.printByID();                break;
                case PRINT_EMPLOYEES_BY_COMPANY:  employeeList.printByCompany(companyStorage.companyByID(scanner.nextLine())); break;
                case PRINT_EMPLOYEES_BY_SALARY:   employeeList.printBySalary();            break;
                case CHANGE_POSITION_BY_ID:       employeeList.changePositionByID();       break;
                case PRINT_EMPLOYEES_IF_ACTIVE:   employeeList.printByStatus(true);  break;
                case INACTIVATE_BY_ID:            employeeList.inactivateByID();           break;
                case ACTIVATE_BY_ID:              employeeList.activateByID();             break;
                case ADD_COMPANY:                 addCompany();                            break;
                case PRINT_COMPANIES:             companyStorage.print();                  break;
                default: System.err.println("Wrong index, try again.");
            }
        }
    }

}
