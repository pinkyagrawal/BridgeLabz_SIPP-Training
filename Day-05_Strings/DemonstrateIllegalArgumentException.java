import java.util.*;

public class DemonstrateIllegalArgumentException {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number to find its square root: ");
        String str = sc.nextLine();
        try {
            double number = Double.parseDouble(str);
            if (number < 0) {
                throw new IllegalArgumentException("Cannot calculate square root of a negative number.");
            }
            double squareRoot = Math.sqrt(number);
            System.out.println("The square root of " + number + " is: " + squareRoot);
        } catch (NumberFormatException e) {
            System.out.println("Invalid str. Please enter a valid number.");
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException: " + e.getMessage());
        }
    }
}