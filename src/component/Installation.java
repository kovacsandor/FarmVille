package component;

import constrain.Commodity;
import game.Model;

public abstract class Installation implements Commodity {

    private int dayInstalled;

    protected Installation() {
        this.dayInstalled = Model.day;
    }

    public boolean isReady() {
        return Model.day - dayInstalled > getInstallationTime();
    }

    protected abstract int getInstallationTime();
}
