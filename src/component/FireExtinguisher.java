package component;

import constrain.Commodity;
import game.Setting;
import kind.Permission;

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
