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

    /**
     * <p>Keeps doing new actions while the turn is not set to finished.</p>
     */
    private void whileActionsExecuting() {
        while (!isTurnFinished) {
            Action action = new Action();
            isTurnFinished = action.isTurnFinished();
            dept += action.getDept();
        }
    }

    /**
     * <p>Groups actions to be executed on turn finish.</p>
     */
    private void onFinish() {
        Model.money -= dept;
        checkKeeperIsBroke();
        setFieldsUnderExecutionAvailable();
        Model.day++;
    }

    /**
     * <p>Groups actions to be executed on turn start.</p>
     */
    private void onStart() {
        new VisMaior();
        produce();
    }

    /**
     * <p>Checks if <i>the Keeper</i> is broke and exits game if so.</p>
     */
    private void checkKeeperIsBroke() {
        int money = Model.money;
        if (money < Setting.MONEY_CRITICAL && money > Setting.MONEY_BROKE) {
            System.out.println("You have a critical amount of money: " + String.format("%,d", money) + ".");
        } else if (money < Setting.MONEY_BROKE) {
            System.out.println("You have " + String.format("%,d", money) + " " + Setting.CURRENCY + ".");
            System.out.println("You broke! GAME OVER");
            System.exit(0);
        }
    }

    /**
     * <p>Makes income of all built RaisingFacilities if there is enough corn in the granary to do so.</p>
     */
    private void produce() {
        for (List<Field> fields : Model.board) {
            for (Field field : fields) {
                Installation installation = field.getInstallation();
                if (installation != null && (installation instanceof RaisingFacility) && installation.isReady()) {
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

    /**
     * <p>Sets fields under execution available.</p>
     */
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
