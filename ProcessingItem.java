import java.math.BigInteger;

public abstract class ProcessingItem extends Item{
    protected Ore ore;
    // private ProcessingItem itemToPushTo = itemInFront;
    
    public ProcessingItem(int positionX, int positionY, String itemName, int dimensionX, int dimensionY, Direction direction, ItemTier tier, ItemType type, BigInteger value) {
        super(positionX, positionY, itemName, dimensionX, dimensionY, direction, tier, type, value);
    }

    public ProcessingItem() {

    }
    
    public void processOre() {
        if (ore != null) {
            process(ore);
        }
    }

    public void pushToItem() {
        if (itemInFront != null && itemInFront.isEmpty()) {
            itemInFront.setOre(this.ore);
            setOre(null);
        }
    }

    public void processAndPush() {
        if (ore != null) {
            processOre();
            pushToItem();
        }
    }

    public void setOre(Ore oreToBeStored) {
        this.ore = oreToBeStored;
    }
    public boolean isEmpty() {
        return ore == null;
    }
    public abstract void process(Ore ore);


}