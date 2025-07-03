import java.util.*;

public class CopyElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows in the 2D array:");
        int rows = sc.nextInt();
        System.out.println("Enter the number of columns in the 2D array:");
        int cols = sc.nextInt();
        int[][] arr = new int[rows][cols];
        System.out.println("Enter the elements of the 2D array:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int[] idArray = new int[rows * cols];
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                idArray[index++] = arr[i][j];
            }
        }
        System.out.println("1-D array after copying elements from the 2D array:"
                + Arrays.toString(idArray));
    }
}