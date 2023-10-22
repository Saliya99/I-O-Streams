import java.io.*;

public class characterReaderWriter {
    public static void main(String[] args) {
        try {
            // Writing data to a file using BufferedWriter
            FileWriter writer = new FileWriter("output.txt");
            BufferedWriter buffer = new BufferedWriter(writer);
            buffer.write("Hello World");
            buffer.close();
            System.out.println("Data is written to the file.");

            // Reading data from a file using BufferedReader
            FileReader reader = new FileReader("output.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println("Data read from the file: " + line);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
