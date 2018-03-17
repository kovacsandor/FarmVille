package component;

import game.Setting;
import kind.Consumption;

public class FowlHouse extends RaisingFacility {

    @Override
    protected void initializeInstallationTime() {
        setInstallationTime(Setting.BUILD_TIME_FOWL_HOUSE);
    }

    @Override
    protected void initializeIncome() {
        this.setIncome(Setting.INCOME_FOWL_HOUSE);
    }

    @Override
    public int getCost() {
        return Setting.COST_FOWL_HOUSE;
    }

    @Override
    public int getConsumption() {
        return Setting.CONSUMPTION_FOWL_HOUSE;
    }

    @Override
    public Consumption getConsumptionKind() {
        return Consumption.CORN;
    }
}
