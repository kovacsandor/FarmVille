import components.Dice;
import model.Model;
import view.Roll;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Model.dice = new Dice[]{new Dice(), new Dice()};

        while (!Model.isGameOver) {
            System.out.println("Press enter...");
            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();
            Dice[] dice = Model.dice;
            for (int i = 0; i < dice.length; i++) {
                Dice d = dice[i];
                d.roll();
                if (d.getValue() == 6) {
                    Model.isGameOver = true;
                }
            }
            Roll.draw("Rolls: ");
        }

        System.out.println("You won!");
    }
}
