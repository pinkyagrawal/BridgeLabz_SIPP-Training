import java.io.*;

public class CompareAll {

    public static void main(String[] args) {
        int iterations = 1_000_000;
        String sample = "hello";

        long startSB = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append(sample);
        }
        long endSB = System.nanoTime();
        long timeSB = endSB - startSB;

        long startSBF = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbf.append(sample);
        }
        long endSBF = System.nanoTime();
        long timeSBF = endSBF - startSBF;

        System.out.println("StringBuilder time: " + timeSB + " ns");
        System.out.println("StringBuffer time: " + timeSBF + " ns");

        try {
            FileReader fileReader = new FileReader("largefile.txt");
            BufferedReader br1 = new BufferedReader(fileReader);

            long startFR = System.nanoTime();
            int wordCountFR = 0;
            String lineFR;
            while ((lineFR = br1.readLine()) != null) {
                String[] words = lineFR.split("\\s+");
                wordCountFR += words.length;
            }
            long endFR = System.nanoTime();
            long timeFR = endFR - startFR;

            br1.close();
            fileReader.close();

            FileInputStream fis = new FileInputStream("largefile.txt");
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br2 = new BufferedReader(isr);

            long startISR = System.nanoTime();
            int wordCountISR = 0;
            String lineISR;
            while ((lineISR = br2.readLine()) != null) {
                String[] words = lineISR.split("\\s+");
                wordCountISR += words.length;
            }
            long endISR = System.nanoTime();
            long timeISR = endISR - startISR;

            br2.close();
            isr.close();
            fis.close();

            System.out.println("Word count using FileReader: " + wordCountFR);
            System.out.println("Time using FileReader: " + timeFR + " ns");
            System.out.println("Word count using InputStreamReader: " + wordCountISR);
            System.out.println("Time using InputStreamReader: " + timeISR + " ns");

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
