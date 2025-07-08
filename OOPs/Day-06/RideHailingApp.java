interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

abstract class RideVehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;

    public RideVehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getDriverName() {
        return driverName;
    }

    public double getRatePerKm() {
        return ratePerKm;
    }

    public abstract double calculateFare(double distance);

    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Driver Name: " + driverName);
    }
}

class RideCar extends RideVehicle implements GPS {
    public RideCar(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }

    public String getCurrentLocation() {
        return "Delhi";
    }

    public void updateLocation(String newLocation) {}
}

class RideBike extends RideVehicle implements GPS {
    public RideBike(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }

    public String getCurrentLocation() {
        return "Mumbai";
    }

    public void updateLocation(String newLocation) {}
}

class RideAuto extends RideVehicle implements GPS {
    public RideAuto(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }

    public String getCurrentLocation() {
        return "Bangalore";
    }

    public void updateLocation(String newLocation) {}
}

public class RideHailingApp {
    public static void main(String[] args) {
        RideVehicle[] rides = new RideVehicle[] {
            new RideCar("CAR101", "Raj", 12),
            new RideBike("BIKE202", "Amit", 8),
            new RideAuto("AUTO303", "Sunil", 6)
        };

        for (RideVehicle ride : rides) {
            ride.getVehicleDetails();
            System.out.println("Fare for 10km: " + ride.calculateFare(10));
            System.out.println();
        }
    }
}
