package component;

import game.Setting;

/**
 * <p>Main component of the game.</p>
 */
public class Wheat extends Plant {

    @Override
    public int getPrice() {
        return Setting.PRICE_WHEAT;
    }

    @Override
    protected int getInstallationTime() {
        return Setting.RIPEN_TIME_WHEAT;
    }

    @Override
    public int getCost() {
        return Setting.COST_WHEAT;
    }
}
