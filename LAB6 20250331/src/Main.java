import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ContactManager manager = new ContactManager();
        Contact c1 = new Contact("Jan", "Kowalski", new PhoneNumber("123456789"), new EmailAdress("jan-kowalski@example.com"));
        Contact c2 = new Contact("Anna", "Nowak", new PhoneNumber("987654321"), new EmailAdress("anna-nowak@example.com"));
        c2.saveToTextFile("contact.txt");
        manager.addContact(c1);
        manager.loadContactFromTextFile("contact.txt");
        manager.displayAllContacts();
        manager.serializeContacts("contacts.dat");
        ContactManager newManager = new ContactManager();
        newManager.deserializeContacts("contacts.dat");
        newManager.displayAllContacts();
    }
}
