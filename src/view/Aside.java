package view;

import component.Inventory;
import component.Plant;
import game.Model;
import game.Setting;

import java.util.ArrayList;
import java.util.List;

public class Aside {

    /**
     * <p>Attaches aside information to the board.</p>
     *
     * @param line - the current line
     */
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
        list.add("Command " + String.format("%2d", (kind.Action.BUILD_GARAGE.ordinal() + 1))
                + " | " + kind.Action.BUILD_GARAGE
                + " - " + String.format("%,d", Setting.COST_GARAGE) + " " + Setting.CURRENCY);
        list.add("Command " + String.format("%2d", (kind.Action.BUILD_FIRE_STATION.ordinal() + 1))
                + " | " + kind.Action.BUILD_FIRE_STATION
                + " - " + String.format("%,d", Setting.COST_FIRE_STATION) + " " + Setting.CURRENCY);
        list.add("Command " + String.format("%2d", (kind.Action.BUILD_FOWL_HOUSE.ordinal() + 1))
                + " | " + kind.Action.BUILD_FOWL_HOUSE
                + " - " + String.format("%,d", Setting.COST_FOWL_HOUSE) + " " + Setting.CURRENCY);
        list.add("Command " + String.format("%2d", (kind.Action.BUILD_LABORATORY.ordinal() + 1))
                + " | " + kind.Action.BUILD_LABORATORY
                + " - " + String.format("%,d", Setting.COST_LABORATORY) + " " + Setting.CURRENCY);
        list.add("Command " + String.format("%2d", (kind.Action.BUILD_PIGPEN.ordinal() + 1))
                + " | " + kind.Action.BUILD_PIGPEN
                + " - " + String.format("%,d", Setting.COST_PIGPEN) + " " + Setting.CURRENCY);
        list.add("Command " + String.format("%2d", (kind.Action.BUY_FIELD.ordinal() + 1))
                + " | " + kind.Action.BUY_FIELD
                + " - " + String.format("%,d", Setting.COST_FIELD) + " " + Setting.CURRENCY);
        list.add("Command " + String.format("%2d", (kind.Action.FINISH_TURN.ordinal() + 1))
                + " | " + kind.Action.FINISH_TURN);
        list.add("Command " + String.format("%2d", (kind.Action.HARVEST.ordinal() + 1))
                + " | " + kind.Action.HARVEST);
        list.add("Command " + String.format("%2d", (kind.Action.INVEST_FIRE_EXTINGUISHER.ordinal() + 1))
                + " | " + kind.Action.INVEST_FIRE_EXTINGUISHER
                + " - " + String.format("%,d", Setting.COST_FIRE_EXTINGUISHER) + " " + Setting.CURRENCY);
        list.add("Command " + String.format("%2d", (kind.Action.INVEST_FIRE_PLUG.ordinal() + 1))
                + " | " + kind.Action.INVEST_FIRE_PLUG
                + " - " + String.format("%,d", Setting.COST_FIRE_PLUG) + " " + Setting.CURRENCY);
        list.add("Command " + String.format("%2d", (kind.Action.INVEST_INCUBATOR.ordinal() + 1))
                + " | " + kind.Action.INVEST_INCUBATOR
                + " - " + String.format("%,d", Setting.COST_INCUBATOR) + " " + Setting.CURRENCY);
        list.add("Command " + String.format("%2d", (kind.Action.INVEST_MICROSCOPE.ordinal() + 1))
                + " | " + kind.Action.INVEST_MICROSCOPE
                + " - " + String.format("%,d", Setting.COST_MICROSCOPE) + " " + Setting.CURRENCY);
        list.add("Command " + String.format("%2d", (kind.Action.INVEST_THRESHING_MACHINE.ordinal() + 1))
                + " | " + kind.Action.INVEST_THRESHING_MACHINE
                + " - " + String.format("%,d", Setting.COST_THRESHING_MACHINE) + " " + Setting.CURRENCY);
        list.add("Command " + String.format("%2d", (kind.Action.INVEST_TRACTOR.ordinal() + 1))
                + " | " + kind.Action.INVEST_TRACTOR
                + " - " + String.format("%,d", Setting.COST_TRACTOR) + " " + Setting.CURRENCY);
        list.add("Command " + String.format("%2d", (kind.Action.PLANT_BARLEY.ordinal() + 1))
                + " | " + kind.Action.PLANT_BARLEY
                + " - " + String.format("%,d", Setting.COST_BARLEY) + " " + Setting.CURRENCY);
        list.add("Command " + String.format("%2d", (kind.Action.PLANT_CORN.ordinal() + 1))
                + " | " + kind.Action.PLANT_CORN
                + " - " + String.format("%,d", Setting.COST_CORN) + " " + Setting.CURRENCY);
        list.add("Command " + String.format("%2d", (kind.Action.PLANT_OATS.ordinal() + 1))
                + " | " + kind.Action.PLANT_OATS
                + " - " + String.format("%,d", Setting.COST_OATS) + " " + Setting.CURRENCY);
        list.add("Command " + String.format("%2d", (kind.Action.PLANT_RICE.ordinal() + 1))
                + " | " + kind.Action.PLANT_RICE
                + " - " + String.format("%,d", Setting.COST_RICE) + " " + Setting.CURRENCY);
        list.add("Command " + String.format("%2d", (kind.Action.PLANT_WHEAT.ordinal() + 1))
                + " | " + kind.Action.PLANT_WHEAT
                + " - " + String.format("%,d", Setting.COST_WHEAT) + " " + Setting.CURRENCY);
        list.add("Command " + String.format("%2d", (kind.Action.SELL_CROP.ordinal() + 1))
                + " | " + kind.Action.SELL_CROP);
        if (list.size() < 26) {
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