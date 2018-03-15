package component;

import constrain.Commodity;
import game.Setting;

public class Wheat extends Plant {

    @Override
    protected void initializePrice() {
        setPrice(Setting.PRICE_WHEAT);
    }

    @Override
    protected void initializeRipenTime() {
        setRipenTime(Setting.RIPEN_TIME_WHEAT);
    }

    @Override
    public void pay() {
        Commodity.recoup(Setting.COST_WHEAT);
    }
}
