package component;

import game.Setting;

public class Garage extends Building {

    @Override
    protected int getInstallationTime() {
        return Setting.BUILD_TIME_GARAGE;
    }

    @Override
    public int getCost() {
        return Setting.COST_GARAGE;
    }
}
