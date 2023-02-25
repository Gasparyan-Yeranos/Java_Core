package homework.medicalCenter;

import homework.medicalCenter.model.Doctor;
import homework.medicalCenter.model.Patient;
import homework.medicalCenter.storage.DoctorStorage;
import homework.medicalCenter.storage.PatientStorage;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class MedicalCenterDemo implements Commands{

    public static DoctorStorage doctorList = new DoctorStorage();
    public static PatientStorage patientList = new PatientStorage();
    public static Scanner scanner = new Scanner(System.in);

    public static void printCommands(){
        System.out.println(EXIT + " - exit \n" +
                ADD_DOCTOR + " - add doctor \n" +
                SEARCH_DOCTOR_BY_POSITION + " - search doctor by profession \n" +
                DELETE_DOCTOR + " - delete doctor by id \n" +
                CHANGE_DOCTOR_DATA + " - change doctor data by id \n" +
                ADD_PATIENT + " - add patient \n" +
                PRINT_PATIENTS_BY_DOCTOR + " - print all patients by doctor \n" +
                PRINT_TODAY_PATIENTS + " - print today's patients");
    }
    public static void addDoctor(){
        System.out.println("Input doctor ID, name, surname, email, phone number and profession:");
        String doctorStr = scanner.nextLine();
        String doctor[] = doctorStr.split(",");
        if(((Doctor) doctorList.getByID(doctor[0])) != null){

            System.out.println( "Doctor with ID " + doctor[0] + " already exists.");
        }else{
            System.out.println(doctorList.getByID(doctor[0]));
            doctorList.add(new Doctor(doctor[0], doctor[1], doctor[2], doctor[3], doctor[4], doctor[5]) );
            System.out.println( "Doctor " + doctor[1] + " " + doctor[2] + " was added to the list." );

        }
    }
    public static void addPatient() throws ParseException {
        doctorList.print();
        System.out.println("Input patient ID, name, surname, phone, doctor ID and registration date:");
        String patientStr = scanner.nextLine();
        String patient[] = patientStr.split(",");
        if(doctorList.getByID(patient[4]) == null){
            System.out.println("No doctors by ID " + patient[4] + " were found.");
        }else if( ((Doctor) doctorList.getByID(patient[4])).ifIsBusy() ) {
            System.out.println("The doctor is currently busy.");
        }else{
            Patient patient1 = new Patient(patient[0], patient[1], patient[2], patient[3], (Doctor) doctorList.getByID(patient[4]), patient[5]);
            patientList.add(patient1);
            ((Doctor) doctorList.getByID(patient[4])).getPatientList().add(patient1);
            System.out.println("Patient was added to the list.");
        }
    }
    public static void main(String[] args) throws ParseException {
        boolean isRun = true;
        while(isRun){
            printCommands();
            String choose = scanner.nextLine();
            switch (choose){
                case EXIT: isRun = false;                                              break;
                case ADD_DOCTOR: addDoctor();                                          break;
                case SEARCH_DOCTOR_BY_POSITION: doctorList.searchByProfession();       break;
                case DELETE_DOCTOR: doctorList.deleteByID();                           break;
                case CHANGE_DOCTOR_DATA: doctorList.changeByID();                      break;
                case ADD_PATIENT: addPatient();                                        break;
                case PRINT_PATIENTS_BY_DOCTOR: patientList.printByDoctor(doctorList);  break;
                case PRINT_TODAY_PATIENTS: patientList.printByDate(new Date());        break;
                default: System.out.println("wrong input.");
            }
        }

    }
}
