package game;

import component.Field;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * <p>Sets the defaults to the game.</p>
 */
public class Setup {

    public Setup() {
        System.out.println("Welcome to Farmville!");
        System.out.println("Enter your name and press enter to begin...");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        Model.day = Setting.STARTING_DAY;
        Model.board = new ArrayList<>();
        Model.inventories = new ArrayList<>();
        Model.money = Setting.MONEY;
        Model.name = name.length() > 0 ? name : Setting.KEEPER_NAME;
        Model.granary = new ArrayList<>();
        for (int i = 0; i < Setting.BOARD_SIZE; i++) {
            Model.board.add(new ArrayList<>());
            for (int j = 0; j < Setting.BOARD_SIZE; j++) {
                Model.board.get(i).add(new Field(i, j));
            }
        }
    }
}
