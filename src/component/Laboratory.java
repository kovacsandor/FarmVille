package component;

import game.Setting;
import kind.Permission;

public class Laboratory extends Infrastructure {

    @Override
    protected int getInstallationTime() {
        return Setting.BUILD_TIME_LABORATORY;
    }

    @Override
    public int getCost() {
        return Setting.COST_LABORATORY;
    }

    @Override
    public Permission getPermission() {
        return Permission.RESEARCH;
    }
}
