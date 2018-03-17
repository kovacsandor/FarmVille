package component;

import game.Setting;

public class FireExtinguisher extends Inventory {

    @Override
    public int getCost() {
        return Setting.COST_FIRE_EXTINGUISHER;
    }

    @Override
    public Class getDependecy() {
        return FireStation.class;
    }
}
