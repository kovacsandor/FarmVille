package component;

import constrain.Commodity;
import kind.Permission;
import game.Setting;

public class FireStation extends Infrastructure {

    @Override
    protected void initializeBuildTime() {
        setBuildTime(Setting.BUILD_TIME_FIRE_STATION);
    }

    @Override
    public void pay() {
        Commodity.recoup(Setting.COST_FIRE_STATION);
    }

    @Override
    public Permission getPermission() {
        return Permission.INVEST_ESTINGUISHER;
    }
}
