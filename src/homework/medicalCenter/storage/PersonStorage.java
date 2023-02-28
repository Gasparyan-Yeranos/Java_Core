package homework.medicalCenter.storage;

import homework.medicalCenter.model.Doctor;
import homework.medicalCenter.model.Patient;
import homework.medicalCenter.model.Person;
import homework.medicalCenter.util.DateUtil;

import java.util.Date;

public class PersonStorage {
    private Person[] storage = new Person[10];
    private int size = 0;
    private int length = 10;

    public int getSize() {
        return size;
    }

    public void add(Person a){
        storage[size++] = a;
        if(size == storage.length) {
            extend();
        }
    }
    private void extend(){
        length += 10;
        Person[] storageTmp = new Person[length];
        System.arraycopy(storage, 0, storageTmp, 0, storage.length);
        storage = storageTmp;

    }
    public void pop(Person person){
        int j = size;
        for (int i = 0; i < size; i++) {
            if(storage[i] == person){
                j = i;
                break;
            }
        }
        for (int i = j; i < size; i++) {
            storage[i] = storage[i+1];
        }

        size--;
    }
    public Doctor getDoctorByID(String ID){
        Doctor tmp = null;
        for (int i = 0; i < size; i++) {
            if(storage[i].getID().equals(ID) && storage[i] instanceof Doctor){
                tmp = (Doctor) storage[i];
                break;
            }
        }
        return tmp;
    }
    public void printDoctorsByProfession(String profession){
        boolean found = false;
        System.out.println(storage.length);
        for (int i = 0; i < size; i++) {
            if(storage[i] instanceof Doctor && ((Doctor) storage[i]).getProfession().contains(profession)){
                System.out.println(storage[i]);
                found = true;
            }
        }
        if(!found){
            System.out.println("No " + profession + " doctors were found.");
        }
    }
    public Patient getPatientByID(String ID){
        Patient tmp = null;
        for (int i = 0; i < size; i++) {
            if(storage[i].getID().equals(ID) && storage[i] instanceof Patient){
                tmp = (Patient) storage[i];
                break;
            }
        }
        return tmp;
    }
    public void printDoctors(){
        for (int i = 0; i < size; i++) {
            if(storage[i] instanceof Doctor){
                System.out.println(storage[i]);
            }
        }
    }
    public boolean isDoctorAvailable(Doctor doctor, Date registerDate){
        for (int i = 0; i < size; i++) {
            if(storage[i] instanceof Patient){
                Patient patient = (Patient) storage[i];
                if(patient.getDoctor().equals(doctor) && patient.getRegisterDate().equals(registerDate)){
                    return false;
                }
            }
        }
        return true;
    }

    public void deletePatientsByDoctor(String ID) {
        Boolean found = false;
        String patients = "";
        for (int i = 0; i <= size; i++) {
            Person patient = storage[i];
            if(patient instanceof Patient && ((Patient) patient).getDoctor().getID().equals(ID)){
                found = true;
                System.out.println(patient.getID());
                patients = patients.concat(patient.getID() + ", ");
                pop(patient);
                i--;
            }
        }
        if(found){
            System.out.println("Patients With ID " + patients + "\b\b were also deleted.");
            return;
        }
        System.out.println("No patients were deleted.");
    }

    public void printPatientsByDoctor(Doctor doctor) {
        boolean found = false;
        for (int i = 0; i < size; i++) {
            Person patient = storage[i];
            if(patient instanceof Patient && ((Patient) patient).getDoctor() == doctor){
                System.out.println(patient);
                found = true;
            }
        }
        if(!found){
            System.out.println("Patients weren't found.");
        }
    }

    public void printTodayPatients() {
        Date today = new Date();
        boolean found = false;
        for (int i = 0; i < size; i++) {
            Person patient = storage[i];
            if(patient instanceof Patient && DateUtil.isSameDate( ((Patient) patient).getRegisterDate(), today )){
                found = true;
                System.out.println(storage[i]);
            }
        }
        if(!found){
            System.out.println("No patient for today.");
        }
    }
}
