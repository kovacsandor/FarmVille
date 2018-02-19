package components;

public class Dice {

    private int sides = 6;
    private int value;

    public void roll() {
        value = (int) Math.floor(Math.random() * sides) + 1;
    }

    public int getValue() {
        return value;
    }
}
