package component;

import game.Setting;

/**
 * <p>Main component of the game.</p>
 */
public class Tractor extends Machine {

    @Override
    public int getCost() {
        return Setting.COST_TRACTOR;
    }

    @Override
    public int getConsumption() {
        return Setting.CONSUMPTION_TRACTOR;
    }

    @Override
    public Class getDependecy() {
        return Garage.class;
    }
}
