package homework.medicalCenter.model;

import homework.medicalCenter.enums.Profession;
import java.util.Objects;

public class Doctor extends Person{
    private String email;
    private Profession profession;
    public Doctor(){}
    public Doctor(String ID, String name, String surname, String email, String phone, String profession){
        super(name, surname, ID, phone);
        try {
            this.email = email;
            this.profession = Profession.valueOf(profession);
        }catch (IllegalArgumentException x){
            System.out.println("Wrong profession chosen.");
        }
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getProfession() {
        return profession.toString();
    }
    public void setProfession(String profession) {
        this.profession = Profession.valueOf(profession);
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
                "\n    profession: " + profession.toString().toLowerCase() +
                "\n}";
    }
}
