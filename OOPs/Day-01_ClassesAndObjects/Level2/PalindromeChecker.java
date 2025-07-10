public class PalindromeChecker {
    String text;

    public PalindromeChecker(String text) {
        this.text = text;
    }

    public boolean isPalindrome() {
        String cleaned = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int left = 0;
        int right = cleaned.length() - 1;

        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public void displayResult() {
        System.out.println("Text  : " + text);
        if (isPalindrome()) {
            System.out.println("Result: It is a palindrome.");
        } else {
            System.out.println("Result: It is not a palindrome.");
        }
    }

    public static void main(String[] args) {
        PalindromeChecker checker1 = new PalindromeChecker("Madam");
        checker1.displayResult();

        PalindromeChecker checker2 = new PalindromeChecker("Hello");
        checker2.displayResult();
    }
}