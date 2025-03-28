import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ContactManager {
    private List<Contact> contacts;

    public ContactManager() {
        this.contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void loadContactFromTextFile(String filename) throws IOException {
        File file = new File(filename);

        if (!file.exists()) {
            throw new IOException("\nPlik nie istnieje: " + filename);
        }

        if (file.length() == 0) {
            System.err.println("\nBłąd: Plik jest pusty.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = br.readLine();
            if (line != null && !line.isEmpty()) {
                String[] parts = line.split(";");
                if (parts.length == 4) {
                    Contact contact = new Contact(parts[0], parts[1], new PhoneNumber(parts[2]), new EmailAdress(parts[3]));
                    contacts.add(contact);
                    System.out.println("\nKontakt wczytany:       " + contact);
                } else {
                    System.err.println("\nBłąd: Nieprawidłowy format danych w pliku.");
                }
            } else {
                System.err.println("\nBłąd: Plik nie zawiera poprawnych danych.");
            }
        } catch (IOException e) {
            throw new IOException("\nBłąd podczas wczytywania pliku: " + e.getMessage());
        }
    }

    public void displayAllContacts() {
        if (contacts.isEmpty()) {
            System.out.println("\nBrak zapisanych kontaktów.");
            return;
        }
        System.out.println("\nLista zapisanych kontaktów:");
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }

    public void serializeContacts(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(contacts);
            System.out.println("\nKontakty zostały zapisane do pliku: " + filename);
        } catch (IOException e) {
            System.err.println("\nBłąd podczas zapisywania kontaktów: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void deserializeContacts(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            contacts = (List<Contact>) ois.readObject();
            System.out.println("\nKontakty zostały wczytane z pliku: " + filename);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("\nBłąd podczas wczytywania kontaktów: " + e.getMessage());
        }
    }


}
