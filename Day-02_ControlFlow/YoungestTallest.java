import java.util.Scanner;
public class YoungestTallest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ageA = sc.nextInt(), heightA = sc.nextInt();
        int ageB = sc.nextInt(), heightB = sc.nextInt();
        int ageC = sc.nextInt(), heightC = sc.nextInt();

        String youngest = (ageA <= ageB && ageA <= ageC) ? "Amar" : 
                          (ageB <= ageC) ? "Akbar" : "Anthony";

        String tallest = (heightA >= heightB && heightA >= heightC) ? "Amar" : 
                         (heightB >= heightC) ? "Akbar" : "Anthony";

        System.out.println("Youngest: " + youngest);
        System.out.println("Tallest: " + tallest);
    }
}
