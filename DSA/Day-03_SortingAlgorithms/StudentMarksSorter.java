public class StudentMarksSorter {

    // Bubble Sort method
    public static void bubbleSort(int[] marks) {
        int n = marks.length;
        boolean swapped;

        // Outer loop for number of passes
        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            // Inner loop for comparing adjacent elements
            for (int j = 0; j < n - 1 - i; j++) {
                if (marks[j] > marks[j + 1]) {
                    // Swap marks[j] and marks[j + 1]
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no elements were swapped, break early
            if (!swapped) {
                break;
            }
        }
    }

    // Method to print array
    public static void printArray(int[] marks) {
        for (int mark : marks) {
            System.out.print(mark + " ");
        }
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        int[] studentMarks = {88, 75, 92, 60, 83};

        System.out.println("Original Marks:");
        printArray(studentMarks);

        bubbleSort(studentMarks);

        System.out.println("Sorted Marks (Ascending):");
        printArray(studentMarks);
    }
}
