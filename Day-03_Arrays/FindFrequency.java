import java.util.*;

public class FindFrequency{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int number = sc.nextInt();
        int[] frequency = new int[10];
        while (number > 0) {
            int digit = number % 10;
            frequency[digit]++;
            number /= 10;
        }
        System.out.println("Frequency of digits:");
        for (int i = 0; i < frequency.length; i++) {
            System.out.println("Digit " + i + ": " + frequency[i]);
        }
    }
}