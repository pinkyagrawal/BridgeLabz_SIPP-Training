import java.util.Scanner;
public class DayOfWeek {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), d = sc.nextInt(), y = sc.nextInt();

        int y0 = y - (14 - m) / 12;
        int x = y0 + y0/4 - y0/100 + y0/400;
        int m0 = m + 12 * ((14 - m) / 12) - 2;
        int dayOfWeek = (d + x + 31*m0/12) % 7;

        System.out.println("Day of the week (0=Sun,...6=Sat): " + dayOfWeek);
    }
}
