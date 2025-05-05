import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        try {
            Person p1 = new Person("Anna", "123456789", "anna@example.com");
            Person p2 = new Person("Bartek", "234567890", "bartek@example.com");
            Person p3 = new Person("Celina", "345678901", "celina@example.com");

            phoneBook.addPerson(p1);
            phoneBook.addPerson(p2);
            phoneBook.addPerson(p3);

            System.out.println("Osoby w książce:");
            for (Person p : phoneBook.getSortedPersons()) {
                System.out.println(p);
            }

            System.out.println("\nAdresy e-mail (posortowane):");
            System.out.println(phoneBook.getSortedEmails());

            Person p4 = new Person("Barbara", "234567890", "barbara@example.com");
            phoneBook.addPerson(p4);

            System.out.println("\nPo nadpisaniu numeru Bartka:");
            for (Person p : phoneBook.getSortedPersons()) {
                System.out.println(p);
            }
            System.out.println("\nAdresy e-mail (po nadpisaniu):");
            System.out.println(phoneBook.getSortedEmails());

            System.out.println("\nDodanie osoby z powtórzonym adresem e-mail:");
            Person p5 = new Person("Daniel", "456789012", "anna@example.com");
            phoneBook.addPerson(p5);

        } catch (IllegalArgumentException e) {
            System.out.println("Błąd: " + e.getMessage());
        }

        System.out.println("\nAktualna lista osób (sortowana):");
        for (Person p : phoneBook.getSortedPersons()) {
            System.out.println(p);
        }

        try {
            phoneBook.removePerson("123456789"); // Anna
            System.out.println("\nPo usunięciu Anny:");
            for (Person p : phoneBook.getSortedPersons()) {
                System.out.println(p);
            }
            System.out.println("Adresy e-mail: " + phoneBook.getSortedEmails());
        } catch (NoSuchElementException e) {
            System.out.println("Błąd przy usuwaniu: " + e.getMessage());
        }

        try {
            phoneBook.removePerson("000000000");
        } catch (NoSuchElementException e) {
            System.out.println("\nBłąd przy usuwaniu nieistniejącego numeru: " + e.getMessage());
        }

        Person found = phoneBook.findPerson("234567890");
        System.out.println("\nWyszukiwanie osoby (234567890): " + (found != null ? found : "Nie znaleziono."));

        Person notFound = phoneBook.findPerson("999999999");
        System.out.println("Wyszukiwanie osoby (999999999): " + (notFound != null ? notFound : "Nie znaleziono."));

        System.out.println("\nAktualne adresy e-mail:");
        System.out.println(phoneBook.getSortedEmails());

        System.out.println("\nTesty niepoprawnych danych:");

        try {
            Person invalid1 = new Person("", "111111111", "test1@example.com");
            phoneBook.addPerson(invalid1);
        } catch (IllegalArgumentException e) {
            System.out.println("Błąd przy pustym imieniu: " + e.getMessage());
        }

        try {
            Person invalid2 = new Person("Ewa", "222222222", "test2example.com");
            phoneBook.addPerson(invalid2);
        } catch (IllegalArgumentException e) {
            System.out.println("Błąd przy złym emailu: " + e.getMessage());
        }

        try {
            Person invalid3 = new Person("Filip", "", "filip@example.com");
            phoneBook.addPerson(invalid3);
        } catch (IllegalArgumentException e) {
            System.out.println("Błąd przy pustym numerze telefonu: " + e.getMessage());
        }

        try {
            Person invalid4 = new Person("Grzegorz", "123abc456", "grzegorz@example.com");
            if (!invalid4.getPhoneNumber().matches("\\d+")) {
                throw new IllegalArgumentException("Numer telefonu powinien zawierać tylko cyfry");
            }
            phoneBook.addPerson(invalid4);
        } catch (IllegalArgumentException e) {
            System.out.println("Błąd przy niepoprawnym numerze telefonu: " + e.getMessage());
        }
    }
}
