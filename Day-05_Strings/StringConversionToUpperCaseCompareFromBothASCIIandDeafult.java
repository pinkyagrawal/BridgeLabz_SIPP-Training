import java.util.*;

public class StringConversionToUpperCaseCompareFromBothASCIIandDeafult {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string to convert to uppercase: ");
        String str = sc.nextLine();
        StringBuilder s = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                s.append((char) (c - 32));
            } else {
                s.append(c);
            }
        }
        String uc = str.toUpperCase();
        System.out.println("ASCII Uppercase: " + s);
        System.out.println("Default Uppercase: " + uc);
        if (s.toString().equals(uc)) {
            System.out.println("Both methods produce the same result.");
        } else {
            System.out.println("The methods produce different results.");
        }
    }
}