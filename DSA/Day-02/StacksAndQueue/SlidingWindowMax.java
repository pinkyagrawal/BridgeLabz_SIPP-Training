import java.util.*;

public class SlidingWindowMax {

    public static List<Integer> maxSlidingWindow(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>(); // stores indices

        for (int i = 0; i < nums.length; i++) {

            // Remove elements out of current window
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }

            // Remove elements smaller than current from back
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.offer(i); // Add current element's index

            // Record the max for this window
            if (i >= k - 1) {
                result.add(nums[deque.peek()]);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        List<Integer> result = maxSlidingWindow(nums, k);

        System.out.println("Input Array: " + Arrays.toString(nums));
        System.out.println("Sliding Window Max (k=" + k + "): " + result);
    }
}
