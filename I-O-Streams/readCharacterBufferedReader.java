import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class readCharacterBufferedReader {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        try {
            System.out.print("Enter a character: ");
            char ch = (char) reader.read();
            System.out.println("You entered: " + ch);
        } catch (IOException e) {
            e.printStackTrace();
        }
    
    }
}

