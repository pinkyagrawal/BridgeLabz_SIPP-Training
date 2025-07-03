import java.util.*;

public class StoreUntilUserEnterZeroOrNegativeAndPrintSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();
        int input;
        System.out.println("Enter positive integers (enter 0 or a negative number to stop):");
        while (true) {
            input = sc.nextInt();
            if (input <= 0) {
                break;
            }
            numbers.add(input);
        }
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        System.out.println("The sum of the entered positive integers is: " + sum);
    }
}