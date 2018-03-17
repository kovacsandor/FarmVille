package component;

import game.Setting;
import kind.Consumption;
import kind.Permission;

public class ThreshingMachine extends Machine {

    @Override
    public int getCost() {
        return Setting.COST_THRESHING_MACHINE;
    }

    @Override
    public int getConsumption() {
        return Setting.CONSUMPTION_THRESHING_MACHINE;
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
    protected void initializePrecondition() {
        setPrecondition(Permission.INVEST_MACHINES);
    }
}
