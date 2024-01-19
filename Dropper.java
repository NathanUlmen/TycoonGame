//The Dropper class "pops"/pulls ore objects from the ore realm "decorates" them with their base stats and properties
//and then inserts them into the item infront of them.


import java.math.BigDecimal;
import java.math.BigInteger;

public abstract class Dropper extends Item {
    protected Ore ore;
    private int dropRate; // The number of ore objects to be dropped per second
    private int totalOreDropped; //The number of ore objects this dropper has created.
    protected boolean canDrop;
    private BigInteger itemValue = new BigInteger("0");
    private String oreName = "l", description = "";
    private BigDecimal oreValue = new BigDecimal("0");
    private int oreTemp = 0, multiOre = 0;
    private int numberOwned = 1;


    public Dropper(int dropRate, int positionX, int positionY, String itemName, int dimensionX, int dimensionY, Direction direction, ItemTier tier, BigInteger value) {
        this.dropRate = dropRate;
    }

    public Dropper(String itemName, String description, String itemValue, String oreName, String oreValue, int oreTemp, int multiOre) {
        this.itemValue = new BigInteger(itemValue);
        this.description = description;
        this.oreName = oreName;
        this.oreValue = new BigDecimal(oreValue);
        this.oreTemp = oreTemp;
        this.multiOre = multiOre;
    }

    public void dropOre() {
        if (itemInFront != null && itemInFront.isEmpty() && !oreRealm.isEmpty()) {
            Ore ore = createOre();
            ore.applyBaseStats(baseOreValue(), startingTemp(), startingMultiOre(), setName());
            itemInFront.setOre(ore);
            totalOreDropped++;
            // System.out.println("Dropped!");
        }
    }

    //returns the total number of ore that the dropper has produced.
    public int getTotalOreDropped() {
        return totalOreDropped;
    }

    //creates an ore object
    protected Ore createOre() {
        return oreRealm.giveOre();
    }

    protected abstract BigDecimal baseOreValue();

    protected abstract int startingMultiOre();

    protected abstract String setName();

    protected abstract int startingTemp();

    public String toString() {
        return "Name: " + getItemName() + "\tTotal Ore Dropped: " + totalOreDropped + "\tPosition: X:" + getPositionX() + " Y:" + getPositionY();
    }

}
