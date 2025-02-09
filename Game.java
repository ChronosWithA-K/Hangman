import java.util.Scanner;

public class Game {
    Scanner sc = new Scanner(System.in);
    WordProvider wordProvider = new WordProvider();
    private String secret;
    private int secretLength;
    private final String[] validGuesses = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p",
                                           "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

    private int lives = 6;
    private String hangState1 = """
            +--+
               |  |
                  |
                  |
                  |
                  |
              =====""";
    private String hangState2 = """
              +--+
              |  |
              O  |
                 |
                 |
                 |
             =====""";
    private String hangState3 = """
              +--+
              |  |
              O  |
              |  |
                 |
                 |
             =====""";
    private String hangState4 = """
              +--+
              |  |
              O  |
             /|  |
                 |
                 |
             =====""";
    private String hangState5 = """
              +--+
              |  |
              O  |
             /|\\ |
                 |
                 |
             =====""";
    private String hangState6 = """
              +--+
              |  |
              O  |
             /|\\ |
             /   |
                 |
             =====""";
    private String hangState7 = """
              +--+
              |  |
              O  |
             /|\\ |
             / \\ |
                 |
             =====""";

    boolean first_game = true;

    /**
     * Set the secret word and saves its length.
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
            }
        }

        if (secret.contains(guess)) {
            displayInfo();
        } else {
            System.out.println("Incorrect guess.");
            lives--;
        }
    }

    /**
     * Checks whether the guess is valid.
     * @param guess the guess the player makes
     * @return whether the guess is valid
     */
    private boolean validateGuess(String guess) {
        int testsPassed = 0;
        if (guess.length() == secretLength) {
            testsPassed++;
        }

        for (String validGuess : validGuesses) {
            if (guess.equals(validGuess)) {
                testsPassed++;
                break;
            }
        }
        return testsPassed == 2;
    }

    /**
     * Displays how far along the hanging has progressed, and the progress in guessing the secret.
     */
    public void displayInfo() {
        if (lives == 6) {
            System.out.println(hangState1);
        } else if (lives == 5) {
            System.out.println(hangState2);
        } else if (lives == 4) {
            System.out.println(hangState3);
        } else if (lives == 3) {
            System.out.println(hangState4);
        } else if (lives == 2) {
            System.out.println(hangState5);
        } else if (lives == 1) {
            System.out.println(hangState6);
        } else {
            System.out.println(hangState7);
        }


    }
}
