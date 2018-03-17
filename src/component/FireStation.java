package component;

import game.Setting;
import kind.Permission;

public class FireStation extends Infrastructure {

    @Override
    protected void initializeInstallationTime() {
        setInstallationTime(Setting.BUILD_TIME_FIRE_STATION);
    }

    @Override
    public int getCost() {
        return Setting.COST_FIRE_STATION;
    }

    @Override
    public Permission getPermission() {
        return Permission.INVEST_ESTINGUISHER;
    }
}
