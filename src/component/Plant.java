package component;

public abstract class Plant extends Installation {

    private int price;

    protected Plant() {
        initializePrice();
    }

    protected abstract void initializePrice();

    public int getPrice() {
        return price;
    }

    protected void setPrice(int price) {
        this.price = price;
    }
}
