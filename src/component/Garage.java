package component;

import game.Setting;
import kind.Permission;

public class Garage extends Infrastructure {

    @Override
    protected int getInstallationTime() {
        return Setting.BUILD_TIME_GARAGE;
    }

    @Override
    public int getCost() {
        return Setting.COST_GARAGE;
    }

    @Override
    public Permission getPermission() {
        return Permission.INVEST_MACHINES;
    }
}
