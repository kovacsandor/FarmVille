package component;

import constrain.Commodity;
import game.Setting;

public class Barley extends Plant {

    @Override
    protected void initializePrice() {
        this.setPrice(Setting.PRICE_BARLEY);
    }

    @Override
    protected void initializeRipenTime() {
        this.setRipenTime(Setting.RIPEN_TIME_BARLEY);
    }

    @Override
    public void pay() {
        Commodity.recoup(Setting.COST_BARLEY);
    }
}
