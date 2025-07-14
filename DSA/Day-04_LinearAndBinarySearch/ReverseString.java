public class ReverseString {

    public static String reverseUsingStringBuilder(String input) {
        StringBuilder sb = new StringBuilder();
        sb.append(input);
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        String original = "hello";
        String reversed = reverseUsingStringBuilder(original);
        System.out.println("Original String: " + original);
        System.out.println("Reversed String: " + reversed);
    }
}
