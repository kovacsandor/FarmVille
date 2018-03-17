package game;

import component.*;

import java.util.ArrayList;
import java.util.List;

import static game.Helper.isInventoryAdded;

class VisMaior {

    private double chanceOfFire = Setting.CHANCE_FIRE;
    private double chanceOfInfection = Setting.CHANCE_INFECTION;

    VisMaior() {
        applyModifiers();
        infection();
        fire();
    }

    private void applyModifiers() {
        if (isInventoryAdded(new Class[]{FireExtinguisher.class})) {
            chanceOfFire -= Setting.DECREASE_FIRE_CHANCE_EXTINGUISHER;
        }
        if (isInventoryAdded(new Class[]{FirePlug.class})) {
            chanceOfFire -= Setting.DECREASE_FIRE_CHANCE_EXTINGUISHER;
        }
        if (isInventoryAdded(new Class[]{Incubator.class})) {
            chanceOfInfection -= Setting.DECREASE_INFECTION_CHANCE_INCUBATOR;
        }
        if (isInventoryAdded(new Class[]{Microscope.class})) {
            chanceOfInfection -= Setting.DECREASE_INFECTION_CHANCE_MICROSCOPE;
        }
    }

    private void fire() {
        List<Field> fieldsOnFire = new ArrayList<>();
        for (List<Field> fields : Model.board) {
            for (Field field : fields) {
                Installation installation = field.getInstallation();
                if (installation != null && (installation instanceof Plant && Math.random() < chanceOfFire)) {
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

    private void infection() {
        for (List<Field> fields : Model.board) {
            for (Field field : fields) {
                Installation installation = field.getInstallation();
                if (installation != null && (installation instanceof Plant && Math.random() < chanceOfInfection)) {
                    System.out.println(installation.getClass().getSimpleName() + " was infected and had to be removed.");
                    field.setIsActionUnderExecution(true);
                    field.setInstallation(null);
                }
            }
        }
    }
}
