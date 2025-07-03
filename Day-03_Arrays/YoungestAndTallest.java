import java.util.*;

public class YoungestAndTallest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of people: ");
        int n = sc.nextInt();
        String[] names = new String[n];
        int[] ages = new int[n];
        double[] heights = new double[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter name for person " + (i + 1) + ": ");
            names[i] = sc.next();
            System.out.println("Enter age for person " + (i + 1) + ": ");
            ages[i] = sc.nextInt();
            System.out.println("Enter height for person " + (i + 1) + ": ");
            heights[i] = sc.nextDouble();
        }
        int minAgeIndex = 0;
        for (int i = 1; i < n; i++) {
            if (ages[i] < ages[minAgeIndex]) {
                minAgeIndex = i;
            }
        }
        int maxHeightIndex = 0;
        for (int i = 1; i < n; i++) {
            if (heights[i] > heights[maxHeightIndex]) {
                maxHeightIndex = i;
            }
        }
        System.out.println("Youngest person: " + names[minAgeIndex] + ", Age: " + ages[minAgeIndex]);
        System.out.println("Tallest person: " + names[maxHeightIndex] + ", Height: " + heights[maxHeightIndex]);
    }
}