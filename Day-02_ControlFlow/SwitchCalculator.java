import java.util.Scanner;
public class SwitchCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double first = sc.nextDouble();
        double second = sc.nextDouble();
        String op = sc.next();

        switch (op) {
            case "+" -> System.out.println("Result: " + (first + second));
            case "-" -> System.out.println("Result: " + (first - second));
            case "*" -> System.out.println("Result: " + (first * second));
            case "/" -> {
                if (second == 0) System.out.println("Cannot divide by zero");
                else System.out.println("Result: " + (first / second));
            }
            default -> System.out.println("Invalid Operator");
        }
    }
}
