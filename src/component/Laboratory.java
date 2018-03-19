package component;

import game.Setting;

/**
 * <p>Main component of the game.</p>
 */
public class Laboratory extends Building {

    @Override
    protected int getInstallationTime() {
        return Setting.BUILD_TIME_LABORATORY;
    }

    @Override
    public int getCost() {
        return Setting.COST_LABORATORY;
    }
}
