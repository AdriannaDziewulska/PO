import java.math.BigDecimal;
import java.util.List;

public class AdventureTrip extends Trip implements Rateable{
    private String activityLevel;
    private List<Integer> ratings;

    public AdventureTrip(String tripId, String title, String location, BigDecimal price, String description, String activityLevel, List<Integer> ratings){
        super(tripId, title, location, price, description);
        this.activityLevel=activityLevel;
        this.ratings = ratings;
    }

    @Override
    public String getTravelRequirements() {
        return "ID wycieczki: "+tripId+" Tytuł: "+title+" Miejsce: "+location+" Cena: "+ price+" Opis: "+description+" Intensywność aktywności: : "+activityLevel+"\n";
    }
    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getTripId() {
        return tripId;
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

}

