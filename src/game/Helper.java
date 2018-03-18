package game;

import component.Field;
import component.Installation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Helper {

    static <T, U> List<T> get(Class<T> type, List<U> list) {
        List<T> result = new ArrayList<>();
        for (U item : list) {
            if (item.getClass() == type) {
                result.add((T) item);
            }
        }
        return result;
    }

    static boolean isFree(Field field) {
        return field.getInstallation() == null && !field.getIsActionUnderExecution();
    }

    static boolean isInventoryAdded(Class[] inventories) {
        boolean result = false;
        for (Class inventory : inventories) {
            if (Model.inventories.stream().filter(i -> i.getClass() == inventory).collect(Collectors.toList()).size() > 0) {
                result = true;
                break;
            }
        }
        return result;
    }

    static boolean isInstallationAdded(Class c) {
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

    static boolean isInstallationReady(Class c) {
        boolean result = false;
        for (List<Field> fields : Model.board) {
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

    static List<Field> selectFields(boolean isMultipleAllowed) {
        List<Field> result = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Selelect a single field with pattern 'x,y'"
                + (isMultipleAllowed ? " or multiple fields with pattern 'x-y-x,y'" : ""));
        String input = scanner.nextLine();
        if (input.trim().matches("[0-9]{1,2},[0-9]{1,2}-[0-9]{1,2},[0-9]{1,2}") && isMultipleAllowed) {
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
}
