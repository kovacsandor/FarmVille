package component;

import constrain.Commodity;
import game.Setting;
import kind.Consumption;

public class ThreshingMachine extends Machine {

    @Override
    public void pay() {
        Commodity.recoup(Setting.COST_THRESHING_MACHINE);
    }

    @Override
    public int getConsumption() {
        return Setting.CONSUMPTION_THRESHING_MACHINE;
    }

    @Override
    public Consumption getConsumptionKind() {
        return Consumption.MONEY;
    }
}
