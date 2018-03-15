package component;

import constrain.Commodity;
import kind.Permission;
import game.Setting;

public class Garage extends Infrastructure {

    @Override
    protected void initializeBuildTime() {
        setBuildTime(Setting.BUILD_TIME_GARAGE);
    }

    @Override
    public void pay() {
        Commodity.recoup(Setting.COST_GARAGE);
    }

    @Override
    public Permission getPermission() {
        return Permission.INVEST_MACHINES;
    }
}
