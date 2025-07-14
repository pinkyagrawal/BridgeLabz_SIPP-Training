import java.util.*;

public class DataStructureSearchComparison {

    public static void runSearchComparison(int size, int target) {
        int[] array = new int[size];
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();
        Random rand = new Random();

        for (int i = 0; i < size; i++) {
            int num = rand.nextInt(size * 2);
            array[i] = num;
            hashSet.add(num);
            treeSet.add(num);
        }

        long start, end;

        start = System.nanoTime();
        boolean foundInArray = false;
        for (int num : array) {
            if (num == target) {
                foundInArray = true;
                break;
            }
        }
        end = System.nanoTime();
        System.out.println("Array Search: " + foundInArray + ", Time: " + (end - start) / 1_000_000.0 + " ms");

        start = System.nanoTime();
        boolean foundInHashSet = hashSet.contains(target);
        end = System.nanoTime();
        System.out.println("HashSet Search: " + foundInHashSet + ", Time: " + (end - start) / 1_000_000.0 + " ms");

        start = System.nanoTime();
        boolean foundInTreeSet = treeSet.contains(target);
        end = System.nanoTime();
        System.out.println("TreeSet Search: " + foundInTreeSet + ", Time: " + (end - start) / 1_000_000.0 + " ms");

        System.out.println();
    }

    public static void main(String[] args) {
        runSearchComparison(1000, 500);
        runSearchComparison(100000, 50000);
        runSearchComparison(1000000, 500000);
    }
}
