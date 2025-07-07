import java.util.*;

public class StringIndexOutOfBoundDemonstrate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String str = sc.nextLine();
        try {
            char outOfBound = str.charAt(str.length());
            System.out.println("Character at out of bound index: " + outOfBound);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Caught StringIndexOutOfBoundsException: " + e.getMessage());
        }
        if (str.length() > 0) {
            char valid = str.charAt(0);
            System.out.println("First character of the string: " + valid);
        }
    }
}