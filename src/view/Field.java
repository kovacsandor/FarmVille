package view;

import component.*;

public class Field {

    public static String draw(component.Field field) {
        String result;
        if (field.getPlant() == null) {
            result = "[]";
        } else if (field.getIsActionExecuted()) {
            result = "X ";
        } else if (field.getPlant().getClass() == Barley.class) {
            result = "B ";
        } else if (field.getPlant().getClass() == Corn.class) {
            result = "C ";
        } else if (field.getPlant().getClass() == Oats.class) {
            result = "O ";
        } else if (field.getPlant().getClass() == Rice.class) {
            result = "R ";
        } else if (field.getPlant().getClass() == Wheat.class) {
            result = "W ";
        } else {
            throw new RuntimeException("Unexpected scenario.");
        }
        return result;
    }
}
