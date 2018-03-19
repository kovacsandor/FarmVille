package component;

import game.Setting;

/**
 * <p>Main component of the game.</p>
 */
public class Rice extends Plant {

    @Override
    public int getPrice() {
        return Setting.PRICE_RICE;
    }

    @Override
    protected int getInstallationTime() {
        return Setting.RIPEN_TIME_RICE;
    }

    @Override
    public int getCost() {
        return Setting.COST_RICE;
    }
}
