import java.util.Scanner;
public class SmallestOfThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt(), num2 = sc.nextInt(), num3 = sc.nextInt();
        boolean isSmallest = num1 < num2 && num1 < num3;
        System.out.println("Is the first number the smallest? " + isSmallest);
    }
}
