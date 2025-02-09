public class PlayGame {
    public static void main(String[] args) {
        Game game = new Game();
        boolean playerWantsToPlay = true;

        while (playerWantsToPlay) {
            game.setWord();
            game.displayStartInfo();
            game.makeGuess();
            game.displayInfo();
        }
    }
}
