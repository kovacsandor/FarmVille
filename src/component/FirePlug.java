package component;

import game.Setting;

/**
 * <p>Main component of the game.</p>
 */
public class FirePlug extends Inventory {

    @Override
    public int getCost() {
        return Setting.COST_FIRE_PLUG;
    }

    @Override
    public Class getDependecy() {
        return FireStation.class;
    }
}
