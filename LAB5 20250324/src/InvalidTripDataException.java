public class InvalidTripDataException extends Exception {
    public InvalidTripDataException(String message) {
        super("Błąd danych wycieczki: " + message);
    }
}