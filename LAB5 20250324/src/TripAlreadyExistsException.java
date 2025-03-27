public class TripAlreadyExistsException extends Exception {
    public TripAlreadyExistsException(String tripId) {
        super("Wycieczka o identyfikatorze " + tripId + " już istnieje.");
    }
}