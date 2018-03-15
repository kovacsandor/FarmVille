package component;

import kind.Action;
import game.Setting;
import game.Model;

import java.util.List;

public class Turn {

    private List<Field> fieldsAvailable;

    public void executeAction(Action action) {
        // TODO
    }

    private void applyChanges() {
        // TODO
    }

    public void checkKeeperIsBroke() {
        int money = Model.keeper.getMoney();
        if (money < Setting.MONEY_CRITICAL && money > Setting.MONEY_BROKE) {
            System.out.println("You have a critical amount of money: " + money + ".");
        } else if (money < Setting.MONEY_BROKE) {
            System.out.println("You have " + money + " " + Setting.CURRENCY + ".");
            System.out.println("You broke! GAME OVER");
            System.exit(0);
        }
    }

    public void finish() {
        Model.day++;
        applyChanges();
    }

    public List<Field> getFieldsAvailable() {
        return fieldsAvailable;
    }

    public void setFieldsAvailable(List<Field> fieldsAvailable) {
        this.fieldsAvailable = fieldsAvailable;
    }
}
