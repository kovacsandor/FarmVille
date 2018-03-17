package game;

import component.*;
import view.Board;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static game.Helper.isInventoryAdded;

public class Action {

    private int dept = 0;
    private boolean isTurnFinished = false;

    Action() {
        Board.draw(Model.board);
        System.out.println("Choose an action...");
        Scanner scanner = new Scanner(System.in);
        handle(scanner.nextLine());
    }

    private void handle(String ordinal) {
        kind.Action action = kind.Action.INVALID_ACTION;
        try {
            action = kind.Action.values()[Integer.parseInt(ordinal) - 1];
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
                setIsTurnFinished(true);
                break;
            case HARVEST:
                for (List<Field> fields : Model.board) {
                    for (Field field : fields) {
                        if (field.getInstallation() instanceof Plant && field.getInstallation().isReady()) {
                            Model.granary.add((Plant) field.getInstallation());
                            field.setIsActionUnderExecution(true);
                            field.setInstallation(null);
                        }
                    }
                }
                break;
            case INVALID_ACTION:
                System.out.println("INVALID_ACTION");
                break;
            case INVEST_FIRE_EXTINGUISHER:
                buyInventory(new FireExtinguisher());
                break;
            case INVEST_FIRE_PLUG:
                buyInventory(new FirePlug());
                break;
            case INVEST_INCUBATOR:
                buyInventory(new Incubator());
                break;
            case INVEST_MICROSCOPE:
                buyInventory(new Microscope());
                break;
            case INVEST_THRESHING_MACHINE:
                buyInventory(new ThreshingMachine());
                break;
            case INVEST_TRACTOR:
                buyInventory(new Tractor());
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
                List<Plant> removable = new ArrayList<>();
                for (Plant plant : Model.granary) {
                    dept -= plant.getPrice();
                    removable.add(plant);
                }
                Model.granary.removeAll(removable);
                break;
            default:
                throw new RuntimeException("Invalid action.");
        }
    }

    private void buyField() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("How many fields do you want to buy?");
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

    private void buyInventory(Inventory inventory) {
        if (isAnyOfInstallationReady(inventory.getDependecy())) {
            Model.inventories.add(inventory);
            dept += inventory.getCost();
        } else {
            System.out.println("No " + inventory.getDependecy().getSimpleName() + "found which is ready.");
        }
    }

    private List<Field> selectFields() {
        List<Field> result = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean isMultiple = isInventoryAdded(new Class[]{ThreshingMachine.class, Tractor.class});
        System.out.println("Selelect a single field with pattern 'x,y'" + (isMultiple ? " or multiple fields with pattern 'x-y-x,y'" : ""));
        String input = scanner.nextLine();
        if (input.trim().matches("[0-9]{1,2},[0-9]{1,2}-[0-9]{1,2},[0-9]{1,2}") && isMultiple) {
            String[] temp = input.trim().split("-");
            String[][] coordinates = new String[2][];
            coordinates[0] = temp[0].split(",");
            coordinates[1] = temp[1].split(",");
            try {
                for (List<Field> fields : Model.board) {
                    for (Field field : fields) {
                        for (int x = Integer.parseInt(coordinates[0][0]) - 1; x < Integer.parseInt(coordinates[1][0]); x++) {
                            for (int y = Integer.parseInt(coordinates[0][1]) - 1; y < Integer.parseInt(coordinates[1][1]); y++) {
                                if (field.getCoordinateX() == x && field.getCoordinateY() == y) {
                                    result.add(field);
                                }
                            }
                        }
                    }
                }
            } catch (Throwable throwable) {
                System.err.println(throwable);
            }
        } else if ((input.trim().matches("[0-9]{1,2},[0-9]{1,2}"))) {
            String[] coordinates = input.trim().split(",");
            try {
                result.add(Model.board.get(Integer.parseInt(coordinates[0]) - 1).get(Integer.parseInt(coordinates[1]) - 1));
            } catch (Throwable throwable) {
                System.err.println(throwable);
            }
        } else {
            System.out.println("Invalid field coordinates: " + input);
        }
        return result;
    }

    private boolean isFree(Field field) {
        return field.getInstallation() == null && !field.getIsActionUnderExecution();
    }

    private void build(Installation installation) {
        if (installation instanceof Garage && isInstalled(Garage.class)) {
            System.out.println("You can only have one garage built.");
        } else {
            for (Field field : selectFields()) {
                if (isFree(field) && !(installation instanceof Garage && isInstalled(Garage.class))) {
                    field.setInstallation(installation);
                    dept += installation.getCost();
                }
            }
        }
    }

    private void plant(Installation installation) {
        List<Field> fields = selectFields();
        for (Field field : fields) {
            if (isFree(field)) {
                field.setInstallation(installation);
                dept += installation.getCost();
            }
        }
        if (fields.size() > 1) {
            for (Inventory inventory : Model.inventories) {
                if (inventory instanceof Tractor) {
                    dept += fields.size() * ((Tractor) inventory).getConsumption();
                    break;
                }
                if (inventory instanceof ThreshingMachine) {
                    dept += fields.size() * ((ThreshingMachine) inventory).getConsumption();
                    break;
                }
            }
        }
    }

    private boolean isAnyOfInstallationReady(Class c) {
        boolean result = false;
        for (List<component.Field> fields : Model.board) {
            for (component.Field field : fields) {
                Installation installation = field.getInstallation();
                if (installation != null && installation.getClass() == c && installation.isReady()) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    private boolean isInstalled(Class c) {
        boolean result = false;
        for (List<component.Field> fields : Model.board) {
            for (component.Field field : fields) {
                Installation installation = field.getInstallation();
                if (installation != null && installation.getClass() == c) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    public int getDept() {
        return dept;
    }

    public boolean getIsTurnFinished() {
        return isTurnFinished;
    }

    private void setIsTurnFinished(boolean isTurnFinished) {
        this.isTurnFinished = isTurnFinished;
    }
}
