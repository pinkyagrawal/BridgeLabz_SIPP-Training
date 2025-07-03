import java.util.*;

public class ResulltIn2dArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter marks of Physics: ");
        int physics = sc.nextInt();
        System.out.print("Enter marks of Chemistry: ");
        int chemistry = sc.nextInt();
        System.out.print("Enter marks of Math: ");
        int math = sc.nextInt();
        int total = physics + chemistry + math;
        double percentage = total / 3.0;
        String grade;
        if (percentage >= 90)
            grade = "A";
        else if (percentage >= 80)
            grade = "B";
        else if (percentage >= 70)
            grade = "C";
        else if (percentage >= 60)
            grade = "D";
        else
            grade = "F";
        String[][] result = {
                { "Subject", "Marks" },
                { "Physics", String.valueOf(physics) },
                { "Chemistry", String.valueOf(chemistry) },
                { "Math", String.valueOf(math) },
                { "Percentage", String.format("%.2f", percentage) },
                { "Grade", grade }
        };
        for (String[] result1 : result) {
            System.out.println(result1[0] + ": " + result1[1]);
        }
    }
}