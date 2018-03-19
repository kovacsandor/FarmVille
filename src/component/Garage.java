package component;

import game.Setting;

/**
 * <p>Main component of the game.</p>
 */
public class Garage extends Building {

    @Override
    protected int getInstallationTime() {
        return Setting.BUILD_TIME_GARAGE;
    }

    @Override
    public int getCost() {
        return Setting.COST_GARAGE;
    }
}
