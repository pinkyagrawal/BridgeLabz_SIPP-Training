import java.util.*;

public class OddandEven {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number:");
        int n = sc.nextInt();
        if (n < 1) {
            System.out.println("Please enter a number greater than 0.");
            return;
        }
        int evenCount = 0;
        int oddCount = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0)
                evenCount++;
            else
                oddCount++;
        }
        int[] even = new int[evenCount];
        int[] odd = new int[oddCount];
        int ei = 0, oi = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                even[ei++] = i;
            } else {
                odd[oi++] = i;
            }
        }
        System.out.println("Odd Numbers: " + Arrays.toString(odd));
        System.out.println("Even Numbers: " + Arrays.toString(even));
    }
}