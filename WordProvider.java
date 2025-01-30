import java.io.RandomAccessFile;

public class WordProvider {
    static final String LIST_PATH = "wordlist.txt";

    /** 
     * Returns a random word from the word list.
     */
    static String getWord() {
        try {
            RandomAccessFile file = new RandomAccessFile(LIST_PATH, "r");
            int random = (int) (Math.random() * file.length());
            file.seek(random);
            file.readLine(); // throw away the first partial line
            String word = file.readLine();
            file.close();
            return word;

        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }
}