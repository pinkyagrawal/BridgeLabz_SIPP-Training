import java.util.*;

public class StringCharComparison {
    static char[] getChars(String s) {
        char[] arr = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i);
        }
        return arr;
    }

    static boolean compare(char[] a, char[] b) {
        if (a.length != b.length)
            return false;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] a1 = getChars(s);
        char[] a2 = s.toCharArray();
        boolean res = compare(a1, a2);
        System.out.println("User-defined method output:");
        for (char c : a1)
            System.out.print(c + " ");
        System.out.println("\nBuilt-in method output:");
        for (char c : a2)
            System.out.print(c + " ");
        System.out.println("\nArrays match: " + res);
    }
}