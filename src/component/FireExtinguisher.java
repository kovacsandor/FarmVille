package component;

import constrain.Commodity;
import game.Setting;

public class FireExtinguisher extends Inventory {

    @Override
    public void pay() {
        Commodity.recoup(Setting.COST_FIRE_EXTINGUISHER);
    }
}
