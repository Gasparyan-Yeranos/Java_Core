package homework.medicalCenter.storage;

import homework.medicalCenter.Commands;
import homework.medicalCenter.model.Doctor;
import homework.medicalCenter.model.Person;

import java.util.Scanner;

public class DoctorStorage extends Storage{
    Person storage[] = super.getStorage();
    public Scanner scanner = new Scanner(System.in);
    public void searchByProfession(){
        if(getSize()==0){
            System.out.println("Input doctors first.");
            return;
        }
        boolean found = false;
        System.out.println("Input position.");
        String profession = scanner.nextLine();
        for (int i = 0; i < getSize(); i++) {
            if(storage[i].getProfession().equals(profession)){
                System.out.println(storage[i]);
                found = true;
            }
        }
        if(!found){
            System.out.println("No " + profession + " doctors were found.");
        }
    }
    public void deleteByID(){
        System.out.println("Input ID.");
        String ID = scanner.nextLine();
        if(getByID(ID) == null){
            System.out.println("No doctors by ID " + ID + " were found.");
            return;
        }
        pop(ID);
        System.out.println("Doctor was removed from the list.");
    }

    public void changeByID() {
        System.out.println("Input doctor ID.");
        String ID = scanner.nextLine();
        Doctor doctor = (Doctor) getByID(ID);
        if(doctor == null){
            System.out.println("No doctors by ID " + ID + " were found.");
            return;
        }

        boolean isRun = true;
        while(isRun){
            System.out.println("0 - exit" +
                "\n1 - change name" +
                "\n2 - change surname" +
                "\n3 - change email" +
                "\n4 - change phone number" +
                "\n5 - change profession");
            String choose = scanner.nextLine();
            switch (choose){
                case "0": isRun = false;                             break;
                case "1": doctor.setName(scanner.nextLine());        break;
                case "2": doctor.setSurname(scanner.nextLine());     break;
                case "3": doctor.setEmail(scanner.nextLine());       break;
                case "4": doctor.setPhone(scanner.nextLine());       break;
                case "5": doctor.setProfession(scanner.nextLine());  break;
                default: System.out.println("Wrong input");
            }
        }
    }
}
