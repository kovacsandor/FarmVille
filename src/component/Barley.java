package component;

import game.Setting;

public class Barley extends Plant {

    @Override
    protected void initializePrice() {
        this.setPrice(Setting.PRICE_BARLEY);
    }

    @Override
    protected void initializeInstallationTime() {
        this.setInstallationTime(Setting.RIPEN_TIME_BARLEY);
    }

    @Override
    public int getCost() {
        return Setting.COST_BARLEY;
    }
}
