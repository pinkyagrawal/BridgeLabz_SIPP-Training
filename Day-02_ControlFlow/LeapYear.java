import java.util.Scanner;
public class LeapYear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        if (year < 1582) {
            System.out.println("Year must be >= 1582");
            return;
        }
        boolean isLeap = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        System.out.println("Year " + year + (isLeap ? " is a Leap Year" : " is not a Leap Year"));
    }
}
