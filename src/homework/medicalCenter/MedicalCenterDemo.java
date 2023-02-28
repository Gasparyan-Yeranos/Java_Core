package homework.medicalCenter;

import homework.medicalCenter.enums.Profession;
import homework.medicalCenter.model.Doctor;
import homework.medicalCenter.model.Patient;
import homework.medicalCenter.model.Person;

import homework.medicalCenter.storage.PersonStorage;
import homework.medicalCenter.util.DateUtil;
import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

//0B_001,John,Smith,doc@gmail.com,012345678,dentist

public class MedicalCenterDemo implements Commands{

    public static PersonStorage list = new PersonStorage();
    public static Scanner scanner = new Scanner(System.in);

    public static void addDoctor(){
        System.out.println("Professions:");
        for (Profession profession: Profession.values()) {
            System.out.println("    " + profession);
        }

        System.out.println("Input doctor ID, name, surname, email, phone number and profession:");
        String doctorStr = scanner.nextLine();
        String doctorData[] = doctorStr.split(",");
        boolean found = false;
        for (Profession profession: Profession.values()) {
            if(profession.toString()==doctorData[5]){
                found = true;
                break;
            }
        }
        if(!found){
            System.out.println("Wrong profession chosen.");
            System.out.println("Try again.");
            return;
        }
        Doctor doctor = list.getDoctorByID(doctorData[0]);
        if(doctor == null){
            list.add(new Doctor(doctorData[0], doctorData[1], doctorData[2], doctorData[3], doctorData[4], doctorData[5]) );
            System.out.println( "Doctor " + doctorData[1] + " " + doctorData[2] + " was added to the list." );
        }else{
            System.out.println( "Doctor with ID " + doctorData[0] + " already exists.");
        }
    }
    public static void searchDoctorsByProfession(){
        if(list.getSize()==0){
            System.out.println("Input doctors first.");
            return;
        }
        System.out.println("Input position.");
        String profession = scanner.nextLine();
        list.printDoctorsByProfession(profession);
    }
    public static void deleteDoctorByID(){
        System.out.println("Input doctor ID");
        String ID = scanner.nextLine();
        Person doctor = list.getDoctorByID(ID);
        if(doctor == null){
            System.out.println("No doctors with ID " + ID + " were found.");
            return;
        }
        list.pop(doctor);
        System.out.println("Doctor deleted.");
        list.deletePatientsByDoctor(doctor);
    }
    public static void changeDoctorDataByID(){
        System.out.println("Input doctor ID.");
        String ID = scanner.nextLine();
        Doctor doctor = list.getDoctorByID(ID);
        if(doctor == null){
            System.out.println("No doctors with ID " + ID + " were found.");
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
    public static void addPatient() throws ParseException {
        list.printDoctors();
        System.out.println("Input patient ID, name, surname, phone, doctor ID and registration time(dd/MM/yyyy hh:mm):");
        String patientStr = scanner.nextLine();
        String patientData[] = patientStr.split(",");
        if(list.getDoctorByID(patientData[4]) == null){
            System.out.println("No doctors with ID " + patientData[4] + " were found.");
        }else if(!list.isDoctorAvailable(list.getDoctorByID(patientData[4]), DateUtil.stringToDate(patientData[5])) ) {
            System.out.println("The doctor isn't available at that time.");
        }else{
            Patient patient = new Patient();
            try {
                patient = new Patient(patientData[0], patientData[1], patientData[2], patientData[3], list.getDoctorByID(patientData[4]), patientData[5]);
            }catch (ParseException p){
                System.out.println("Wrong data format input, try again.");
            }
            list.add(patient);
            System.out.println("Patient was added to the list.");
        }
    }
    public static void printPatientsByDoctor(){
        System.out.println("Input doctor ID.");
        String ID = scanner.nextLine();
        Doctor doctor = list.getDoctorByID(ID);
        if(doctor == null){
            System.out.println("No doctors with ID " + ID + " were found.");
            return;
        }
        list.printPatientsByDoctor(doctor);
    }
    public static void printTodayPatients(){
        list.printTodayPatients();
    }

    public static void main(String[] args) throws ParseException {
        list.add(new Doctor("0A_001","John","Smith","doc@gmail.com","012345678","PSYCHIATRISTS"));
        list.add(new Doctor("0A_002","John","Smith","doc@gmail.com","012345678","PSYCHIATRISTS"));
        list.add(new Doctor("0A_003","John","Smith","doc@gmail.com","012345678","PSYCHIATRISTS"));
        list.add(new Doctor("0A_004","John","Smith","doc@gmail.com","012345678","PSYCHIATRISTS"));
        list.add(new Doctor("0A_005","John","Smith","doc@gmail.com","012345678","PSYCHIATRISTS"));
        list.add(new Doctor("0A_006","John","Smith","doc@gmail.com","012345678","PSYCHIATRISTS"));
        list.add(new Doctor("0A_007","John","Smith","doc@gmail.com","012345678","PSYCHIATRISTS"));
        list.add(new Doctor("0A_008","John","Smith","doc@gmail.com","012345678","PSYCHIATRISTS"));
        list.add(new Doctor("0A_009","John","Smith","doc@gmail.com","012345678","PSYCHIATRISTS"));
        list.add(new Doctor("0A_010","John","Smith","doc@gmail.com","012345678","PSYCHIATRISTS"));
        list.add(new Doctor("0A_011","John","Smith","doc@gmail.com","012345678","PSYCHIATRISTS"));
        list.add(new Doctor("0A_012","John","Smith","doc@gmail.com","012345678","PSYCHIATRISTS"));
        boolean isRun = true;
        while(isRun){
            Commands.printCommands();
            String choose = scanner.nextLine();
            switch (choose){
                case EXIT: isRun = false;                                              break;
                case ADD_DOCTOR: addDoctor();                                          break;
                case SEARCH_DOCTORS_BY_POSITION: searchDoctorsByProfession();          break;
                case DELETE_DOCTOR: deleteDoctorByID();                                break;
                case CHANGE_DOCTOR_DATA: changeDoctorDataByID();                       break;
                case ADD_PATIENT: addPatient();                                        break;
                case PRINT_PATIENTS_BY_DOCTOR: printPatientsByDoctor();                break;
                case PRINT_TODAY_PATIENTS: printTodayPatients();                       break;
                default: System.out.println("wrong input.");
            }
        }

    }
}
