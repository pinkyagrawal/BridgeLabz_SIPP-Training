import java.util.Stack;

public class RecursiveStackSort {

    // Main sorting function
    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int top = stack.pop(); // Remove top
            sortStack(stack);      // Recursively sort remaining
            insertSorted(stack, top); // Insert the removed item back
        }
    }

    // Helper to insert element in sorted position
    private static void insertSorted(Stack<Integer> stack, int element) {
        // If stack is empty or element is greater than top, push it
        if (stack.isEmpty() || element > stack.peek()) {
            stack.push(element);
        } else {
            int top = stack.pop();
            insertSorted(stack, element);
            stack.push(top); // Restore the stack
        }
    }

    // For testing
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(30);
        stack.push(10);
        stack.push(50);
        stack.push(20);
        stack.push(40);

        System.out.println("Original Stack: " + stack);

        sortStack(stack);

        System.out.println("Sorted Stack (top to bottom):");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
