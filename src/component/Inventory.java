package component;

import constrain.Commodity;
import constrain.Permissive;
import kind.Permission;

public abstract class Inventory implements Commodity, Permissive {

    public abstract Permission getPrecondition();
}
