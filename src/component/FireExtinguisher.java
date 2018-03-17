package component;

import constrain.Permissive;
import game.Setting;
import kind.Permission;

public class FireExtinguisher extends Inventory implements Permissive {

    @Override
    public int getCost() {
        return Setting.COST_FIRE_EXTINGUISHER;
    }

    @Override
    public Permission getPermission() {
        return Permission.DECREASE_FIRE_CHANCE;
    }

    @Override
    public Permission getPrecondition() {
        return Permission.INVEST_ESTINGUISHER;
    }
}
