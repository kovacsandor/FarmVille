package component;

import constrain.Commodity;
import kind.Permission;
import game.Setting;

public class FirePlug extends Inventory {

    @Override
    public void pay() {
        Commodity.recoup(Setting.COST_FIRE_PLUG);
    }

    @Override
    public Permission getPermission() {
        return Permission.DECREASE_FIRE_CHANCE;
    }
}
