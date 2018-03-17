package view;

import component.Inventory;
import component.Plant;
import game.Model;
import game.Setting;

import java.util.ArrayList;
import java.util.List;

public class Aside {

    public static void draw(int line) {

        List<String> list = new ArrayList<>();
        list.add(Model.name + "'s money: " + String.format("%,d", Model.money) + " " + Setting.CURRENCY + " | Day: " + Model.day);
        if (Model.granary.size() > 0) {
            int total = 0;
            for (Plant plant : Model.granary) {
                total += plant.getPrice();
            }
            list.add("Granary total worth: " + String.format("%,d", total));
        }
        if (Model.inventories.size() > 0) {
            list.add("");
            list.add("Inventories:");
            for (Inventory inventory : Model.inventories) {
                list.add(inventory.getClass().getSimpleName());
            }
        }
        list.add("");
        list.add("BUILD_GARAGE - " + (kind.Action.BUILD_GARAGE.ordinal() + 1));
        list.add("BUILD_FIRE_STATION - " + (kind.Action.BUILD_FIRE_STATION.ordinal() + 1));
        list.add("BUILD_FOWL_HOUSE - " + (kind.Action.BUILD_FOWL_HOUSE.ordinal() + 1));
        list.add("BUILD_LABORATORY - " + (kind.Action.BUILD_LABORATORY.ordinal() + 1));
        list.add("BUILD_PIGPEN - " + (kind.Action.BUILD_PIGPEN.ordinal() + 1));
        list.add("BUY_FIELD - " + (kind.Action.BUY_FIELD.ordinal() + 1));
        list.add("FINISH_TURN - " + (kind.Action.FINISH_TURN.ordinal() + 1));
        list.add("HARVEST - " + (kind.Action.HARVEST.ordinal() + 1));
        list.add("INVEST_FIRE_EXTINGUISHER - " + (kind.Action.INVEST_FIRE_EXTINGUISHER.ordinal() + 1));
        list.add("INVEST_FIRE_PLUG - " + (kind.Action.INVEST_FIRE_PLUG.ordinal() + 1));
        list.add("INVEST_INCUBATOR - " + (kind.Action.INVEST_INCUBATOR.ordinal() + 1));
        list.add("INVEST_MICROSCOPE - " + (kind.Action.INVEST_MICROSCOPE.ordinal() + 1));
        list.add("INVEST_THRESHING_MACHINE - " + (kind.Action.INVEST_THRESHING_MACHINE.ordinal() + 1));
        list.add("INVEST_TRACTOR - " + (kind.Action.INVEST_TRACTOR.ordinal() + 1));
        list.add("PLANT_BARLEY - " + (kind.Action.PLANT_BARLEY.ordinal() + 1));
        list.add("PLANT_CORN - " + (kind.Action.PLANT_CORN.ordinal() + 1));
        list.add("PLANT_OATS - " + (kind.Action.PLANT_OATS.ordinal() + 1));
        list.add("PLANT_RICE - " + (kind.Action.PLANT_RICE.ordinal() + 1));
        list.add("PLANT_WHEAT - " + (kind.Action.PLANT_WHEAT.ordinal() + 1));
        list.add("SELL_CROP - " + (kind.Action.SELL_CROP.ordinal() + 1));
        if (Model.inventories.size() == 0) {
            list.add("");
            list.add("[] - Empty field | X - Under execution");
            list.add("B, b - Barley | C, c - Corn | O, o - Oats");
            list.add("R, r - Rice | W, w - Wheat");
            list.add("");
            list.add("F, f - Fowl house | P, p - Pigpen");
            list.add("S, s - Fire station | G, g - Garage");
            list.add("L, l - Laboratory");
        }
        if (list.size() > line) {
            System.out.print(list.get(line));
        }
    }
}