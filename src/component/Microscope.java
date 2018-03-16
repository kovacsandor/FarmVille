package component;

import constrain.Commodity;
import game.Setting;

public class Microscope extends Inventory {

    @Override
    public void pay() {
        Commodity.recoup(Setting.COST_MICROSCOPE);
    }
}
