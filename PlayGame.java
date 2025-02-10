public class PlayGame {
    public static void main(String[] args) {
        Game game = new Game();

        while (true) { // gameOver() method in Game.java exits JVM if game not restarted, so this loop can be infinite
            game.setWord();
            game.displayStartInfo();
            game.makeGuess();
        }
    }
}
