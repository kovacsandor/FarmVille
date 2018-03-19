package component;

import constrain.Commodity;
import game.Model;

public abstract class Installation implements Commodity {

    private int dayInstalled;

    Installation() {
        this.dayInstalled = Model.day;
    }

    /**
     * <p>Returns {@code true} if the installation is ready.</p>
     *
     * @return {@code true} if the installation is ready
     */
    public boolean isReady() {
        return Model.day - dayInstalled > getInstallationTime();
    }

    /**
     * <p>Returns the installation time.</p>
     *
     * @return the installation time
     */
    protected abstract int getInstallationTime();
}
