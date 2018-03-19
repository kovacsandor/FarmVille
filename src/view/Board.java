package view;

import component.Field;

import java.util.List;

public class Board {

    /**
     * <p>Draws a board.</p>
     *
     * @param board - a two dimensional array of Fields
     */
    public static void draw(List<List<Field>> board) {
        int extraLine = 0;
        boolean isMaxLengthSet = false;
        int maxLength = 3;
        for (int i = 0; i < board.size(); i++) {
            int currentLength = 4;
            if (board.get(0).size() > 49) {
                currentLength -= 2;
            } else if (board.get(0).size() > 39) {
                currentLength -= 1;
            }
            if (i % 10 == 0) {
                int helperLineCurrentLength = 3;
                System.out.println();
                System.out.print("   ");
                for (int j = 0; j < board.get(i).size(); j++) {
                    System.out.print(((j + 1) % 10 == 0 ? j + 1 : ((j + 1) % 10)) + " ");
                    if (!isMaxLengthSet) {
                        maxLength += 2;
                    }
                    helperLineCurrentLength += 2;
                }
                if (!isMaxLengthSet) {
                    maxLength += board.get(i).size() % 10 == 0 ? 4 : 5;
                }
                if (i != 0) {
                    for (int j = 0; j < maxLength - helperLineCurrentLength - currentLength; j++) {
                        System.out.print(" ");
                    }
                }
                System.out.print(board.get(i).size() % 10 == 0 ? "| " : " | ");
                isMaxLengthSet = true;
                Aside.draw(i + extraLine);
                extraLine++;
            }
            System.out.println();
            System.out.print(String.format("%2d", i + 1));
            for (int j = 0; j < board.get(i).size(); j++) {
                System.out.print((j % 10 == 0 ? " " : "") + view.Field.draw(board.get(i).get(j)));
                currentLength += j % 10 == 0 ? 3 : 2;
            }
            for (int j = 0; j < maxLength - currentLength; j++) {
                System.out.print(" ");
            }
            System.out.print(" | ");
            Aside.draw(i + extraLine);
        }
        System.out.println();
        System.out.println();
    }
}
