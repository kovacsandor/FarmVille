package component;

import game.Setting;

/**
 * <p>Main component of the game.</p>
 */
public class FireStation extends Building {

    @Override
    protected int getInstallationTime() {
        return Setting.BUILD_TIME_FIRE_STATION;
    }

    @Override
    public int getCost() {
        return Setting.COST_FIRE_STATION;
    }
}
