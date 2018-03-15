package component;

import constrain.Commodity;

public abstract class Building implements Commodity {

    private int buildTime;

    public Building() {
        initializeBuildTime();
    }

    protected abstract void initializeBuildTime();

    public int getBuildTime() {
        return buildTime;
    }

    protected void setBuildTime(int buildTime) {
        this.buildTime = buildTime;
    }
}
