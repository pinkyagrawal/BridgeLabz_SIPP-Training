import java.util.Scanner;

public class UnitConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter distance in kilometers: ");
        double km = sc.nextDouble();
        System.out.println("In miles: " + UnitConverter.convertKmToMiles(km));

        System.out.print("Enter distance in miles: ");
        double miles = sc.nextDouble();
        System.out.println("In kilometers: " + UnitConverter.convertMilesToKm(miles));

        System.out.print("Enter length in meters: ");
        double meters = sc.nextDouble();
        System.out.println("In feet: " + UnitConverter.convertMetersToFeet(meters));

        System.out.print("Enter length in feet: ");
        double feet = sc.nextDouble();
        System.out.println("In meters: " + UnitConverter.convertFeetToMeters(feet));
    }
    public static double convertKmToMiles(double km) {
        double km2miles = 0.621371;
        return km * km2miles;
    }
    public static double convertMilesToKm(double miles) {
        double miles2km = 1.60934;
        return miles * miles2km;
    }
    public static double convertMetersToFeet(double meters) {
        double meters2feet = 3.28084;
        return meters * meters2feet;
    }
    public static double convertFeetToMeters(double feet) {
        double feet2meters = 0.3048;
        return feet * feet2meters;
    }
}