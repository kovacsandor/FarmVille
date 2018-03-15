package view;

import component.Field;

import java.util.List;

public class Board {

    public static void draw(List<List<Field>> board) {
        for(int i = 0; i< board.size(); i++) {
            System.out.println();
            for(int j = 0; j< board.get(i).size(); j++) {
                System.out.print("[]");
            }
        }
    }
}
