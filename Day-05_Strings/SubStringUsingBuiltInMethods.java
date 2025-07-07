import java.util.*;

public class SubStringUsingBuiltInMethods {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String str = sc.nextLine();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                String subString = str.substring(i, j);
                System.out.println(subString);
                count++;
            }
        }
        System.out.println("Total number of substrings: " + count);
    }
}