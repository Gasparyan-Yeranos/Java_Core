package homework.medicalCenter.model;

import homework.medicalCenter.util.DateUtil;

import java.text.ParseException;
import java.util.Date;
import java.util.Objects;

public class Patient extends Person{
    Doctor doctor;
    Date registerDate;

    public Patient(){}
    public Patient(String ID, String name, String surname, String phone, Doctor doctor, String registerDate) throws ParseException {
        super(name, surname, ID, phone);
        this.doctor = doctor;
        this.registerDate = DateUtil.stringToDate(registerDate);
    }

    public Doctor getDoctor() {
        return doctor;
    }
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    public Date getRegisterDate() {
        return registerDate;
    }
    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "\n    Name: " + getName() +
                "\n    Surname: " + getSurname() +
                "\n    ID: " + getID() +
                "\n    Phone: " + getPhone() +
                "\n    Doctor: " + doctor.getName() +
                "\n    RegisterDate: " + DateUtil.dateToString(registerDate) +
                "\n}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Patient patient = (Patient) o;
        return Objects.equals(doctor, patient.doctor) && Objects.equals(registerDate, patient.registerDate);
    }
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), doctor, registerDate);
    }
}
