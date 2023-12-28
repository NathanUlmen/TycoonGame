//The Dropper class "pops"/pulls ore objects from the ore realm "decorates" them with their base stats and properties
//and then inserts them into the item infront of them.


import java.math.BigDecimal;

public abstract class Dropper extends Item{
    protected Ore ore;
    private int dropRate; // The number of ore objects to be dropped per second
    private int totalOreDropped; //The number of ore objects this dropper has created.
    protected boolean canDrop;
    protected final static OreRealm oreRealm = OreRealm.getOreRealmInstance();
    
    

    public Dropper(int dropRate, int positionX, int positionY, String itemName, int dimensionX, int dimensionY, Direction direction, ItemTier tier) {
        super(positionX, positionY, itemName, dimensionX, dimensionY, direction, tier, ItemType.DROPPER);
        this.dropRate = dropRate;
    }

    public void dropOre() {
        if (itemInFront != null && itemInFront.isEmpty() && !oreRealm.isEmpty()) {
            Ore ore = createOre();
            ore.applyBaseStats(baseOreValue(), startingTemp(), startingMultiOre(), setName());
            itemInFront.setOre(ore);
            totalOreDropped++;
            //System.out.println("Dropped!");
        }
    }

    //returns the total number of ore that the dropper has produced.
    public int getTotalOreDropped() {
        return totalOreDropped;
    }

    //creates an ore object
    protected Ore createOre(){
        return oreRealm.pop();
    }

    protected abstract BigDecimal baseOreValue();

    protected abstract int startingMultiOre();

    protected abstract String setName();

    protected abstract int startingTemp();

    public String toString() {
        return "Dropper Name: " + getItemName() + "\tTotal Ore Dropped: " + totalOreDropped + "\tPosition: X:" + getPositionX() + " Y:" + getPositionY();
    }
   
}
