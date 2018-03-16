package component;

import constrain.Commodity;
import game.Setting;

public class FireStation extends Building {

    @Override
    protected void initializeInstallationTime() {
        setInstallationTime(Setting.BUILD_TIME_FIRE_STATION);
    }

    @Override
    public void pay() {
        Commodity.recoup(Setting.COST_FIRE_STATION);
    }
}
