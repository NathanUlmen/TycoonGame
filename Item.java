public abstract class Item {
    
    private int positionX;
    public int positionY;
    private int dimensionX;
    private int dimensionY;
    protected static int direction;
    private String itemName;
    private static TheMap theMap = new TheMap();

    public Item(int positionX, int positionY, String itemName, int dimensionX, int dimensionY, int direction) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.itemName = itemName;
        this.dimensionX = dimensionX;
        this.dimensionY = dimensionY;
        this.direction = direction;

        switch (direction) {
            case 1:
                theMap.isFilled(positionX, positionY+1);
                break;
            case 2:
                theMap.isFilled(positionX+1, dimensionY);
                break;
            case 3:
                theMap.isFilled(dimensionX, dimensionY-1);
                break;
            case 4:
                theMap.isFilled(dimensionX-1, dimensionY);
                break;
        }
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

    // public void setDimensionX() {

    // }

    // public void setDimensionY() {

    // }

    public String getItemName() {
        return itemName;
    }

    public String toString() {
        String blab = "";
        return blab;
    }
}
