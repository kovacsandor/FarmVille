package constrain;

import game.Model;

public interface Commodity {

    static void recoup(int cost) {
        Model.keeper.setMoney(Model.keeper.getMoney() - cost);
    }

    void pay();
}
