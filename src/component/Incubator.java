package component;

import constrain.Commodity;
import game.Setting;

public class Incubator extends Inventory {

    @Override
    public void pay() {
        Commodity.recoup(Setting.COST_INCUBATOR);
    }
}
