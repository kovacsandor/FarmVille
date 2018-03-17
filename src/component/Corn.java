package component;

import game.Setting;

public class Corn extends Plant {

    @Override
    protected void initializePrice() {
        this.setPrice(Setting.PRICE_CORN);
    }

    @Override
    protected void initializeInstallationTime() {
        this.setInstallationTime(Setting.RIPEN_TIME_CORN);
    }

    @Override
    public int getCost() {
        return Setting.COST_CORN;
    }
}
