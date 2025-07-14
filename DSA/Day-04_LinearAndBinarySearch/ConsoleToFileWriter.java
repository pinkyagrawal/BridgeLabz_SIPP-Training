import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleToFileWriter {

    public static void main(String[] args) {
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            FileWriter fileWriter = new FileWriter("output.txt");

            String line;
            while (!(line = bufferedReader.readLine()).equalsIgnoreCase("exit")) {
                fileWriter.write(line + "\n");
            }

            fileWriter.close();
            bufferedReader.close();
            inputStreamReader.close();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
