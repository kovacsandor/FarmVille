package component;

import constrain.Commodity;
import game.Setting;

public class Garage extends Building {

    @Override
    protected void initializeInstallationTime() {
        setInstallationTime(Setting.BUILD_TIME_GARAGE);
    }

    @Override
    public void pay() {
        Commodity.recoup(Setting.COST_GARAGE);
    }
}
