import java.util.*;
public class Vote {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of students:");    
        int n = sc.nextInt();
        int[] ages = new int[n]; 
        int count = 0; 
        for (int i = 0; i < n; i++) {
            System.out.println("Enter age of student " + (i + 1) + ":");
            ages[i] = sc.nextInt(); 
        }
        for (int i = 0; i < n; i++) {
            if (ages[i] >= 18) { 
                count++; 
            }
        }
        System.out.println("Number of students eligible to vote: " + count);
        System.out.println("Ages of eligible students:");
        for (int i = 0; i < n; i++) {
            if (ages[i] >= 18) { 
                System.out.println(ages[i]);
            }
        }
    }
}