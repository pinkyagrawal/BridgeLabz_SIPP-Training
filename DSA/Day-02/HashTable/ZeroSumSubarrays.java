import java.util.*;

public class ZeroSumSubarrays {

    public static List<int[]> findZeroSumSubarrays(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<int[]> result = new ArrayList<>();
        int sum = 0;

        map.put(0, new ArrayList<>());
        map.get(0).add(-1);  // Handle subarrays starting at index 0

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (map.containsKey(sum)) {
                for (int startIdx : map.get(sum)) {
                    result.add(new int[]{startIdx + 1, i}); // Subarray [startIdx+1, i]
                }
            }

            map.putIfAbsent(sum, new ArrayList<>());
            map.get(sum).add(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, -7, 1, 2, -6, 1, -1};

        List<int[]> subarrays = findZeroSumSubarrays(arr);

        System.out.println("Zero-sum subarrays (start to end indices):");
        for (int[] sub : subarrays) {
            System.out.println(Arrays.toString(sub));
        }
    }
}
