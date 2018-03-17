package component;

import constrain.Permissive;
import game.Setting;
import kind.Permission;

public class Incubator extends Inventory implements Permissive {

    @Override
    public int getCost() {
        return Setting.COST_INCUBATOR;
    }

    @Override
    public Permission getPermission() {
        return Permission.DECREASE_INFECTION_CHANCE_2;
    }

    @Override
    public Permission getPrecondition() {
        return Permission.RESEARCH;
    }
}
