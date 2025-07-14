import java.io.*;

public class LargeFileReadingEfficiency {

    public static void readUsingFileReader(String filePath) {
        try {
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);
            long start = System.nanoTime();

            while (br.readLine() != null) {}

            long end = System.nanoTime();
            br.close();
            fr.close();
            System.out.println("FileReader Time: " + (end - start) / 1_000_000.0 + " ms");
        } catch (IOException e) {
            System.out.println("FileReader Error: " + e.getMessage());
        }
    }

    public static void readUsingInputStreamReader(String filePath) {
        try {
            FileInputStream fis = new FileInputStream(filePath);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            long start = System.nanoTime();

            while (br.readLine() != null) {}

            long end = System.nanoTime();
            br.close();
            isr.close();
            fis.close();
            System.out.println("InputStreamReader Time: " + (end - start) / 1_000_000.0 + " ms");
        } catch (IOException e) {
            System.out.println("InputStreamReader Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String filePath = "largefile.txt";
        readUsingFileReader(filePath);
        readUsingInputStreamReader(filePath);
    }
}
