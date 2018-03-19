package component;

import game.Setting;

/**
 * <p>Main component of the game.</p>
 */
public class Oats extends Plant {

    @Override
    public int getPrice() {
        return Setting.PRICE_OATS;
    }

    @Override
    protected int getInstallationTime() {
        return Setting.RIPEN_TIME_OATS;
    }

    @Override
    public int getCost() {
        return Setting.COST_OATS;
    }
}
