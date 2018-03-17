package component;

import game.Setting;

public class Wheat extends Plant {

    @Override
    protected void initializePrice() {
        setPrice(Setting.PRICE_WHEAT);
    }

    @Override
    protected void initializeInstallationTime() {
        setInstallationTime(Setting.RIPEN_TIME_WHEAT);
    }

    @Override
    public int getCost() {
        return Setting.COST_WHEAT;
    }
}
