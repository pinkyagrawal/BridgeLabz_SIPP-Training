import java.util.Scanner;
public class DivisibleByFive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println("Is the number " + num + " divisible by 5? " + (num % 5 == 0));
    }
}
