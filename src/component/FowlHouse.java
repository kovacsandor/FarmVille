package component;

import constrain.Commodity;
import kind.Consumption;
import game.Setting;

public class FowlHouse extends RaisingFacility {

    @Override
    protected void initializeBuildTime() {
        this.setBuildTime(Setting.BUILD_TIME_FOWL_HOUSE);
    }

    @Override
    protected void initializeIncome() {
        this.setIncome(Setting.INCOME_FOWL_HOUSE);
    }

    @Override
    public void pay() {
        Commodity.recoup(Setting.COST_FOWL_HOUSE);
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
