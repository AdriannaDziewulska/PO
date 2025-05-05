import java.util.Objects;

public class Person {
    private String name;
    private String phoneNumber;
    private String emailAdress;

    public Person(String name, String phoneNumber, String emailAdress) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Imię nie może być puste");
        }
        if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Numer telefonu nie może być pusty");
        }
        if (emailAdress == null || emailAdress.trim().isEmpty() || !emailAdress.contains("@")) {
            throw new IllegalArgumentException("Niepoprawny adres e-mail");
        }
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAdress = emailAdress;
    }

    public String getName() {return name;}
    public String getPhoneNumber() {return phoneNumber;}
    public String getEmailAdress() {return emailAdress;}

    public void setName(String name) {this.name = name;}
    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}
    public void setEmailAdress(String emailAdress) {this.emailAdress = emailAdress;}

    @Override
    public String toString() {
        return name + " - " + phoneNumber + " - " + emailAdress;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(phoneNumber, person.phoneNumber) && Objects.equals(emailAdress, person.emailAdress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phoneNumber, emailAdress);
    }
}

