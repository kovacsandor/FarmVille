package component;

import constrain.Commodity;

public abstract class Plant implements Commodity {

    private int price;
    private int ripenTime;

    protected Plant() {
        initializePrice();
        initializeRipenTime();
    }

    protected abstract void initializePrice();

    protected abstract void initializeRipenTime();

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
