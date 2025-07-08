public class Vehicle {

    static double registrationFee = 5000.0;

    private final String registrationNumber;
    private String ownerName;
    private String vehicleType;

    public Vehicle(String registrationNumber, String ownerName, String vehicleType) {
        this.registrationNumber = registrationNumber;
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }

    public void displayVehicleDetails() {
        if (this instanceof Vehicle) {
            System.out.println("Registration Number: " + registrationNumber);
            System.out.println("Owner Name: " + ownerName);
            System.out.println("Vehicle Type: " + vehicleType);
            System.out.println("Registration Fee: " + registrationFee);
        } else {
            System.out.println("Invalid vehicle object.");
        }
    }

    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("MH12AB1234", "Alice", "Car");
        Vehicle v2 = new Vehicle("MH14XY5678", "Bob", "Bike");

        v1.displayVehicleDetails();
        System.out.println();
        v2.displayVehicleDetails();
        System.out.println();

        Vehicle.updateRegistrationFee(5500.0);
        System.out.println("Registration fee updated.\n");

        v1.displayVehicleDetails();
        System.out.println();
        v2.displayVehicleDetails();
    }
}