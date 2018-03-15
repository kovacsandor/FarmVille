package game;

import component.Field;
import component.Keeper;
import component.Plant;

import java.util.List;

public class Model {

    public static List<List<Field>> board;
    public static int day = Setting.STARTING_DAY;
    public static List<Plant> granary;
    public static Keeper keeper;
}
