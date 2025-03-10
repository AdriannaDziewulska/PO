import java.util.ArrayList;
import java.util.List;

public class Library {
    public static void main(String[] args) {
        List<Item> ItemList = new ArrayList<>();
        List<User> UserList = new ArrayList<>();
        User u0 = new User(0, "Biblioteka", " ");
        UserList.add(u0);
        Book b1 = new Book(253, "Ruthless People", "J. J. McAvoy", 2020, true, 0, 640, "mafia romans", "Polski");
        ItemList.add(b1);
        Book b2 = new Book(256, "Queen of the south", "Ruley Johns", 2022, true, 0, 810, "mafia romans", "Polski");
        ItemList.add(b2);
        Magazine m1 = new Magazine(365, "Vogue", "External", 2025, true, 0, 23, 2, "Fashion", 1000);
        ItemList.add(m1);
        User u1 = new User(123, "Łukasz", "Kucharczyk");
        UserList.add(u1);

        System.out.println("Lista dostępnych pozycji: ");
        for(Item item: ItemList){
            item.getInformation();
        }
        System.out.println("    ");

        b1.borrowItem(123);
        m1.borrowItem(124);

        User u2 = new User(124, "Natalia", "Góras");
        UserList.add(u2);

        System.out.println("Lista dostępnych pozycji: ");
        for(Item item: ItemList){
            if(item.isAvailable){
                item.getInformation();
            }
        }
        System.out.println("    ");

        b1.returnItem(123);

        System.out.println("Lista dostępnych pozycji: ");
        for(Item item: ItemList){
            if(item.isAvailable){
                item.getInformation();
            }
        }
        System.out.println("    ");
    }
}
