public class CarRental {
    String customerName;
    String carModel;
    int rentalDays;
    static final double DAILY_RATE = 1000.0;

    public CarRental() {
        this("Unknown", "Standard", 1);
    }

    public CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }

    public double calculateTotalCost() {
        return DAILY_RATE * rentalDays;
    }

    public void displayRentalDetails() {
        System.out.println("Customer Name: " + customerName);
        System.out.println("Car Model: " + carModel);
        System.out.println("Rental Days: " + rentalDays);
        System.out.println("Total Cost: ₹" + calculateTotalCost());
    }

    public static void main(String[] args) {
        CarRental rental1 = new CarRental();
        CarRental rental2 = new CarRental("Alice", "Honda City", 4);

        System.out.println("Default Rental:");
        rental1.displayRentalDetails();

        System.out.println("\nCustom Rental:");
        rental2.displayRentalDetails();
    }
}