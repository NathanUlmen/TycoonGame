import java.math.BigInteger;

public abstract class Item implements Morphable {

    // public enum Direction {UPWARDS, RIGHT, DOWN, LEFT }
    public enum ItemType {DROPPER, FURNACE, UPGRADER, CONVEYOR}

    protected ItemType type;
    private Direction direction;
    protected ItemTier tier;
    protected ProcessingItem itemInFront, itemBehind, itemToRight, itemToLeft;
    protected int positionX;
    public int positionY;
    private int dimensionX;
    private int dimensionY;



    private String itemName, itemDescription;
    protected static final TheMap theMap = TheMap.getTheMapInstance();
    protected BigInteger itemValue;
    protected final OreRealm oreRealm = OreRealm.getOreRealmInstance();

    //might not need theGameQueue after Tycoon builder is done.
    public Item( String itemName, String itemDescription, String value) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        itemValue = new BigInteger(value);

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

    public void placeItem(int X, int Y, Direction direction) {
        this.direction = direction;
        this.positionX = X;
        this.positionY = Y;
        theMap.addItemToMap(this, X, Y);
    }

    public void removeItem() {
        theMap.removeItemFromMap(this.positionX, this.positionY);
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

    public Item determineItemInFront() {
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

    public Item determineItemBehind() {
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

    public Item determineItemToRight() {
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

    public Item determineItemToLeft() {
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

//    private void setItemsRelativeToDirection(Direction direction) {
//        int newX = positionX;
//        int newY = positionY;
//
//        switch (direction) {
//            case UPWARDS -> {
//                itemInFront = theMap.getItem(positionX, positionY+1);
//                itemBehind = theMap.getItem();
//                itemToRight = theMap.getItem();
//                itemToLeft = theMap.getItem();
//                break;
//            }
//            case RIGHT -> {
//                itemInFront = theMap.getItem();
//                itemBehind = theMap.getItem();
//                itemToRight = theMap.getItem();
//                itemToLeft = theMap.getItem();
//                break;
//            }
//            case DOWN -> {
//                itemInFront = theMap.getItem();
//                itemBehind = theMap.getItem();
//                itemToRight = theMap.getItem();
//                itemToLeft = theMap.getItem();
//                break;
//            }
//            case LEFT -> {
//                itemInFront = theMap.getItem();
//                itemBehind = theMap.getItem();
//                itemToRight = theMap.getItem();
//                itemToLeft = theMap.getItem();
//                break;
//            }
//        }
//    }

    public void setAllSurroundingItems() {
        setItemInFront();
        setItemBehind();
        setItemToRight();
        setItemToLeft();
    }

    public void setFrontAndBack() {
        setItemInFront();
        setItemBehind();
    }

    public void setItemInFront() {
        Item temp = determineItemInFront();
        if (temp instanceof ProcessingItem) {
            this.itemInFront = (ProcessingItem) temp;
        } else {
            itemInFront = null;
        }
    }

    public void setItemBehind() {
        Item temp = determineItemBehind();
        if (temp instanceof ProcessingItem) {
            this.itemBehind = (ProcessingItem) temp;
        } else {
            itemBehind = null;
        }
    }

    public void setItemToRight() {
        Item temp = determineItemToRight();
        if (temp instanceof ProcessingItem) {
            this.itemToRight = (ProcessingItem) temp;
        } else {
            itemToRight = null;
        }
    }

    public void setItemToLeft() {
        Item temp = determineItemToLeft();
        if (temp instanceof ProcessingItem) {
            this.itemToLeft = (ProcessingItem) temp;
        } else {
            itemToLeft = null;
        }
    }

    public BigInteger getValue() {
        return itemValue;
    }

    public String getValueString() {
        return itemValue.toString();
    }

    public ProcessingItem getItemInFront() {
        return this.itemInFront;
    }

    public ProcessingItem getItemBehind() {
        return this.itemBehind;
    }

    public ProcessingItem getItemToRight() {
        return this.itemToRight;
    }

    public ProcessingItem getItemToLeft() {
        return this.itemToLeft;
    }


    public ItemType getType() {
        return this.type;
    }

    public String getItemName() {
        return itemName;
    }

    public String toString() {
        return itemName;
    }

    public ItemTier getTier() {
        return this.tier;
    }

    public String getItemDescription() {
        return this.itemDescription;
    }

    public Class<?> getItemType() {
        return this.getClass();
    }
    public void setType(ItemType type) {
        this.type = type;
    }

    public void setTier(ItemTier tier) {
        this.tier = tier;
    }

    public void setItemInFront(ProcessingItem itemInFront) {
        this.itemInFront = itemInFront;
    }

    public void setItemBehind(ProcessingItem itemBehind) {
        this.itemBehind = itemBehind;
    }

    public void setItemToRight(ProcessingItem itemToRight) {
        this.itemToRight = itemToRight;
    }

    public void setItemToLeft(ProcessingItem itemToLeft) {
        this.itemToLeft = itemToLeft;
    }

    public void setDimensionX(int dimensionX) {
        this.dimensionX = dimensionX;
    }

    public void setDimensionY(int dimensionY) {
        this.dimensionY = dimensionY;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public void setItemValue(BigInteger itemValue) {
        this.itemValue = itemValue;
    }


}
