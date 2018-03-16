package constrain;

import game.Model;

public interface Commodity {

    static void recoup(int cost) {
        Model.money -= cost;
    }

    void pay();
}
