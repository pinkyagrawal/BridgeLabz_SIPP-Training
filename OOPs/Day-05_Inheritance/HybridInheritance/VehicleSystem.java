
interface Refuelable {
    void refuel();
}

class Vehicle {
    String model;
    int maxSpeed;

    Vehicle(String model, int maxSpeed) {
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    void showSpecs() {
        System.out.println("Model: " + model);
        System.out.println("Max Speed: " + maxSpeed + " km/h");
    }
}

class PetrolVehicle extends Vehicle implements Refuelable {
    PetrolVehicle(String model, int maxSpeed) {
        super(model, maxSpeed);
    }

    public void refuel() {
        System.out.println(model + " is being refueled with petrol.");
    }
}


class ElectricVehicle extends Vehicle {
    ElectricVehicle(String model, int maxSpeed) {
        super(model, maxSpeed);
    }

    void charge() {
        System.out.println(model + " is charging its battery.");
    }
}
public class VehicleSystem {
    public static void main(String[] args) {
        PetrolVehicle pv = new PetrolVehicle("Honda City", 180);
        ElectricVehicle ev = new ElectricVehicle("Tesla Model 3", 250);

        pv.showSpecs();
        pv.refuel();

        System.out.println();

        ev.showSpecs();
        ev.charge();
    }
}
