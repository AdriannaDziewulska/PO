public class ElectricBicycle extends Bicycle implements ElectricRechargeable{
    private double batteryLevel;
    public ElectricBicycle(String brand, double dailyRate){
        super(brand, dailyRate);
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
        if(days<4) return 0;
        else return dailyRate*days;
    }
}