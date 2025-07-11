public class EmployeeIDSorter {

    public static void insertionSort(int[] ids) {
        int n = ids.length;

        for (int i = 1; i < n; i++) {
            int key = ids[i];
            int j = i - 1;

            while (j >= 0 && ids[j] > key) {
                ids[j + 1] = ids[j];
                j = j - 1;
            }

            ids[j + 1] = key;
        }
    }

    public static void printArray(int[] ids) {
        for (int id : ids) {
            System.out.print(id + " ");
        }
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        int[] employeeIDs = {104, 102, 108, 101, 105};

        System.out.println("Original Employee IDs:");
        printArray(employeeIDs);

        insertionSort(employeeIDs);

        System.out.println("Sorted Employee IDs (Ascending):");
        printArray(employeeIDs);
    }
}
