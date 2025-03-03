public class BookTest {
    public static void main (String[] args){
        Book a = new Book("Elita", "Natalia Antczak", 2024);
        Book b = new Book("Elita 2", "Natalia Antczak", 2025);
        System.out.println(b.isOlderThan(a));
        System.out.println(b.toString());
    }
}
