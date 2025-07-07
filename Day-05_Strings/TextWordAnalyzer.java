import java.util.*;
public class TextWordAnalyzer {
    static String[] getWords(String s) {
        String[] temp = new String[s.length()];
        int index = 0;
        String word = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch != ' ') {
                word += ch;
            } else if (!word.equals("")) {
                temp[index++] = word;
                word = "";
            }
        }
        if (!word.equals("")) {
            temp[index++] = word;
        }
        String[] words = new String[index];
        for (int i = 0; i < index; i++) {
            words[i] = temp[i];
        }
        return words;
    }
    static int getLength(String s) {
        int len = 0;
        try {
            while (true) {
                s.charAt(len);
                len++;
            }
        } catch (Exception e) {
            return len;
        }
    }
    static String[][] getWordLengths(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(getLength(words[i]));
        }
        return result;
    }
    static int[] findMinMax(String[][] arr) {
        int min = Integer.parseInt(arr[0][1]);
        int max = Integer.parseInt(arr[0][1]);
        for (int i = 1; i < arr.length; i++) {
            int len = Integer.parseInt(arr[i][1]);
            if (len < min) min = len;
            if (len > max) max = len;
        }
        return new int[]{min, max};
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] words = getWords(input);
        String[][] wordLens = getWordLengths(words);
        int[] minMax = findMinMax(wordLens);
        System.out.println("Words and their lengths:");
        for (String[] w : wordLens) {
            System.out.println(w[0] + " - " + w[1]);
        }
        System.out.println("Shortest word length: " + minMax[0]);
        System.out.println("Longest word length: " + minMax[1]);
    }
}