package component;

import constrain.Permissive;
import game.Setting;
import kind.Permission;

public class Microscope extends Inventory implements Permissive {

    @Override
    public int getCost() {
        return Setting.COST_MICROSCOPE;
    }

    @Override
    public Permission getPermission() {
        return Permission.DECREASE_INFECTION_CHANCE_3;
    }

    @Override
    public Permission getPrecondition() {
        return Permission.RESEARCH;
    }
}
