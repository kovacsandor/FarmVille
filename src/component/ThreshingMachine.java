package component;

import game.Setting;

/**
 * <p>Main component of the game.</p>
 */
public class ThreshingMachine extends Machine {

    @Override
    public int getCost() {
        return Setting.COST_THRESHING_MACHINE;
    }

    @Override
    public int getConsumption() {
        return Setting.CONSUMPTION_THRESHING_MACHINE;
    }

    @Override
    public Class getDependecy() {
        return Garage.class;
    }
}
