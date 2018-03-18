package game;

import component.*;
import view.Board;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static game.Helper.*;

public class Action {

    private int dept = 0;
    private boolean isTurnFinished = false;

    Action() {
        Board.draw(Model.board);
        handle();
    }

    private void handle() {
        kind.Action action = kind.Action.INVALID_ACTION;
        try {
            System.out.println("Choose an action...");
            Scanner scanner = new Scanner(System.in);
            action = kind.Action.values()[Integer.parseInt(scanner.nextLine()) - 1];
        } catch (Throwable throwable) {
            System.err.println(throwable);
        }
        switch (action) {
            case BUILD_GARAGE:
                build(new Garage());
                break;
            case BUILD_FIRE_STATION:
                build(new FireStation());
                break;
            case BUILD_FOWL_HOUSE:
                build(new FowlHouse());
                break;
            case BUILD_LABORATORY:
                build(new Laboratory());
                break;
            case BUILD_PIGPEN:
                build(new Pigpen());
                break;
            case BUY_FIELD:
                buyField();
                break;
            case FINISH_TURN:
                isTurnFinished = true;
                break;
            case HARVEST:
                harvest();
                break;
            case INVALID_ACTION:
                System.out.println("Invalid action.");
                break;
            case INVEST_FIRE_EXTINGUISHER:
                buy(new FireExtinguisher());
                break;
            case INVEST_FIRE_PLUG:
                buy(new FirePlug());
                break;
            case INVEST_INCUBATOR:
                buy(new Incubator());
                break;
            case INVEST_MICROSCOPE:
                buy(new Microscope());
                break;
            case INVEST_THRESHING_MACHINE:
                buy(new ThreshingMachine());
                break;
            case INVEST_TRACTOR:
                buy(new Tractor());
                break;
            case PLANT_BARLEY:
                plant(new Barley());
                break;
            case PLANT_CORN:
                plant(new Corn());
                break;
            case PLANT_OATS:
                plant(new Oats());
                break;
            case PLANT_RICE:
                plant(new Rice());
                break;
            case PLANT_WHEAT:
                plant(new Wheat());
                break;
            case SELL_CROP:
                sell();
                break;
            default:
                throw new RuntimeException("Invalid action.");
        }
    }

    private void build(Installation installation) {
        if (installation instanceof Garage && isInstallationAdded(Garage.class)) {
            System.out.println("You can only have one garage built.");
        } else {
            for (Field field : selectFields(!(installation instanceof Garage))) {
                if (isFree(field) && !(installation instanceof Garage && isInstallationAdded(Garage.class))) {
                    field.setInstallation(installation);
                    dept += installation.getCost();
                }
            }
        }
    }

    private void buy(Inventory inventory) {
        if (isInstallationReady(inventory.getDependecy())) {
            Model.inventories.add(inventory);
            dept += inventory.getCost();
        } else {
            System.out.println("No " + inventory.getDependecy().getSimpleName() + " found which is ready.");
        }
    }

    private void buyField() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many fields do you want to buy?");
        try {
            int count = Integer.parseInt(scanner.nextLine());
            int added = 0;
            for (int i = 0; i < Setting.BOARD_MAX_SIZE; i++) {
                if (added == count) {
                    break;
                }
                if (Model.board.get(Model.board.size() - 1).size() == Setting.BOARD_MAX_SIZE) {
                    Model.board.add(new ArrayList<>());
                }
                while (Model.board.get(i).size() < Setting.BOARD_MAX_SIZE && added < count) {
                    Field field = new Field(Model.board.get(i).size(), i);
                    Model.board.get(i).add(field);
                    dept += field.getCost();
                    added++;
                }
            }
        } catch (Throwable throwable) {
            System.err.println(throwable);
        }
    }

    private void harvest() {
        List<Field> fields = selectFields(isInventoryAdded(new Class[]{ThreshingMachine.class}));
        for (Field field : fields) {
            if (field.getInstallation() instanceof Plant && field.getInstallation().isReady()) {
                Model.granary.add((Plant) field.getInstallation());
                field.setIsActionUnderExecution(true);
                field.setInstallation(null);
            }
        }
        if (fields.size() > 1) {
            dept += fields.size() * get(ThreshingMachine.class, Model.inventories).get(0).getConsumption();
        }
    }

    private void plant(Installation installation) {
        List<Field> fields = selectFields(isInventoryAdded(new Class[]{Tractor.class}));
        for (Field field : fields) {
            if (isFree(field)) {
                field.setInstallation(installation);
                dept += installation.getCost();
            }
        }
        if (fields.size() > 1) {
            dept += fields.size() * get(Tractor.class, Model.inventories).get(0).getConsumption();
        }
    }

    private void sell() {
        List<Plant> removable = new ArrayList<>();
        for (Plant plant : Model.granary) {
            dept -= plant.getPrice();
            removable.add(plant);
        }
        Model.granary.removeAll(removable);
    }

    public int getDept() {
        return dept;
    }

    public boolean isTurnFinished() {
        return isTurnFinished;
    }
}
