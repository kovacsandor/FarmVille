package component;

import game.Setting;

/**
 * <p>Main component of the game.</p>
 */
public class Microscope extends Inventory {

    @Override
    public int getCost() {
        return Setting.COST_MICROSCOPE;
    }

    @Override
    public Class getDependecy() {
        return Laboratory.class;
    }
}
