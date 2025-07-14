public class StudentScoreSorter {

    public static void selectionSort(int[] scores) {
        int n = scores.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = scores[minIndex];
            scores[minIndex] = scores[i];
            scores[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] examScores = {78, 92, 45, 89, 66, 53};

        System.out.println("Original Exam Scores:");
        for (int score : examScores)
            System.out.print(score + " ");

        selectionSort(examScores);

        System.out.println("\nSorted Exam Scores (Ascending):");
        for (int score : examScores)
            System.out.print(score + " ");
    }
}
