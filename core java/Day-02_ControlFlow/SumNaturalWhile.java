import java.util.Scanner;
public class SumNaturalWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), sum = 0, i = 1;
        if (n <= 0) {
            System.out.println("Not a natural number");
            return;
        }
        while (i <= n) sum += i++;
        int formula = n * (n + 1) / 2;
        System.out.println("Loop sum: " + sum + ", Formula sum: " + formula);
        System.out.println(sum == formula ? "Both are equal" : "Mismatch");
    }
}
