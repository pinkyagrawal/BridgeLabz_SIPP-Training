import java.util.Arrays;
import java.util.Random;

public class SearchPerformanceComparison {

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }

        return -1;
    }

    public static void runSearchComparison(int size, int target) {
        int[] data = new int[size];
        Random rand = new Random();

        for (int i = 0; i < size; i++) {
            data[i] = rand.nextInt(size * 2);
        }

        long startLinear = System.nanoTime();
        linearSearch(data, target);
        long endLinear = System.nanoTime();

        Arrays.sort(data);
        long startBinary = System.nanoTime();
        binarySearch(data, target);
        long endBinary = System.nanoTime();

        long timeLinear = endLinear - startLinear;
        long timeBinary = endBinary - startBinary;

        System.out.println("Dataset Size: " + size);
        System.out.println("Linear Search Time: " + timeLinear / 1_000_000.0 + " ms");
        System.out.println("Binary Search Time: " + timeBinary / 1_000_000.0 + " ms");
        System.out.println();
    }

    public static void main(String[] args) {
        runSearchComparison(1000, 500);
        runSearchComparison(10000, 5000);
        runSearchComparison(1000000, 500000);
    }
}
