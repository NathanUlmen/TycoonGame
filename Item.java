public abstract class Item {
    protected Direction direction;
    protected ProcessingItem itemInFront, itemBehind, itemToRight, itemToLeft, itemToPushTo;

    protected int positionX;
    public int positionY;
    private int dimensionX;
    private int dimensionY;
    // private Direction direction;
    private String itemName;
    protected static TheMap theMap = new TheMap();
    // **
    private TheGameQueue itemQueue;

    public Item(int positionX, int positionY, String itemName, int dimensionX, int dimensionY, Direction direction) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.itemName = itemName;
        this.dimensionX = dimensionX;
        this.dimensionY = dimensionY;
        this.direction = direction;
        this.itemQueue = null;

        // switch (direction) {
        //     case 1:
        //         theMap.isFilled(positionX, positionY+1);
        //         break;
        //     case 2:
        //         theMap.isFilled(positionX+1, dimensionY);
        //         break;
        //     case 3:
        //         theMap.isFilled(dimensionX, dimensionY-1);
        //         break;
        //     case 4:
        //         theMap.isFilled(dimensionX-1, dimensionY);
        //         break;
        // }
    }

    public Item() {

    }

    public void placeItem(int X, int Y) {
        theMap.addItemToMap(this, X, Y);   
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

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction newDirection) {
        this.direction = newDirection;
    }

    public Item getItemInFront() {
        int newX = positionX;
        int newY = positionY;
    
        switch (direction) {
            case UPWARDS:
                newY = positionY + 1;
                break;
            case RIGHT:
                newX = positionX + 1;
                break;
            case DOWN:
                newY = positionY - 1;
                break;
            case LEFT:
                newX = positionX - 1;
                break;
        }
            return theMap.getItem(newX, newY);
    }

    public Item getItemBehind() {
        int newX = positionX;
        int newY = positionY;

        switch (direction) {
            case UPWARDS:
                newY = positionY - 1;
                break;
            case RIGHT:
                newX = positionX - 1;
                break;
            case DOWN:
                newY = positionY + 1;
                break;
            case LEFT:
                newX = positionX + 1;
                break;
        }
            return theMap.getItem(newX, newY);
    }

    public Item getItemToRight() {
        int newX = positionX;
        int newY = positionY;
    
        switch (direction) {
            case UPWARDS:
                newX = positionX + 1;
                break;
            case RIGHT:
                newY = positionY + 1;
                break;
            case DOWN:
                newX = positionX - 1;
                break;
            case LEFT:
                newY = positionY - 1;
                break;
        }
        return theMap.getItem(newX, newY);
    }

    public Item getItemToLeft() {
        int newX = positionX;
        int newY = positionY;
    
        switch (direction) {
            case UPWARDS:
                newX = positionX - 1;
                break;
            case RIGHT:
                newY = positionY - 1;
                break;
            case DOWN:
                newX = positionX + 1;
                break;
            case LEFT:
                newY = positionY + 1;
                break;
        }
        return theMap.getItem(newX, newY);
    }

    public void setItemInFront() {
        Item temp = getItemInFront();
        if (temp instanceof ProcessingItem) {
            itemToPushTo = this.itemInFront = (ProcessingItem) temp;
        } else {
            itemInFront = null;
        }
    }

    public void setItemBehind() {
        Item temp = getItemBehind();
        if (temp instanceof ProcessingItem) {
            this.itemBehind = (ProcessingItem) temp;
        } else {
            itemBehind = null;
        }
    }

    public void setItemToRight() {
        Item temp = getItemToRight();
        if (temp instanceof ProcessingItem) {
            this.itemToRight = (ProcessingItem) temp;
        } else {
            itemToRight = null;
        }
    }

    public void setItemToLeft() {
        Item temp = getItemToLeft();
        if (temp instanceof ProcessingItem) {
            this.itemToLeft = (ProcessingItem) temp;
        } else {
            itemToLeft = null;
        }
    }


    public String getItemName() {
        return itemName;
    }

    public String toString() {
        String blab = "";
        return blab;
    }

    // **
    public TheGameQueue getItemQueue() {
        return itemQueue;
    }

    // **

    public void setItemQueue(TheGameQueue queue) {
        this.itemQueue = queue;
    }


}
