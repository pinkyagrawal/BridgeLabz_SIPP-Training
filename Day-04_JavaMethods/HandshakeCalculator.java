import java.util.Scanner;

public class HandshakeCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int numberOfStudents = sc.nextInt();
        int totalHandshakes = calculateHandshakes(numberOfStudents);
        System.out.println("Maximum number of possible handshakes: " + totalHandshakes);
    }

    public static int calculateHandshakes(int n) {
        return (n * (n - 1)) / 2;
    }
}