import java.io.Serializable;

public class PhoneNumber implements Serializable {
    private String number;

    public PhoneNumber(String number) {
        if (number == null || !number.matches("\\d{9}")) {
            throw new IllegalArgumentException("Numer telefonu musi składać się dokładnie z 9 cyfr.");
        }
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return number;
    }
}
