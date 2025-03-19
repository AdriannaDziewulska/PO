import java.util.ArrayList;
import java.util.List;

public class RentalService {

    public List<Vehicle> vehicles;
    public RentalService(){
        vehicles = new ArrayList<>();
    }
    public void addVehicle(Vehicle vehicle){
        vehicles.add(vehicle);
    }
    public void showAllVehicles(){
        for(Vehicle vehicle : vehicles){
            System.out.println(vehicle.showInfo());
        }
    }
    public List<ElectricRechargeable> getAllElectricVehicles(){
        List<ElectricRechargeable> electricVehicles = new ArrayList<>();
        for(Vehicle v : vehicles){
            if (v instanceof ElectricRechargeable){
                electricVehicles.add((ElectricRechargeable) v);
            }
        }
        return electricVehicles;
    }
    public double calculateTotalCost(int days){
        double totalCost = 0;
        for(Vehicle vehicle : vehicles){
            totalCost+=vehicle.calculateRentalCost(days);
        }
        return totalCost;
    }
    public void chargeAllElectricVehicles(double kWh){
        for(ElectricRechargeable v : getAllElectricVehicles()){
                v.chargeBattery(kWh);
        }
    }
}
