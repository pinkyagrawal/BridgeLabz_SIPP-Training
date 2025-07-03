import java.util.*;

public class PrintTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number for which you want to print the multiplication table: ");
        int n = sc.nextInt();
        int[] table = new int[10];
        for (int i = 0; i < table.length; i++) {
            table[i] = n * (i + 1);
        }
        System.out.println("Multiplication table of " + n + ":");
        for (int i = 0; i < table.length; i++) {
            System.out.println(n + " * " + (i + 1) + " = " + table[i]);
        }
    }
}