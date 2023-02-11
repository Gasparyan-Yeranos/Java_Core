package homework.employee;

public class EmployeeStorage {
    Employee[] array = new Employee[10];
    int size = 0;
    int length = 10;
    public void add(Employee value) {
        if( size == length ){
            this.extend();
        }
        array[size++] = value;

    }
    private void extend() {
        length += 10;
        Employee[] newArray = new Employee[length];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
        newArray = null;
    }
    public void print(){
        if(size==0){
            System.out.println("_______________________________");
            System.out.println("No employees have been inputed yet.");
        }
        for (int i = 0; i < size; i++) {
            System.out.println("_______________________________");
            System.out.println(array[i]);
        }
        System.out.println("_______________________________");
    }
    public void printByID(String employeeID){
        for (int i = 0; i < size; i++) {
            if (array[i].getEmpleyeeID() == employeeID) {
                System.out.println("_______________________________");
                System.out.println(array[i]);
                return;
            }
        }
        System.out.println("Employee with ID " + employeeID + " can't be found.");
    }
    public void printByCompany(String company){
        boolean found = false;
        for (int i = 0; i < size; i++) {
            if (array[i].getCompany() == company) {
                System.out.println("_______________________________");
                System.out.println(array[i]);
                found = true;
            }else{
                System.out.println( "array[i].getCompany() == " + array[i].getCompany() );
                System.out.println( "company == " + company );
            }
        }
        if (!found){
            System.out.println("Employees working in " + company + " can't be found.");
        }
    }
}
