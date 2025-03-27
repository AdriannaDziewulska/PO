import java.math.BigDecimal;

public abstract class Trip {
    protected String tripId;
    protected String title;
    protected String location;
    protected BigDecimal price;
    protected String description;
    public Trip(String tripId, String title, String location, BigDecimal price, String description){
        this.tripId=tripId;
        this.title=title;
        this.location=location;
        this.price=price;
        this.description=description;
    }
    public abstract String getTravelRequirements();
    public abstract String getTripId();
    public abstract String getTitle();
}
