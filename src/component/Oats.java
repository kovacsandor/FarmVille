package component;

import constrain.Commodity;
import game.Setting;

public class Oats extends Plant {

    @Override
    protected void initializePrice() {
        this.setPrice(Setting.PRICE_OATS);
    }

    @Override
    protected void initializeRipenTime() {
        this.setRipenTime(Setting.RIPEN_TIME_OATS);
    }

    @Override
    public void pay() {
        Commodity.recoup(Setting.COST_OATS);
    }
}
