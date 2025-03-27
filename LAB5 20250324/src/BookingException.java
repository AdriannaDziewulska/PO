public class BookingException extends Exception {
    public BookingException(String message) {
        super("Błąd rezerwacji: " + message);
    }
}