import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Game {
    Scanner sc = new Scanner(System.in);
    WordProvider wordProvider = new WordProvider();

    private String secret;
    private int secretLength;
//    private ArrayList<String> validGuesses = new ArrayList<String>();
//    validGuesses.add()
    private final String[] validGuesses = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p",
        "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

    boolean first_game = true;

    /**
     * Set the secret word and save its length.
     */
    public void setWord() {
        secret = wordProvider.getWord();
        secretLength = secret.length();
    }

    /**
     * Display info that the player should see when playing the game for the first time or when replaying.
     */
    public void displayStartInfo() {
        if (first_game) {
            System.out.println("This is a standard game of Hangman. You guess what letters are in a secret word, and I'll " +
                               "tell you whether or not the letter appears in the word. Your guess has to be a single letter. " +
                               "If your guess appears in the word, I'll show you where and how many times. If it doesn't, " +
                               "you lose one of your guesses. Guess all the letters in the word to win.");
            first_game = false;
        } else {
            System.out.println("I hope you have a fun time playing!");
        }
    }

    public void makeGuess() {
        System.out.print("Enter your guess: ");
        String guess = sc.nextLine();
        guess = guess.toLowerCase();
                (guess.length() != 1) || (Arrays.stream(validGuesses).noneMatch(guess::equals);
                break;
            } catch (Exception e) {
                System.out.println("Invalid guess, please try again. Remember, your guess has to be a single letter.");
            }

        while (true) {
            if ((guess.length() != 1) || (Arrays.stream(validGuesses).noneMatch(guess::equals))) {
                System.out.println("Invalid guess. Try again.");
                guess = sc.nextLine();
            } else {
                break;
            }
        }
    }

    private boolean validateGuess(String guess) {

    }
}
