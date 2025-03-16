public class Main {
    public static void main(String[] args) {

        Car c1 = new Car("Toyota", 20.5, 4);
        Motorcycle m1 = new Motorcycle("Suzuki", 12.5, 250);
        Bicycle b1 = new Bicycle("Corxso", 6.5);
        ElectricCar ec1 = new ElectricCar("BMW", 30.0, 5);
        ElectricBicycle eb1 = new ElectricBicycle("Manda", 8);

        RentalService rentalService = new RentalService();

        rentalService.addVehicle(c1);
        rentalService.addVehicle(m1);
        rentalService.addVehicle(b1);
        rentalService.addVehicle(ec1);
        rentalService.addVehicle(eb1);

        System.out.println("Lista dostępnych pojazdów: ");
        rentalService.showAllVehicles();

        int[] daysArray = {1, 3, 5, 7};
        for (int days : daysArray) {
            double totalCost = rentalService.calculateTotalCost(days);
            System.out.println("Całkowity koszt wynajmu dla " + days + " dni: " + totalCost + " PLN");
        }

        System.out.println("Ładowanie pojazdów elektrycznych: ");
        rentalService.chargeAllElectricVehicles(200);


        for (ElectricRechargeable ev : rentalService.getAllElectricVehicles()) {
            System.out.println("Poziom naładowania: " + ev.getBatteryLevel() + " kWh");

        }
    }
}
