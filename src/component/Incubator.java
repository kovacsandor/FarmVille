package component;

import constrain.Commodity;
import game.Setting;
import kind.Permission;

public class Incubator extends Inventory {

    @Override
    public void pay() {
        Commodity.recoup(Setting.COST_INCUBATOR);
    }

    @Override
    public Permission getPermission() {
        return Permission.DECREASE_INFECTION_CHANCE_2;
    }
}
