package component;

import constrain.Commodity;
import kind.Permission;
import game.Setting;

public class FireExtinguisher extends Inventory {

    @Override
    public void pay() {
        Commodity.recoup(Setting.COST_FIRE_EXTINGUISHER);
    }

    @Override
    public Permission getPermission() {
        return Permission.DECREASE_FIRE_CHANCE;
    }
}
