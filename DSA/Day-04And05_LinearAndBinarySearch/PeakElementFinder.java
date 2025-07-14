public class PeakElementFinder {

    public static int findPeakElement(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            boolean leftOk = (mid == 0 || arr[mid] > arr[mid - 1]);
            boolean rightOk = (mid == arr.length - 1 || arr[mid] > arr[mid + 1]);

            if (leftOk && rightOk) {
                return arr[mid];
            } else if (mid > 0 && arr[mid] < arr[mid - 1]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 20, 4, 1, 0};
        int peak = findPeakElement(nums);
        System.out.println("Peak element: " + peak);
    }
}
