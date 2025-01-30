import java.util.Scanner;

public class Game {
    Scanner sc = new Scanner(System.in);
    WordProvider wordProvider = new WordProvider();

    boolean first_game = true;

    public String setWord() {
        return wordProvider.getWord();
    }

    /**
     * Display info that the player should see when playing the game for the first time or when replaying.
     */
    public void displayStartInfo() {
        if (first_game) {
            System.out.println("This is a standard game of Hangman. You guess what letters are in a secret word, and I'll " +
                               "tell you whether or not the letter appears in the word. If it does, I'll show you where " +
                               "and how many times. If it doesn't, you lose one of your guesses. Guess all the letters in " +
                               "the word to win.");
            first_game = false;
        } else {
            System.out.println("I hope you have a fun time playing!");
        }
    }

    public void makeGuess() {

    }
}