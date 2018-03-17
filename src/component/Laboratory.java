package component;

import game.Setting;

public class Laboratory extends Infrastructure {

    @Override
    protected int getInstallationTime() {
        return Setting.BUILD_TIME_LABORATORY;
    }

    @Override
    public int getCost() {
        return Setting.COST_LABORATORY;
    }
}
