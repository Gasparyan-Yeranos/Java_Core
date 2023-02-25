package homework.medicalCenter.storage;

import homework.medicalCenter.model.Doctor;
import homework.medicalCenter.model.Patient;
import homework.medicalCenter.model.Person;
import homework.medicalCenter.util.DateUtil;

import java.util.Date;
import java.util.Scanner;

public class PatientStorage extends Storage{
    private Person[] storage = super.getStorage();
    Scanner scanner = new Scanner(System.in);
    public void printByDoctor(DoctorStorage storage){
        System.out.println("Input doctor ID.");
        String doctorID = scanner.nextLine();
        if(storage.getByID(doctorID)==null){
            System.out.println("No doctors by ID " + doctorID + " were found.");
            return;
        }
        ((Doctor) storage.getByID(doctorID)).printPatients();


    }

    public void printByDate(Date date){
        for (int i = 0; i < getSize(); i++) {
            if(DateUtil.dateToString(((Patient) storage[i]).getRegisterDate()) == DateUtil.dateToString(date)) {
                System.out.println(storage[i]);
            }
        }
    }
}
