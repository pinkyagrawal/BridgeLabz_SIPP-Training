import java.util.Scanner;

public class DiscountCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double fee, discountPercent, discount, finalFee;

        System.out.print("Enter the fee: ");
        fee = input.nextDouble();
        System.out.print("Enter the discount percentage: ");
        discountPercent = input.nextDouble();

        discount = (fee * discountPercent) / 100;
        finalFee = fee - discount;

        System.out.println("The discount amount is INR " + discount + " and final discounted fee is INR " + finalFee);
    }
}
