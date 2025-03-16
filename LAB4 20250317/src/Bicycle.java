public class Bicycle extends Vehicle{
    public Bicycle(String brand, double dailyRate){
        super(brand, dailyRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return dailyRate*days;
    }
}
