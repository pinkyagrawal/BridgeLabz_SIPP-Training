import java.util.Scanner;

public class TriangleRun {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the length of side 1 in meters:");
        double side1 = sc.nextDouble();
        
        System.out.println("Enter the length of side 2 in meters:");
        double side2 = sc.nextDouble();
        
        System.out.println("Enter the length of side 3 in meters:");
        double side3 = sc.nextDouble();

        if ((side1 + side2 > side3) &&
            (side2 + side3 > side1) &&
            (side1 + side3 > side2)) {

            double rounds = calculateRounds(side1, side2, side3);
            System.out.println("The athlete needs to complete approximately %.2f rounds to run 5 km.%n " + rounds);
        
        } else {
            System.out.println("The sides do not form a valid triangle.");
        }

    }
    public static double calculateRounds(double side1, double side2, double side3) {
        double perimeter = side1 + side2 + side3;
        double totalDistance = 5000;
        return totalDistance / perimeter;
    }
}