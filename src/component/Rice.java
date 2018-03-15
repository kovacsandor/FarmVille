package component;

import constrain.Commodity;
import game.Setting;

public class Rice extends Plant {

    @Override
    protected void initializePrice() {
        this.setPrice(Setting.PRICE_RICE);
    }

    @Override
    protected void initializeRipenTime() {
        this.setRipenTime(Setting.RIPEN_TIME_RICE);
    }

    @Override
    public void pay() {
        Commodity.recoup(Setting.COST_RICE);
    }
}
