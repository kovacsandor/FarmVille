import game.Model;
import game.Setting;
import game.Setup;
import game.Turn;

public class Main {

    public static void main(String[] args) {

        new Setup();
        while (Model.keeper.getMoney() > Setting.MONEY_BROKE) {
            new Turn();
        }
    }
}
