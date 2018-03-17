package game;

import java.util.stream.Collectors;

class Helper {

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
}
