package component;

import constrain.Commodity;
import game.Setting;
import kind.Permission;

public class Microscope extends Inventory {

    @Override
    public void pay() {
        Commodity.recoup(Setting.COST_MICROSCOPE);
    }

    @Override
    public Permission getPermission() {
        return Permission.DECREASE_INFECTION_CHANCE_3;
    }
}
