package homework.employee.storage;
import homework.employee.model.Company;
import homework.employee.model.Employee;

import java.util.Scanner;

public class CompanyStorage {
    private Company[] companies = new Company[10];
    int size = 0;
    int length = 10;
    public void add(Company employee) {
        if( size == length ){
            this.extend();
        }
        companies[size++] = employee;
    }
    private void extend() {
        length += 10;
        Company[] tmp = new Company[length];
        for (int i = 0; i < size; i++) {
            tmp[i] = companies[i];
        }
        companies = tmp;
        tmp = null;
    }
    public void SearchByCompany(Company company){
    }

    public int getSize() {
        return size;
    }

    public Company companyByID(String Id){
        for (int i = 0; i < size; i++) {
            if(Id == companies[i].getId()){
                return companies[i];
            }
        }
        return null;
    }
    public void print(){
        System.out.println();
        if(size==0){
            System.out.println("_______________________________");
            System.out.println("No companies have been input yet.");
        }
        for (int i = 0; i < size; i++) {
            System.out.println("_______________________________");
            System.out.println(companies[i]);
        }
        System.out.println("_______________________________");
    }

}
