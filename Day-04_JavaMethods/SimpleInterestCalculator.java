import java.util.Scanner;

public class SimpleInterestCalculator {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the Principal amount: ");
        double principal = sc.nextDouble();
        
        System.out.print("Enter the Rate of Interest: ");
        double rate = sc.nextDouble();
        
        System.out.print("Enter the Time (in years): ");
        double time = sc.nextDouble();
        
        double interest = calculateSimpleInterest(principal, rate, time);
        
        System.out.printf("The Simple Interest is %.2f for Principal %.2f, Rate of Interest %.2f and Time %.2f%n",
        interest, principal, rate, time);
        
    }
    public static double calculateSimpleInterest(double principal, double rate, double time) {
        return (principal * rate * time) / 100;
    }
}