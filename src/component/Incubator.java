package component;

import game.Setting;

/**
 * <p>Main component of the game.</p>
 */
public class Incubator extends Inventory {

    @Override
    public int getCost() {
        return Setting.COST_INCUBATOR;
    }

    @Override
    public Class getDependecy() {
        return Laboratory.class;
    }
}
