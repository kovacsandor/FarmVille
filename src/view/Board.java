package view;

import component.Field;

import java.util.List;

public class Board {

    public static void draw(List<List<Field>> board) {
        int extraLine = 0;
        for (int i = 0; i < board.size(); i++) {
            if (i % 10 == 0) {
                System.out.println();
                System.out.print("   ");
                for (int j = 0; j < board.get(i).size(); j++) {
                    System.out.print(((j + 1) % 10 == 0 ? j + 1 : ((j + 1) % 10)) + " ");
                }
                System.out.print("   | ");
                Aside.draw(i + extraLine);
                extraLine++;
            }
            System.out.println();
            System.out.print(String.format("%2d", i + 1));
            for (int j = 0; j < board.get(i).size(); j++) {
                System.out.print((j % 10 == 0 ? " " : "") + view.Field.draw(board.get(i).get(j)));
            }
            System.out.print(String.format("%3d", i + 1) + " | ");
            Aside.draw(i + extraLine);
        }
        System.out.println();
        System.out.println();
    }
}
