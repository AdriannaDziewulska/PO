public class Car extends Vehicle{
    private int seatCount;
    public Car(String brand, double dailyRate, int seatCount){
        super(brand, dailyRate);
        this.seatCount=seatCount;
    }

    @Override
    public double calculateRentalCost(int days) {
        if(days>7) return (dailyRate*days*0.9);
        else return dailyRate*days;
    }
}
