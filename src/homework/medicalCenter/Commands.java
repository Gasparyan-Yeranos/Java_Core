package homework.medicalCenter;

public interface Commands {
    static final String EXIT = "0";
    static final String ADD_DOCTOR = "1";
    static final String SEARCH_DOCTORS_BY_POSITION = "2";
    static final String DELETE_DOCTOR = "3";
    static final String CHANGE_DOCTOR_DATA = "4";
    static final String ADD_PATIENT = "5";
    static final String PRINT_PATIENTS_BY_DOCTOR = "6";
    static final String PRINT_TODAY_PATIENTS = "7";
    static void printCommands(){
        System.out.println(EXIT + " - exit \n" +
                ADD_DOCTOR + " - add doctor \n" +
                SEARCH_DOCTORS_BY_POSITION + " - search doctor by profession \n" +
                DELETE_DOCTOR + " - delete doctors by id \n" +
                CHANGE_DOCTOR_DATA + " - change doctor data by id \n" +
                ADD_PATIENT + " - add patient \n" +
                PRINT_PATIENTS_BY_DOCTOR + " - print all patients by doctor \n" +
                PRINT_TODAY_PATIENTS + " - print today's patients");
    }
}
