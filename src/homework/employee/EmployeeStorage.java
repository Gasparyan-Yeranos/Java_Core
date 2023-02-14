package homework.employee;

public class EmployeeStorage {
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
        if(size==0){
            System.out.println("_______________________________");
            System.out.println("No employees have been inputed yet.");
        }
        for (int i = 0; i < size; i++) {
            System.out.println("_______________________________");
            System.out.println(employees[i]);
        }
        System.out.println("_______________________________");
    }
    public void printByID(String employeeID){
        for (int i = 0; i < size; i++) {
            if ( employees[i].getEmpleyeeID().equals(employeeID) ) {
                System.out.println("_______________________________");
                System.out.println(employees[i]);
                System.out.println("_______________________________");
                return;
            }
        }
        System.out.println("Employee with ID \"" + employeeID + "\" can't be found.");
    }
    public void printByCompany(String company){
        boolean found = false;
        for (int i = 0; i < size; i++) {
            if ( employees[i].getCompany().equals(company) ) {
                System.out.println("_______________________________");
                System.out.println(employees[i]);
                System.out.println("_______________________________");
                found = true;
            }
        }
        if (!found){
            System.out.println("Employees working in \"" + company + "\" can't be found.");
        }
    }
    public Employee getEmployeeByID(String ID){
        for (int i = 0; i < size; i++) {
            if(employees[i].getEmpleyeeID().equals(ID)){
                return employees[i];
            }
        }
        return  null;
    }
    public void printIfIsActive(){
        for (int i = 0; i < size; i++) {
            if(employees[i].isActive()){
                System.out.println(employees[i]);
            }
        }
    }
    public void printBysalary(String a, String b){
        double salary1 = Double.parseDouble(a);
        double salary2 = Double.parseDouble(b);
        for (int i = 0; i < size; i++) {
            if( (employees[i].getSalary()>=salary2 && employees[i].getSalary()<=salary1) ||
                (employees[i].getSalary()>salary1 && employees[i].getSalary()<salary2) ){
                System.out.println("_______________________________");
                System.out.println(employees[i]);
            }
        }
        System.out.println("_______________________________");
    }
}
