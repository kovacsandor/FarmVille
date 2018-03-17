package game;

import component.Field;
import kind.Action;

import java.util.List;

public class Turn {

    private int dept = 0;
    private boolean isTurnFinished = false;

    public Turn() {
        while (!isTurnFinished) {
            game.Action action = new game.Action();
            isTurnFinished = action.getIsTurnFinished();
        }
        this.finish();
    }

    public void executeAction(Action action) {
        // TODO
    }

    private void applyChanges() {
        // TODO
    }

    public void checkKeeperIsBroke() {
        int money = Model.money;
        if (money < Setting.MONEY_CRITICAL && money > Setting.MONEY_BROKE) {
            System.out.println("You have a critical amount of money: " + money + ".");
        } else if (money < Setting.MONEY_BROKE) {
            System.out.println("You have " + money + " " + Setting.CURRENCY + ".");
            System.out.println("You broke! GAME OVER");
            System.exit(0);
        }
    }

    private void finish() {
        setFieldsUnderExecutionAvailable();
        applyChanges();
        Model.day++;
    }

    private void setFieldsUnderExecutionAvailable() {
        for (List<Field> fields : Model.board) {
            for (Field field : fields) {
                if (field.getIsActionUnderExecution()) {
                    field.setIsActionUnderExecution(false);
                }
            }
        }
    }
}