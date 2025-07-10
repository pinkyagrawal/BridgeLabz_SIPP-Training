interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    public String getVehicleNumber() { return vehicleNumber; }
    public double getRentalRate() { return rentalRate; }

    public abstract double calculateRentalCost(int days);
}

class Car extends Vehicle implements Insurable {
    public Car(String number, double rate) {
        super(number, "Car", rate);
    }

    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    public double calculateInsurance() {
        return 2000;
    }

    public String getInsuranceDetails() {
        return "Car insurance fixed: ₹2000";
    }
}

class Bike extends Vehicle implements Insurable {
    public Bike(String number, double rate) {
        super(number, "Bike", rate);
    }

    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return 500;
    }

    @Override
    public String getInsuranceDetails() {
        return "Bike insurance fixed: ₹500";
    }
}

class Truck extends Vehicle implements Insurable {
    public Truck(String number, double rate) {
        super(number, "Truck", rate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days * 1.2;
    }

    public double calculateInsurance() {
        return 3000;
    }

    public String getInsuranceDetails() {
        return "Truck insurance fixed: ₹3000";
    }
}

public class VehicleRental {
    public static void main(String[] args) {
        Vehicle[] vehicles = {
            new Car("C101", 1000),
            new Bike("B201", 300),
            new Truck("T301", 2000)
        };

        for (Vehicle v : vehicles) {
            System.out.println("Vehicle: " + v.getVehicleNumber());
            System.out.println("Rental: " + v.calculateRentalCost(5));
            System.out.println("Insurance: " + ((Insurable) v).calculateInsurance());
        }
    }
}
