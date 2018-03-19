package component;

import constrain.Commodity;

public abstract class Inventory implements Commodity {

    /**
     * <p>Returns the class on which the Inventory is dependent.</p>
     * 
     * @return the class which the Inventory is dependent of
     */
    public abstract Class getDependecy();
}
