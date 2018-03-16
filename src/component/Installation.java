package component;

import constrain.Commodity;
import game.Model;

public abstract class Installation implements Commodity {

    private int dayInstalled;
    private int installationTime;

    protected Installation() {
        this.dayInstalled = Model.day;
        initializeInstallationTime();
    }

    protected abstract void initializeInstallationTime();

    public boolean isReady() {
        return Model.day - dayInstalled > installationTime;
    }

    public int getInstallationTime() {
        return installationTime;
    }

    protected void setInstallationTime(int installationTime) {
        this.installationTime = installationTime;
    }
}
