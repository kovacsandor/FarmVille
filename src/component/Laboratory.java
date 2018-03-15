package component;

import constrain.Commodity;
import kind.Permission;
import game.Setting;

public class Laboratory extends Infrastructure {

    @Override
    protected void initializeBuildTime() {
        setBuildTime(Setting.BUILD_TIME_LABORATORY);
    }

    @Override
    public void pay() {
        Commodity.recoup(Setting.COST_LABORATORY);
    }

    @Override
    public Permission getPermission() {
        return Permission.RESEARCH;
    }
}
