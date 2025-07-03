import java.util.Scanner;

public class Swap {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number1: ");
        int a = input.nextInt();
        System.out.print("Enter number2: ");
        int b = input.nextInt();

        int temp = a;
        a = b;
        b = temp;

        System.out.println("The swapped numbers are " + a + " and " + b);
    }
}
