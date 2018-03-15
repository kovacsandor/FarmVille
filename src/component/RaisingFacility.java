package component;

import constrain.Consumptive;

public abstract class RaisingFacility extends Building implements Consumptive {

    private int income;

    protected RaisingFacility() {
        initializeIncome();
    }

    protected abstract void initializeIncome();

    public int getIncome() {
        return income;
    }

    protected void setIncome(int income) {
        this.income = income;
    }
}
