package view;

import components.Dice;
import model.Model;

public class Roll {

    public static void draw() {
        draw(null);
    }

    public static void draw(String label) {
        String[] rows = new String[]{"", "", ""};
        Dice[] dice = Model.dice;
        int count = dice.length;
        for (int i = 0; i < count; i++) {
            String[] r = drawDice(dice[i]);
            for (int j = 0; j < r.length; j++) {
                rows[j] += r[j];
                if (i + 1 < count) {
                    rows[j] += " | ";
                }
            }
        }
        if (label != null) {
            System.out.println(label);
        }
        for (String row : rows) {
            System.out.println(row);
        }
        System.out.println();
    }

    private static String[] drawDice(Dice dice) {
        String[] result;
        int value = dice.getValue();
        switch (value) {
            case 1:
                result = new String[]{"      ", "  []  ", "      "};
                break;
            case 2:
                result = new String[]{"[]    ", "      ", "    []"};
                break;
            case 3:
                result = new String[]{"[]    ", "  []  ", "    []"};
                break;
            case 4:
                result = new String[]{"[]  []", "      ", "[]  []"};
                break;
            case 5:
                result = new String[]{"[]  []", "  []  ", "[]  []"};
                break;
            case 6:
                result = new String[]{"[]  []", "[]  []", "[]  []"};
                break;
            default:
                throw new RuntimeException("Invalid value: " + value);
        }
        return result;
    }
}
