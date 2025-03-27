import java.math.BigDecimal;
import java.util.List;

public class CityBreak extends Trip implements Bookable, Rateable{
    private int daysCount;
    private List<Integer> ratings;
    private boolean booked;
    private String bookerName;
    public CityBreak(String tripId, String title, String location, BigDecimal price, String description, int daysCount, List<Integer> ratings){
        super(tripId, title, location, price, description);
        this.daysCount=daysCount;
        this.ratings = ratings;
        this.booked=false;
        this.bookerName=null;
    }

    @Override
    public String getTravelRequirements() {
        return "ID wycieczki: "+tripId+" Tytuł: "+title+" Miejsce: "+location+" Cena: "+ price+" Opis: "+description+" Liczba dni: "+daysCount+"\n";
    }

    @Override
    public String getTripId() {
        return tripId;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public double getAverageRating() {
        if (ratings == null || ratings.isEmpty()) {
            return 0;
        }

        double sum = 0;
        for (int rating : ratings) {
            sum += rating;
        }
        return sum / ratings.size();
    }
    public List<Integer> getAllRatings() {
        return ratings;
    }

    @Override
    public void rate(int score) throws InvalidRatingException {
        ratings.add(score);
    }

    public String getDestination(){
        return location;
    }

    @Override
    public void book(String customerName) throws BookingException {
        if (booked) {
            throw new BookingException("Ta wycieczka jest już zarezerwowana przez " + bookerName);
        }
        this.booked = true;
        this.bookerName = customerName;
        System.out.println("Wycieczka do " + getDestination() + " została zarezerwowana przez " + customerName);
    }

    @Override
    public boolean isBooked() {
        return booked;
    }

    @Override
    public String getBookerName() {
        return bookerName;
    }

    @Override
    public String toString() {
        return super.toString() + (booked ? " | Zarezerwowana przez: " + bookerName : " | Dostępna do rezerwacji");
    }
}
