package component;

import constrain.Commodity;

public abstract class Inventory implements Commodity {

    /**
     * <p>Returns the class which the Inventory is dependent of.</p>
     *
     * @return the class which the Inventory is dependent of
     */
    public abstract Class getDependecy();
}
