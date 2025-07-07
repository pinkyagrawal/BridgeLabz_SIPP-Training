
import java.util.*;

public class NumberFormat {
    static void generateException(String input) {
        int number = Integer.parseInt(input);
        System.out.println("Converted number: " + number);
    }

    static void handleException(String input) {
        try {
            int number = Integer.parseInt(input);
            System.out.println("Converted number inside try-catch: " + number);
        } catch (NumberFormatException e) {
            System.out.println("Caught NumberFormatException: Input is not a valid integer.");
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String userInput = scanner.next();
        handleException(userInput);
    }
}