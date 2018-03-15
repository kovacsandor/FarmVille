package view;

import game.Model;
import game.Setting;

public class Aside {

    public static void draw(int line) {
        String result;
        switch (line) {
            case 0:
                result = Model.keeper.getName() + "'s money:";
                break;
            case 1:
                result = String.format("%,d", Model.keeper.getMoney()) + " " + Setting.CURRENCY;
                break;
            case 3:
                result = "Day: " + Model.day;
                break;
            default:
                result = "";
        }
        System.out.print(result);
    }
}
