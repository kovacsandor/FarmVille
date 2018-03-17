package component;

import game.Setting;

public class Barley extends Plant {

    @Override
    public int getPrice() {
        return Setting.PRICE_BARLEY;
    }

    @Override
    protected int getInstallationTime() {
        return Setting.RIPEN_TIME_BARLEY;
    }

    @Override
    public int getCost() {
        return Setting.COST_BARLEY;
    }
}
