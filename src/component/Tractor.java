package component;

import constrain.Commodity;
import kind.Consumption;
import kind.Permission;
import game.Setting;

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

    @Override
    public Permission getPermission() {
        return Permission.PLANT_MULTIPLE_FIELDS;
    }
}
