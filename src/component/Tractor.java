package component;

import game.Setting;
import kind.Consumption;
import kind.Permission;

public class Tractor extends Machine {

    @Override
    public int getCost() {
        return Setting.COST_TRACTOR;
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

    @Override
    public Permission getPrecondition() {
        return Permission.INVEST_MACHINES;
    }
}
