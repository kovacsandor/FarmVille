package component;

import constrain.Commodity;
import game.Model;

public abstract class Plant implements Commodity {

    private int dayPlanted;
    private int price;
    private int ripenTime;

    protected Plant() {
        this.dayPlanted = Model.day;
        initializePrice();
        initializeRipenTime();
    }

    protected abstract void initializePrice();

    protected abstract void initializeRipenTime();

    public boolean isRipe() {
        return Model.day - dayPlanted > ripenTime;
    }

    public int getPrice() {
        return price;
    }

    protected void setPrice(int price) {
        this.price = price;
    }

    public int getRipenTime() {
        return ripenTime;
    }

    protected void setRipenTime(int ripenTime) {
        this.ripenTime = ripenTime;
    }
}
