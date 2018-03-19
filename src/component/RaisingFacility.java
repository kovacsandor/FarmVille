package component;

import constrain.Consumptive;

/**
 * <p>A Building that consumes.</p>
 */
public abstract class RaisingFacility extends Building implements Consumptive {

    /**
     * <p>Returns the income after the facility.</p>
     *
     * @return the income after the facility
     */
    public abstract int getIncome();
}
