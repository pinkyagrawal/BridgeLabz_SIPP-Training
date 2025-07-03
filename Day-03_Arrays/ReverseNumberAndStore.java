import java.util.*;

public class ReverseNumberAndStore{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int number = sc.nextInt();
        String numStr = String.valueOf(number);
        int[] digits = new int[numStr.length()];
        for (int i = 0; i < numStr.length(); i++) {
            digits[i] = Character.getNumericValue(numStr.charAt(i));
        }
        for (int i = 0; i < digits.length / 2; i++) {
            int temp = digits[i];
            digits[i] = digits[digits.length - 1 - i];
            digits[digits.length - 1 - i] = temp;

        }
        System.out.println("Reversed digits: " + Arrays.toString(digits));
    }
}