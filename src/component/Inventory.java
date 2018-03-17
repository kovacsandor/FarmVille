package component;

import constrain.Commodity;
import constrain.Permissive;
import kind.Permission;

public abstract class Inventory implements Commodity, Permissive {

    private Permission precondition;

    protected Inventory() {
        initializePrecondition();
    }

    protected abstract void initializePrecondition();

    public Permission getPrecondition() {
        return precondition;
    }

    protected void setPrecondition(Permission precondition) {
        this.precondition = precondition;
    }
}
