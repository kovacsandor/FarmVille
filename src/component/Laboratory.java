package component;

import constrain.Commodity;
import game.Setting;

public class Laboratory extends Building {

    @Override
    protected void initializeInstallationTime() {
        setInstallationTime(Setting.BUILD_TIME_LABORATORY);
    }

    @Override
    public void pay() {
        Commodity.recoup(Setting.COST_LABORATORY);
    }
}
