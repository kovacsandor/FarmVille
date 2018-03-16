import game.Setup;
import game.Turn;

public class Main {

    public static void main(String[] args) {

        new Setup();
        while (true) {
            new Turn();
        }
    }
}
