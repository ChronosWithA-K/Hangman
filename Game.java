import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    Scanner sc = new Scanner(System.in);
    WordProvider wordProvider = new WordProvider();

    private String secret;
    private final String[] VALID_GUESSES = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p",
            "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private StringBuilder progress = new StringBuilder();
    private ArrayList<String> guesses = new ArrayList<String>();

    private int lives = 6;
    private final String HANG_STATE_1 = """
               +--+
               |  |
                  |
                  |
                  |
                  |
              =====""";
    private String HANG_STATE_2 = """
             +--+
             |  |
             O  |
                |
                |
                |
            =====""";
    private String HANG_STATE_3 = """
             +--+
             |  |
             O  |
             |  |
                |
                |
            =====""";
    private String HANG_STATE_4 = """
             +--+
             |  |
             O  |
            /|  |
                |
                |
            =====""";
    private String HANG_STATE_5 = """
             +--+
             |  |
             O  |
            /|\\ |
                |
                |
            =====""";
    private String HANG_STATE_6 = """
             +--+
             |  |
             O  |
            /|\\ |
            /   |
                |
            =====""";
    private String HANG_STATE_7 = """
             +--+
             |  |
             O  |
            /|\\ |
            / \\ |
                |
            =====""";

    /**
     * Set the secret word and prepare progress.
     */
    public void setWord() {
        secret = wordProvider.getWord();

        // Fill the progress String with underscores equal to the amount of characters in the secret.
        progress = new StringBuilder(""); // Reset progress
        for (int i = 0; i < secret.length(); i++) {
            progress.append("_");
        }
    }

    /**
     * Display info that the player should see when playing the game for the first time or when replaying.
     */
    public void displayStartInfo() {
        System.out.println("\nThis is a standard game of Hangman. You guess what letters are in a secret word, and I'll " +
                "tell you whether or not the letter appears in the word. Your guess has to be a single letter. " +
                "If your guess appears in the word, I'll show you where and how many times. If it doesn't, " +
                "you lose one of your\nlives. Guess all the letters in the word to win.\n");
    }

    /**
     * Lets the player make a guess. If the guess is invalid, prompts for another.
     */
    public void makeGuess() {
        System.out.print("Enter your guess: ");
        String guess = sc.nextLine().toLowerCase();
        boolean guessValid = false;

        while (!guessValid) {
            if (validateGuess(guess)) {
                guessValid = true;
                guesses.add(guess);
            } else {
                System.out.println("Sorry, that guess is not valid. Try again.");
                guess = sc.nextLine().toLowerCase();
            }
        }

        if (secret.contains(guess)) {
            System.out.println(guess + " was in the word!");

            // Replace the necessary underscores in the progress string with the guess
            for (int i = 0; i < secret.length() - 1; i++) {
                if (secret.substring(i, i + 1).equals(guess)) {
                    progress.setCharAt(i, guess.charAt(0)); // charAt() can be 0 because it's a single char string
                }
            }

            if (checkIfWordDiscovered()) {
                gameOver();
            }
        } else {
            System.out.println("Incorrect guess.");
            lives--;
        }

        displayInfo();
    }

    /**
     * Checks whether the guess is valid.
     *
     * @param g the guess the player makes.
     * @return whether the guess is valid.
     */
    private boolean validateGuess(String g) {
        for (String validGuess : VALID_GUESSES) {
            if (g.equals(validGuess)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Displays how far along the hanging has progressed, and the progress in guessing the secret.
     */
    private void displayInfo() {
        // Print hang states
        if (lives == 6) {
            System.out.println(HANG_STATE_1);
        } else if (lives == 5) {
            System.out.println(HANG_STATE_2);
        } else if (lives == 4) {
            System.out.println(HANG_STATE_3);
        } else if (lives == 3) {
            System.out.println(HANG_STATE_4);
        } else if (lives == 2) {
            System.out.println(HANG_STATE_5);
        } else if (lives == 1) {
            System.out.println(HANG_STATE_6);
        } else {
            System.out.println(HANG_STATE_7);
            gameOver();
        }

        // Print guessed letters
        System.out.print("Guessed letters: ");
        for (String str : guesses) {
            System.out.print(str + ", ");
        }
        System.out.println();

        System.out.print("Progress: " + progress + "\n");
    }

    /**
     * Tells the player they lost, asks if they want to play again.
     *
     */
    private void gameOver() {
        String answer;
        boolean responseValid = false;

        if (lives == 0) {
            System.out.println("You ran out of lives. The secret was " + secret);
            System.out.println("Do you want to play again? (Y/N)");

        } else { // Method only ever gets called if no lives left or if the game was won, so no other condition is needed
            System.out.println("You won! Do you want to play again? (Y/N)");

        }
        answer = sc.nextLine().toLowerCase();
        responseValid = false;
        while (!responseValid) {
            if (answer.equals("n") || answer.equals("y")) {
                responseValid = true;

                if (answer.equals("n")) {
                    System.exit(0);
                } else {
                    setWord();
                }
            } else {
                System.out.println("That wasn't a valid option. Do you want to play again? (Y/N)");
            }
        }
    }

    public void debug() {
        System.out.println("The secret is: " + secret);
    }

    private boolean checkIfWordDiscovered() {
        return progress.equals(secret);
    }
}
