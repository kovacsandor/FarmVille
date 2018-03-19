package component;

import game.Setting;

/**
 * <p>Main component of the game.</p>
 */
public class Corn extends Plant {

    @Override
    public int getPrice() {
        return Setting.PRICE_CORN;
    }

    @Override
    protected int getInstallationTime() {
        return Setting.RIPEN_TIME_CORN;
    }

    @Override
    public int getCost() {
        return Setting.COST_CORN;
    }
}
