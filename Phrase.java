import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.io.IOException;

public class Phrase {
    public static void main(String[] args) {
        Path path = Paths.get("phrases.txt");

        try {
            String secret = Files.readString(path);
            System.out.println(secret);
        } catch (IOException e) {
            e.printStackTrace;
        }
    }
}