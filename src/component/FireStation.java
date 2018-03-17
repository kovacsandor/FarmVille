package component;

import game.Setting;

public class FireStation extends Infrastructure {

    @Override
    protected int getInstallationTime() {
        return Setting.BUILD_TIME_FIRE_STATION;
    }

    @Override
    public int getCost() {
        return Setting.COST_FIRE_STATION;
    }
}
