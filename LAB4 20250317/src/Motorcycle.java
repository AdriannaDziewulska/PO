public class Motorcycle extends Vehicle{
    private double engineCapacity;
    public Motorcycle(String brand, double dailyRate, double engineCapacity){
        super(brand, dailyRate);
        this.engineCapacity=engineCapacity;
    }

    @Override
    public double calculateRentalCost(int days) {
        if(engineCapacity>500) return dailyRate*days+50;
        else return dailyRate*days;
    }
}
