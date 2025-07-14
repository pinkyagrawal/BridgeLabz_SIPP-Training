public class WordSearchInSentences {

    public static String findSentenceWithWord(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.contains(word)) {
                return sentence;
            }
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        String[] sentences = {
            "Java is a programming language",
            "Python is popular for data science",
            "Machine learning is fascinating",
            "I love solving problems"
        };
        String word = "data";
        String result = findSentenceWithWord(sentences, word);
        System.out.println("Result: " + result);
    }
}
