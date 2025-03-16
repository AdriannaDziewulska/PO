abstract class Vehicle {
    protected String brand;
    protected double dailyRate;
    public Vehicle(String brand, double dailyRate){
        this.brand=brand;
        this.dailyRate=dailyRate;
    }
    public double calculateRentalCost(int days){
        return dailyRate*days;
    }
    public String showInfo(){
        return "Pojazd: "+brand+", stawka dzienna: "+dailyRate;
    }
}
