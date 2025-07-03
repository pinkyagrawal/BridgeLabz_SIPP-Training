import java.util.Scanner;
public class HarshadCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt(), sum = 0, original = number;

        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }

        System.out.println(original + (original % sum == 0 ? " is a Harshad Number" : " is not a Harshad Number"));
    }
}
