package game;

import component.*;
import kind.Permission;
import view.Board;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Action {

    private boolean isFinishTurn = false;

    public Action() {
        Board.draw(Model.board);
        System.out.println("Choose an action...");
        Scanner scanner = new Scanner(System.in);
        handle(scanner.nextLine());
        checkKeeperIsBroke();
    }

    private void handle(String ordinal) {
        kind.Action action = kind.Action.INVALID_ACTION;
        try {
            action = kind.Action.values()[Integer.parseInt(ordinal) - 1];
        } catch (Throwable throwable) {

        }
        switch (action) {
            case BUILD_GARAGE:
                if (isInstalled(Garage.class)) {
                    System.out.println("You can only have one garage built.");
                } else {
                    for (Field field : selectFields()) {
                        if (!isInstalled(Garage.class) && isFree(field)) {
                            field.setInstallation(new Garage());
                            addPermission(Permission.INVEST_MACHINES);
                        }
                    }
                }
                break;
            case BUILD_FIRE_STATION:
                for (Field field : selectFields()) {
                    if (isFree(field)) {
                        field.setInstallation(new FireStation());
                        addPermission(Permission.INVEST_ESTINGUISHER);
                    }
                }
                break;
            case BUILD_FOWL_HOUSE:
                for (Field field : selectFields()) {
                    if (isFree(field)) {
                        field.setInstallation(new FowlHouse());
                    }
                }
                break;
            case BUILD_LABORATORY:
                for (Field field : selectFields()) {
                    if (isFree(field)) {
                        field.setInstallation(new Laboratory());
                        addPermission(Permission.RESEARCH);
                    }
                }
                break;
            case BUILD_PIGPEN:
                for (Field field : selectFields()) {
                    if (isFree(field)) {
                        field.setInstallation(new Pigpen());
                    }
                }
                break;
            case BUY_FIELD:
                System.out.println("BUY_FIELD");
                break;
            case FINISH_TURN:
                setIsFinishTurn(true);
                break;
            case HARVEST:
                for (List<Field> fields : Model.board) {
                    for (Field field : fields) {
                        if (isPlant(field.getInstallation()) && field.getInstallation().isReady()) {
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
                if (isPermissionAdded(Permission.INVEST_ESTINGUISHER)) {
                    Model.inventories.add(new FireExtinguisher());
                    addPermission(Permission.DECREASE_FIRE_CHANCE);
                }
                break;
            case INVEST_FIRE_PLUG:
                if (isPermissionAdded(Permission.INVEST_ESTINGUISHER)) {
                    Model.inventories.add(new FirePlug());
                    addPermission(Permission.DECREASE_FIRE_CHANCE);
                }
                break;
            case INVEST_INCUBATOR:
                if (isPermissionAdded(Permission.RESEARCH)) {
                    Model.inventories.add(new Incubator());
                    addPermission(Permission.DECREASE_INFECTION_CHANCE_2);
                }
                break;
            case INVEST_MICROSCOPE:
                if (isPermissionAdded(Permission.RESEARCH)) {
                    Model.inventories.add(new Microscope());
                    addPermission(Permission.DECREASE_INFECTION_CHANCE_3);
                }
                break;
            case INVEST_THRESHING_MACHINE:
                if (isPermissionAdded(Permission.INVEST_MACHINES)) {
                    Model.inventories.add(new ThreshingMachine());
                }
                break;
            case INVEST_TRACTOR:
                if (isPermissionAdded(Permission.INVEST_MACHINES)) {
                    Model.inventories.add(new Tractor());
                }
                break;
            case PLANT_BARLEY:
                for (Field field : selectFields()) {
                    if (isFree(field)) {
                        field.setInstallation(new Barley());
                    }
                }
                break;
            case PLANT_CORN:
                for (Field field : selectFields()) {
                    if (isFree(field)) {
                        field.setInstallation(new Corn());
                    }
                }
                break;
            case PLANT_OATS:
                for (Field field : selectFields()) {
                    if (isFree(field)) {
                        field.setInstallation(new Oats());
                    }
                }
                break;
            case PLANT_RICE:
                for (Field field : selectFields()) {
                    if (isFree(field)) {
                        field.setInstallation(new Rice());
                    }
                }
                break;
            case PLANT_WHEAT:
                for (Field field : selectFields()) {
                    if (isFree(field)) {
                        field.setInstallation(new Wheat());
                    }
                }
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
                result.add(Model.board.get(Integer.parseInt(coordinates[0])).get(Integer.parseInt(coordinates[1])));
            } catch (Throwable throwable) {
                System.err.println(throwable);
            }
        } else {
            System.out.println("Invalid field coordinates: " + input);
        }
        return result;
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

    private boolean isFree(Field field) {
        return field.getInstallation() == null && !field.getIsActionUnderExecution();
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

    private boolean isPlant(Installation installation) {
        return installation != null && (
                installation.getClass() == Barley.class
                        || installation.getClass() == Corn.class
                        || installation.getClass() == Oats.class
                        || installation.getClass() == Rice.class
                        || installation.getClass() == Wheat.class
        );
    }

    public boolean getIsFinishTurn() {
        return isFinishTurn;
    }

    private void setIsFinishTurn(boolean isFinishTurn) {
        this.isFinishTurn = isFinishTurn;
    }
}
