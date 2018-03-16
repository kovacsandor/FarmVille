package component;

import constrain.Commodity;
import game.Setting;
import kind.Consumption;

public class Tractor extends Machine {

    @Override
    public void pay() {
        Commodity.recoup(Setting.COST_TRACTOR);
    }

    @Override
    public int getConsumption() {
        return Setting.CONSUMPTION_TRACTOR;
    }

    @Override
    public Consumption getConsumptionKind() {
        return Consumption.MONEY;
    }
}
