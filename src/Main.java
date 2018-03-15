import component.Field;
import game.Model;
import game.Setting;
import view.Board;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int counter = 0;

        System.out.println("Welcome to Farmville!");
        System.out.print("Press enter to begin...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        System.out.print("counter: " + counter);

        Model.board = new ArrayList<>();
        for (int i=0; i < Setting.BOARD_SIZE; i++) {
            Model.board.add(new ArrayList<>());
            for (int j=0; j < Setting.BOARD_SIZE; j++) {
                Model.board.get(i).add(new Field(i, j));
            }
        }

        Board.draw(Model.board);

        while(counter < 10) {
            scanner.nextLine();
            counter++;
            System.out.print("counter: " + counter);
        }
    }
}
