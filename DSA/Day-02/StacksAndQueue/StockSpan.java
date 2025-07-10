import java.util.Arrays;
import java.util.Stack;

public class StockSpan {

    public static int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n];
        Stack<Integer> stack = new Stack<>(); // Stores indices

        for (int i = 0; i < n; i++) {
            // Pop all indices where price is <= current price
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }

            // If stack is empty, all previous prices are smaller
            span[i] = stack.isEmpty() ? (i + 1) : (i - stack.peek());

            stack.push(i); // Push current index
        }

        return span;
    }

    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};

        int[] span = calculateSpan(prices);

        System.out.println("Prices: " + Arrays.toString(prices));
        System.out.println("Spans : " + Arrays.toString(span));
    }
}
