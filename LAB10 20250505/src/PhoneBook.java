import java.util.*;

public class PhoneBook {
    private Map<String, Person> phoneToPersonMap;
    private Set<String> emailSet;

    public PhoneBook() {
        this.phoneToPersonMap = new HashMap<>();
        this.emailSet = new HashSet<>();
    }

    public void addPerson(Person person) {
        if (emailSet.contains(person.getEmailAdress())) {
            throw new IllegalArgumentException("Ten adres e-mail już istnieje w książce telefonicznej.");
        }
        if (phoneToPersonMap.containsKey(person.getPhoneNumber())) {
            Person existing = phoneToPersonMap.get(person.getPhoneNumber());
            emailSet.remove(existing.getEmailAdress());
        }

        phoneToPersonMap.put(person.getPhoneNumber(), person);
        emailSet.add(person.getEmailAdress());
    }

    public void removePerson(String phoneNumber) {
        Person removed = phoneToPersonMap.remove(phoneNumber);
        if (removed == null) {
            throw new NoSuchElementException("Nie znaleziono osoby z podanym numerem telefonu.");
        }
        emailSet.remove(removed.getEmailAdress());
    }

    public Person findPerson(String phoneNumber) {
        return phoneToPersonMap.get(phoneNumber);
    }

    public List<Person> getSortedPersons() {
        List<Person> sortedList = new ArrayList<>(phoneToPersonMap.values());
        sortedList.sort(Comparator.comparing(Person::getName));
        return sortedList;
    }

    public List<String> getSortedEmails() {
        List<String> sortedEmails = new ArrayList<>(emailSet);
        Collections.sort(sortedEmails);
        return sortedEmails;
    }
}