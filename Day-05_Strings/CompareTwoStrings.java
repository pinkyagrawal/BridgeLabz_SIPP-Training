import java.util.Scanner;

public class CompareTwoStrings {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String str1 = sc.next();
        System.out.print("Enter second string: ");
        String str2 = sc.next();
        boolean customResult = compareUsingCharAt(str1, str2);
        boolean builtInResult = str1.equals(str2);
        System.out.println("Custom charAt() comparison result: " + customResult);
        System.out.println("Built-in equals() result: " + builtInResult);
        if (customResult == builtInResult) {
            System.out.println("Both methods give the same result.");
        } else {
            System.out.println("Methods give different results.");
        }
    }
    public static boolean compareUsingCharAt(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}