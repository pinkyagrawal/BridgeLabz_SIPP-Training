import java.util.Scanner;

public class SumOfNaturalNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive integer (n): ");
        int n = sc.nextInt();
        int sum = findSum(n);
        System.out.println("Sum of first " + n + " natural numbers is: " + sum);
    }
    public static int findSum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }
}