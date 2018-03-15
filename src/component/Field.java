package component;

import constrain.Commodity;
import game.Setting;

public class Field implements Commodity {

    private final int coordinateX;
    private final int coordinateY;
    private boolean isActionExecuted;

    private Plant plant;

    public Field(int coordinateX, int coordinateY){
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }

    @Override
    public void pay() {
        Commodity.recoup(Setting.COST_FIELD);
    }

    public int getCoordinateX() {
        return coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    public boolean getIsActionExecuted() {
        return isActionExecuted;
    }

    public void setIsActionExecuted(boolean isActionExecuted) {
        isActionExecuted = isActionExecuted;
    }

    public Plant getPlant() {
        return plant;
    }

    public void setPlant(Plant plant) {
        this.plant = plant;
    }
}
