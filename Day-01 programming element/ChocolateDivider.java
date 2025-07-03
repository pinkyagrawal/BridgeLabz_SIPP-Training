import java.util.Scanner;

public class ChocolateDivider {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of chocolates: ");
        int chocolates = input.nextInt();
        System.out.print("Enter number of children: ");
        int children = input.nextInt();

        int perChild = chocolates / children;
        int remaining = chocolates % children;

        System.out.println("The number of chocolates each child gets is " + perChild + " and the number of remaining chocolates is " + remaining);
    }
}
