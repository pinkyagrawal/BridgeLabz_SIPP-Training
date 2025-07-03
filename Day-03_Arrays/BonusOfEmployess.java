import java.util.*;

public class BonusOfEmployess {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of employees: ");
        int n = sc.nextInt();
        double[] salaries = new double[n];
        double[] bonuses = new double[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter salary for employee " + (i + 1) + ": ");
            salaries[i] = sc.nextDouble();
        }
        for (int i = 0; i < n; i++) {
            if (salaries[i] < 5000) {
                bonuses[i] = salaries[i] * 0.10;
            } else if (salaries[i] <= 10000) {
                bonuses[i] = salaries[i] * 0.07;
            } else {
                bonuses[i] = salaries[i] * 0.05;
            }
        }
        System.out.println("Bonuses for employees:");
        for (int i = 0; i < n; i++) {
            System.out.printf("Employee %d: Salary = %.2f, Bonus = %.2f%n", (i + 1), salaries[i], bonuses[i]);
        }
    }
}