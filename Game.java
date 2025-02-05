import java.util.Scanner;

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
        boolean guessValid = false;

        while (!guessValid) {
            if (validateGuess(guess)) {
                guessValid = true;
            }
        }
    }

    private boolean validateGuess(String guess) {
        int testsPassed = 0;
        if (guess.length() == secretLength) {
            testsPassed++;
        }

        for (int i = 0; i < validGuesses.length; i++) {
            if (guess.equals(validGuesses[i])) {
                testsPassed++;
                break;
            }
        }
        if (testsPassed == 2) {
            return true;
        }
        return false;
    }
}
