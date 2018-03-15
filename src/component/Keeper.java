package component;

import game.Setting;

public class Keeper {

    private int money = Setting.MONEY;

    private String name;

    public Keeper(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }
}
