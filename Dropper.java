//The Dropper class "pops"/pulls ore objects from the ore realm "decorates" them with their base stats and properties
//and then inserts them into the item infront of them.


import java.math.BigDecimal;

public abstract class Dropper extends Item implements OreDecorator{
    protected Ore ore;
    protected OreDecorator internal;
    private int dropRate; // The number of ore objects to be dropped per second
    private int totalOreDropped; //The number of ore objects this dropper has created.
    protected boolean canDrop;
    protected static OreRealm oreRealm = OreRealm.getOreRealmInstance();
    
    

    public Dropper(int dropRate, int positionX, int positionY, String itemName, int dimensionX, int dimensionY, Direction direction) {
        super(positionX, positionY, itemName, dimensionX, dimensionY, direction);
        this.dropRate = dropRate;
    }

    public Dropper(Ore ore) {
        this.internal = null;
        this.ore = ore;
    }

    public void dropOre() {
        if (itemInFront != null && itemInFront.isEmpty()) {
            itemInFront.setStoredOre(createOre());
            totalOreDropped++;
            //System.out.println("Dropped!");
        }
    }

    @Override
    public Ore prepare() {
        Ore result = (ore != null) ? ore : internal.prepare();
        result.applyBaseStats(baseOreValue(), startingTemp(), startingMultiOre(), setName());
        return result;
    }

    //returns the total number of ore that the dropper has produced.
    public int getTotalOreDropped() {
        return totalOreDropped;
    }

    //creates an ore object
    protected abstract OreDecorator createOre();

    protected abstract BigDecimal baseOreValue();

    protected abstract int startingMultiOre();

    protected abstract String setName();

    protected abstract int startingTemp();

    public String toString() {
        return "Dropper Name: " + getItemName() + "\tTotal Ore Dropped: " + totalOreDropped + "\tPosition: X:" + getPositionX() + " Y:" + getPositionY();
    }
   
}
