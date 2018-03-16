package game;

import component.Field;
import kind.Action;

import java.util.List;

public class Turn {

    public Turn() {
        boolean isTurnFinished = false;
        while (!isTurnFinished) {
            game.Action action = new game.Action();
            isTurnFinished = action.getIsFinishTurn();
        }
        this.finish();
    }

    public void executeAction(Action action) {
        // TODO
    }

    private void applyChanges() {
        // TODO
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