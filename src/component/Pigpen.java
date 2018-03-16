package component;

import constrain.Commodity;
import game.Setting;
import kind.Consumption;

public class Pigpen extends RaisingFacility {

    @Override
    protected void initializeInstallationTime() {
        setInstallationTime(Setting.BUILD_TIME_PIGPEN);
    }

    @Override
    protected void initializeIncome() {
        this.setIncome(Setting.INCOME_PIGPEN);
    }

    @Override
    public void pay() {
        Commodity.recoup(Setting.COST_PIGPEN);
    }

    @Override
    public int getConsumption() {
        return Setting.CONSUMPTION_PIGPEN;
    }

    @Override
    public Consumption getConsumptionKind() {
        return Consumption.CORN;
    }
}
