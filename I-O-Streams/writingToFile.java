import java.nio.file.Path;
import java.nio.file.Files;
import java.io.IOException;
public class writingToFile {
    public static void main(String[] args) {
        try {
            Path filePath = Path.of("output.txt");
            String content = "Hello World!\nWelcome to the file.";
            Files.writeString(filePath, content);
                System.out.println("Data is written to the file.");
                
        } catch (IOException e) {
                System.out.println(e);
        }

    }
}
