public abstract class Item {
    
    private int positionX;
    public int positionY;
    private int dimensionX;
    private int dimensionY;
    private String itemName;

    public Item(int positionX, int positionY, String itemName, int dimensionX, int dimensionY) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.itemName = itemName;
        this.dimensionX = dimensionX;
        this.dimensionY = dimensionY;
    }

    public Item() {
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionX(int newX) {
        positionX = newX;
    }

    public void setPositionY(int newY) {
        positionY = newY;
    }

    public int getDimensionX() {
        return dimensionX;
    }

    public int getDimensionY() {
        return dimensionY;
    }

    public void setDimensionX() {

    }

    public void setDimensionY() {

    }

    public String getItemName() {
        return itemName;
    }

    public String toString() {
        String blab = "";
        return blab;
    }
}
