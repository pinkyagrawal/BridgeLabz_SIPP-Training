import java.util.Arrays;
import java.util.Random;

public class SortingPerformanceComparison {

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - 1 - i; j++)
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int[] leftArr = Arrays.copyOfRange(arr, left, mid + 1);
        int[] rightArr = Arrays.copyOfRange(arr, mid + 1, right + 1);
        int i = 0, j = 0, k = left;

        while (i < leftArr.length && j < rightArr.length)
            arr[k++] = (leftArr[i] <= rightArr[j]) ? leftArr[i++] : rightArr[j++];

        while (i < leftArr.length) arr[k++] = leftArr[i++];
        while (j < rightArr.length) arr[k++] = rightArr[j++];
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high], i = low - 1;
        for (int j = low; j < high; j++)
            if (arr[j] < pivot)
                swap(arr, ++i, j);
        swap(arr, i + 1, high);
        return i + 1;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
    }

    public static void runSortingComparison(int size) {
        int[] original = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) original[i] = rand.nextInt(size * 10);

        int[] bubbleArr = Arrays.copyOf(original, original.length);
        int[] mergeArr = Arrays.copyOf(original, original.length);
        int[] quickArr = Arrays.copyOf(original, original.length);

        long start, end;

        if (size <= 10000) {
            start = System.nanoTime();
            bubbleSort(bubbleArr);
            end = System.nanoTime();
            System.out.println("Bubble Sort Time: " + (end - start) / 1_000_000.0 + " ms");
        } else {
            System.out.println("Bubble Sort Time: Unfeasible");
        }

        start = System.nanoTime();
        mergeSort(mergeArr, 0, mergeArr.length - 1);
        end = System.nanoTime();
        System.out.println("Merge Sort Time: " + (end - start) / 1_000_000.0 + " ms");

        start = System.nanoTime();
        quickSort(quickArr, 0, quickArr.length - 1);
        end = System.nanoTime();
        System.out.println("Quick Sort Time: " + (end - start) / 1_000_000.0 + " ms");
        System.out.println();
    }

    public static void main(String[] args) {
        runSortingComparison(1000);
        runSortingComparison(10000);
        runSortingComparison(1_000_000);
    }
}
