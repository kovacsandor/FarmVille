package component;

import constrain.Commodity;
import kind.Permission;
import game.Setting;

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
