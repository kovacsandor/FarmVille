package game;

import component.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static game.Helper.isInventoryAdded;

public class Turn {

    public Turn() {
        this.start();
        int dept = 0;
        boolean isTurnFinished = false;
        while (!isTurnFinished) {
            game.Action action = new game.Action();
            isTurnFinished = action.getIsTurnFinished();
            dept += action.getDept();
        }
        this.finish(dept);
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

    private void start() {
        consume();
        visMaior();
    }

    private void finish(int debt) {
        Model.money -= debt;
        checkKeeperIsBroke();
        setFieldsUnderExecutionAvailable();
        Model.day++;
    }

    private void visMaior() {
        List<Field> fieldsOnFire = new ArrayList<>();
        double fireChance = Setting.CHANCE_FIRE;
        double infectionChance = Setting.CHANCE_INFECTION;
        if (isInventoryAdded(new Class[]{FireExtinguisher.class})) {
            fireChance -= Setting.DECREASE_FIRE_CHANCE_EXTINGUISHER;
        }
        if (isInventoryAdded(new Class[]{FirePlug.class})) {
            fireChance -= Setting.DECREASE_FIRE_CHANCE_EXTINGUISHER;
        }
        if (isInventoryAdded(new Class[]{Incubator.class})) {
            infectionChance -= Setting.DECREASE_INFECTION_CHANCE_INCUBATOR;
        }
        if (isInventoryAdded(new Class[]{Microscope.class})) {
            infectionChance -= Setting.DECREASE_INFECTION_CHANCE_MICROSCOPE;
        }
        for (List<Field> fields : Model.board) {
            for (Field field : fields) {
                Installation installation = field.getInstallation();
                if (installation != null && (installation instanceof Plant && Math.random() < infectionChance)) {
                    System.out.println(installation.getClass().getSimpleName() + " was infected and had to be removed.");
                    field.setIsActionUnderExecution(true);
                    field.setInstallation(null);
                }
            }
        }
        for (List<Field> fields : Model.board) {
            for (Field field : fields) {
                Installation installation = field.getInstallation();
                if (installation != null && (installation instanceof Plant && Math.random() < fireChance)) {
                    System.out.println(installation.getClass().getSimpleName() + " was caught on fire and had been burned down and the surrounding fields as well");
                    fieldsOnFire.add(field);
                }
            }
        }
        for (Field fieldOnFire : fieldsOnFire) {
            if (fieldOnFire != null) {
                for (List<Field> fields : Model.board) {
                    for (Field field : fields) {
                        Installation installation = field.getInstallation();
                        if (installation != null && (installation instanceof Plant)
                                && field.getCoordinateX() > fieldOnFire.getCoordinateX() - 2
                                && field.getCoordinateX() < fieldOnFire.getCoordinateX() + 2
                                && field.getCoordinateY() > fieldOnFire.getCoordinateY() - 2
                                && field.getCoordinateY() < fieldOnFire.getCoordinateY() + 2
                                ) {
                            field.setIsActionUnderExecution(true);
                            field.setInstallation(null);
                        }
                    }
                }
            }
        }
    }

    private void consume() {
        for (List<Field> fields : Model.board) {
            for (Field field : fields) {
                Installation installation = field.getInstallation();
                if (installation != null && (installation instanceof FowlHouse)) {
                    makeIncome((FowlHouse) installation);
                }
                if (installation != null && (installation instanceof Pigpen)) {
                    makeIncome((Pigpen) installation);
                }
            }
        }
    }

    private List<Plant> getCornFromGrannary() {
        return Model.granary.stream().filter(plant -> plant.getClass() == Corn.class).collect(Collectors.toList());
    }

    private void makeIncome(RaisingFacility raisingFacility) {
        if (getCornFromGrannary().size() > raisingFacility.getConsumption() - 1) {
            for (int i = 0; i < raisingFacility.getConsumption(); i++) {
                getCornFromGrannary().remove(0);
            }
            Model.money += raisingFacility.getIncome();
            System.out.println(raisingFacility.getClass().getSimpleName() + " made " + raisingFacility.getIncome() + " " + Setting.CURRENCY + ".");
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