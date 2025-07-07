import java.util.*;

public class RPSGame {
    static String getComp() {
        int r = (int) (Math.random() * 3);
        return r == 0 ? "rock" : r == 1 ? "paper" : "scissors";
    }

    static String getWinner(String user, String comp) {
        if (user.equals(comp))
            return "Draw";
        if ((user.equals("rock") && comp.equals("scissors")) ||
                (user.equals("paper") && comp.equals("rock")) ||
                (user.equals("scissors") && comp.equals("paper")))
            return "User";
        return "Computer";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int userWin = 0, compWin = 0;
        System.out.print("How many games? ");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 1; i <= n; i++) {
            System.out.print("Game " + i + " (rock/paper/scissors): ");
            String user = sc.nextLine().toLowerCase();
            String comp = getComp();
            String win = getWinner(user, comp);
            System.out.println("Computer: " + comp + " → " + win + " wins");
            if (win.equals("User"))
                userWin++;
            else if (win.equals("Computer"))
                compWin++;
        }
        System.out.println("\nUser Wins: " + userWin);
        System.out.println("Computer Wins: " + compWin);
        System.out.println("User Win %: " + (userWin * 100 / n) + "%");
        System.out.println("Computer Win %: " + (compWin * 100 / n) + "%");
    }
}