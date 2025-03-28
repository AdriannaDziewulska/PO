import java.io.*;

public class Contact extends Person implements Serializable, SaveableToTextFile, ReadableFromTextFile {
    private PhoneNumber phoneNumber;
    private EmailAdress emailAdress;

    public Contact(String firstName, String lastName, PhoneNumber phoneNumber, EmailAdress emailAdress) {
        super(firstName, lastName);
        this.phoneNumber = phoneNumber;
        this.emailAdress = emailAdress;
    }

    @Override
    public void saveToTextFile(String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(firstName + ";" + lastName + ";" + phoneNumber.getNumber() + ";" + emailAdress.getEmail());
        }
    }

    @Override
    public void readFromTextFile(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line = reader.readLine();
            if (line != null) {
                String[] data = line.split(";");
                if (data.length != 4) {
                    throw new IOException("Niepoprawny format pliku.");
                }
                this.firstName = data[0];
                this.lastName = data[1];
                this.phoneNumber = new PhoneNumber(data[2]);
                this.emailAdress = new EmailAdress(data[3]);
            }
        }
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " - Tel: " + phoneNumber.getNumber() + ", Email: " + emailAdress.getEmail();
    }
}
