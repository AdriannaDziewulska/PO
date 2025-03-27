import java.util.ArrayList;
import java.util.List;

public class TravelAgencyManager {
    private List<Trip> trips;
    public TravelAgencyManager(){
        this.trips = new ArrayList<>();
    }
    public void addTrip(Trip trip) throws TripAlreadyExistsException{
        for (Trip t: trips){
            if (t.getTripId().equals(trip.getTripId())){
                throw new TripAlreadyExistsException(trip.getTripId());
            }
        }
        trips.add(trip);
    }
    public void removeTrip(String tripId) throws TripNotFoundException{
        Trip tripToRemove = findTripById(tripId);
        trips.remove(tripToRemove);
    }

    public Trip findTripById(String tripId) throws TripNotFoundException {
        for (Trip trip : trips) {
            if (trip.getTripId().equals(tripId)) {
                return trip;
            }
        }
        throw new TripNotFoundException(tripId);
    }

    public List<Trip> findTripsByTitleFragment(String fragment) {
        List<Trip> matchingTrips = new ArrayList<>();
        for (Trip trip : trips) {
            if (trip.getTitle().toLowerCase().contains(fragment.toLowerCase())) {
                matchingTrips.add(trip);
            }
        }
        return matchingTrips;
    }

    public double calculateAverageRatingOfAll() {
        double totalRating = 0;
        int count = 0;
        for (Trip trip : trips) {
            if (trip instanceof Rateable) {
                totalRating += ((Rateable) trip).getAverageRating();
                count++;
            }
        }
        return count > 0 ? totalRating / count : 0;
    }
    public void bookOneTrip(String customerName) {
        for (Trip trip : trips) {
            if (trip instanceof Bookable) {
                try {
                    ((Bookable) trip).book(customerName);
                    return;
                } catch (BookingException e) {
                    System.out.println("Błąd rezerwacji: " + e.getMessage());
                }
            }
        }
        System.out.println("Brak dostępnych wycieczek do rezerwacji.");
    }
    public void displayAllRequirements() {
        for (Trip trip : trips) {
            System.out.println(trip.getTripId() + "\t" + trip.getTitle() + "\t" + trip.getTravelRequirements());
        }
    }
}
