import java.util.Scanner;
public class GradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int physics = sc.nextInt(), chemistry = sc.nextInt(), maths = sc.nextInt();
        double average = (physics + chemistry + maths) / 3.0;

        String grade;
        if (average >= 90) grade = "A+";
        else if (average >= 80) grade = "A";
        else if (average >= 70) grade = "B";
        else if (average >= 60) grade = "C";
        else if (average >= 50) grade = "D";
        else grade = "F";

        System.out.println("Average Mark: " + average);
        System.out.println("Grade: " + grade);
    }
}
