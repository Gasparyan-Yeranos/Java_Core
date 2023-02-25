package homework.medicalCenter.model;

import homework.medicalCenter.storage.PatientStorage;

import java.util.Objects;

public class Doctor extends Person{
    private String email;
    private String profession;
    private boolean isBusy;     //բայց ես չեմ հասկացել, թե երբ է busy, երբ ոչ
    private PatientStorage patientList = new PatientStorage();
    public Doctor(){}
    public Doctor(String ID, String name, String surname, String email, String phone, String profession){
        super(name, surname, ID, phone);
        this.email = email;
        this.profession = profession;
        isBusy = false;
    }

    public void printPatients(){
        patientList.print();
    }


    public PatientStorage getPatientList() {
        return patientList;
    }
    public boolean ifIsBusy(){
        return isBusy;
    }
    public void setBusy(boolean isBusy){
        this.isBusy = isBusy;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getProfession() {
        return profession;
    }
    public void setProfession(String profession) {
        this.profession = profession;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Doctor doctor = (Doctor) o;
        return Objects.equals(email, doctor.email) && Objects.equals(profession, doctor.profession);
    }
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), email, profession);
    }
    @Override
    public String toString() {
        return "Doctor{" +
                "\n    Name: " + getName() +
                "\n    Surname: " + getSurname() +
                "\n    ID: " + getID() +
                "\n    Phone: " + getPhone() +
                "\n    email: " + email +
                "\n    profession: " + profession +
                "\n    is busy: " + isBusy +
                "\n}";
    }
}
