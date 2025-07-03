import java.util.*;
public class HeightOfPlayers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of players:");
        int n = sc.nextInt();
        double[] heights = new double[n]; 
        for (int i = 0; i < n; i++) {
            System.out.println("Enter height of player " + (i + 1) + ":");
            heights[i] = sc.nextDouble();
        }
        double sum = 0;
        for (double height : heights) {
            sum += height;
        }
        double meanHeight = sum / n;
        System.out.printf("The mean height of the players is: %.2f\n", meanHeight);
    }
}