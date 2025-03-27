public class TripNotFoundException extends Exception {
    public TripNotFoundException(String tripId) {
        super("Nie znaleziono wycieczki o identyfikatorze " + tripId + ".");
    }
}