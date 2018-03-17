package component;

import game.Setting;

public class Pigpen extends RaisingFacility {

    @Override
    protected int getInstallationTime() {
        return Setting.BUILD_TIME_PIGPEN;
    }

    @Override
    public int getIncome() {
        return Setting.INCOME_PIGPEN;
    }

    @Override
    public int getCost() {
        return Setting.COST_PIGPEN;
    }

    @Override
    public int getConsumption() {
        return Setting.CONSUMPTION_PIGPEN;
    }
}
