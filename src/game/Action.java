package game;

import component.*;
import kind.Permission;
import view.Board;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Action {

    private int dept = 0;
    private boolean isTurnFinished = false;

    public Action() {
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
                install(new Garage());
                break;
            case BUILD_FIRE_STATION:
                install(new FireStation());
                break;
            case BUILD_FOWL_HOUSE:
                install(new FowlHouse());
                break;
            case BUILD_LABORATORY:
                install(new Laboratory());
                break;
            case BUILD_PIGPEN:
                install(new Pigpen());
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
                install(new Barley());
                break;
            case PLANT_CORN:
                install(new Corn());
                break;
            case PLANT_OATS:
                install(new Oats());
                break;
            case PLANT_RICE:
                install(new Rice());
                break;
            case PLANT_WHEAT:
                install(new Wheat());
                break;
            case SELL_CROP:
                List<Plant> removable = new ArrayList<>();
                for (Plant plant : Model.granary) {
                    Model.money += plant.getPrice();
                    removable.add(plant);
                }
                Model.granary.removeAll(removable);
                break;
            default:
                throw new RuntimeException("Invalid action.");
        }
    }

    private void addPermission(Permission permission) {
        if (Model.permissions.stream().filter(p -> p == permission).collect(Collectors.toList()).size() == 0) {
            Model.permissions.add(permission);
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
                if (Model.board.get(Model.board.size() - 1).size() == Setting.BOARD_MAX_SIZE && i < Setting.BOARD_MAX_SIZE) {
                    Model.board.add(new ArrayList<>());
                }
                while (Model.board.get(i).size() < Setting.BOARD_MAX_SIZE && added < count) {
                    Model.board.get(i).add(new Field(Model.board.get(i).size(), i));
                    added++;
                }
            }
        } catch (Throwable throwable) {
            System.err.println(throwable);
        }
    }

    private void buyInventory(Inventory inventory) {
        if (isPermissionAdded(inventory.getPrecondition())) {
            Model.inventories.add(inventory);
            addPermission(inventory.getPermission());
        }
    }

    private boolean isPermissionAdded(Permission permission) {
        return Model.permissions.stream().filter(p -> p == permission).collect(Collectors.toList()).size() == 1;
    }

    private List<Field> selectFields() {
        List<Field> result = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Selelect single field with pattern 'x,y' or multiple fields with pattern 'x-y-x,y':");
        String input = scanner.nextLine();
        if (input.trim().matches("[0-9]{1,2},[0-9]{1,2}-[0-9]{1,2},[0-9]{1,2}")) {
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

    private void install(Installation installation) {
        if (installation instanceof Garage && isInstalled(Garage.class)) {
            System.out.println("You can only have one garage built.");
        } else {
            for (Field field : selectFields()) {
                if (isFree(field) && !(installation instanceof Garage && isInstalled(Garage.class))) {
                    field.setInstallation(installation);
                    dept += installation.getCost();
                    if (installation instanceof Infrastructure) {
                        addPermission(((Infrastructure) installation).getPermission());
                    }
                }
            }
        }
    }

    private boolean isInstalled(Class c) {
        boolean result = false;
        for (List<component.Field> fields : Model.board) {
            for (component.Field field : fields) {
                if (field.getInstallation() != null && field.getInstallation().getClass() == c) {
                    result = true;
                }
            }
        }
        return result;
    }

//    private boolean isPlant(Installation installation) {
//        return installation != null && (
//                installation.getClass() == Barley.class
//                        || installation.getClass() == Corn.class
//                        || installation.getClass() == Oats.class
//                        || installation.getClass() == Rice.class
//                        || installation.getClass() == Wheat.class
//        );
//    }

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
