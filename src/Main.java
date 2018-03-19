import game.Setup;
import game.Turn;

/**
 * <p>The entry point to the game.</p>
 */
public class Main {

    public static void main(String[] args) {

        new Setup();
        while (true) {
            new Turn();
        }
    }
}
