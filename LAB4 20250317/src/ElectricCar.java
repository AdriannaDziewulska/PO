public class ElectricCar extends Car implements ElectricRechargeable{
    private double batteryLevel;
    public ElectricCar(String brand, double dailyRate, int seatCount){
        super(brand, dailyRate, seatCount);
        this.batteryLevel=0;
    }

    @Override
    public void chargeBattery(double kWh) {
        this.batteryLevel+=kWh;
    }

    @Override
    public double getBatteryLevel() {
        return this.batteryLevel;
    }

    @Override
    public double calculateRentalCost(int days) {
        return dailyRate*days*0.9;
    }
}
