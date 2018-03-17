package game;

import component.*;

import java.util.List;
import java.util.stream.Collectors;

public class Turn {

    private int dept = 0;
    private boolean isTurnFinished = false;

    public Turn() {
        onStart();
        whileActionsExecuting();
        onFinish();
    }

    private void whileActionsExecuting() {
        while (!isTurnFinished) {
            Action action = new Action();
            isTurnFinished = action.isTurnFinished();
            dept += action.getDept();
        }
    }

    private void onFinish() {
        Model.money -= dept;
        checkKeeperIsBroke();
        setFieldsUnderExecutionAvailable();
        Model.day++;
    }

    private void onStart() {
        new VisMaior();
        produce();
    }

    private void checkKeeperIsBroke() {
        int money = Model.money;
        if (money < Setting.MONEY_CRITICAL && money > Setting.MONEY_BROKE) {
            System.out.println("You have a critical amount of money: " + money + ".");
        } else if (money < Setting.MONEY_BROKE) {
            System.out.println("You have " + money + " " + Setting.CURRENCY + ".");
            System.out.println("You broke! GAME OVER");
            System.exit(0);
        }
    }

    private void produce() {
        for (List<Field> fields : Model.board) {
            for (Field field : fields) {
                Installation installation = field.getInstallation();
                if (installation != null && (installation instanceof RaisingFacility)) {
                    List<Plant> corns = Model.granary.stream().filter(plant ->
                            plant.getClass() == Corn.class).collect(Collectors.toList());
                    RaisingFacility facility = (RaisingFacility) installation;
                    if (corns.size() > facility.getConsumption() - 1) {
                        for (int i = 0; i < facility.getConsumption(); i++) {
                            corns.remove(0);
                        }
                        Model.money += facility.getIncome();
                        System.out.println(facility.getClass().getSimpleName()
                                + " made " + facility.getIncome()
                                + " " + Setting.CURRENCY + "."
                        );
                    }
                }
            }
        }
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
