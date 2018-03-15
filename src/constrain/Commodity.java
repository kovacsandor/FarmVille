package constrain;

import game.Model;

public interface Commodity {

    void pay();

    static void recoup(int cost) {
        Model.keeper.setMoney(Model.keeper.getMoney() - cost);
    }
}
