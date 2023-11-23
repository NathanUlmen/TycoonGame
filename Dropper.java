//The Dropper class creates Ore objects

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.TimerTask;

public abstract class Dropper extends Item implements OreDecorator{
    private Item item;
    protected Ore ore;
    protected OreDecorator internal;
    private int dropRate; // The number of ore objects to be dropped per second
    private int totalOreDropped; //The number of ore objects this dropper has created.
    protected static OreRealm oreRealm = new OreRealm();
    protected boolean canDrop;
    
    

    public Dropper(int dropRate, int positionX, int positionY, String itemName, int dimensionX, int dimensionY, Direction direction) {
        super(positionX, positionY, itemName, dimensionX, dimensionY, direction);
        this.totalOreDropped = totalOreDropped;
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
            System.out.println("Dropped!");
        }
    }

    // public void setItemInFront() {
    //     Item temp = getItemInFront();
    //     if (temp instanceof ProcessingItem) {
    //         this.itemInFront = (ProcessingItem) temp;
    //         canDrop = true;
    //     } else {
    //         itemInFront = null;
    //         canDrop = false;
    //     }
    // }

    @Override
    public Ore prepare() {
        Ore result = (ore != null) ? ore : internal.prepare();
        result.applyBaseStats(baseOreValue(), startingTemp(), setName());
        return result;
    }

    //returns the total number of ore that the dropper has produced.
    public int getTotalOreDropped() {
        return totalOreDropped;
    }

    //creates an ore object
    protected abstract OreDecorator createOre();

     protected abstract BigDecimal baseOreValue();

    protected abstract String setName();

    protected abstract int startingTemp();

    public String toString() {
        double num = 1000;
        String dropperInfo = "Dropper Name: " + getItemName() + "\nDrop Rate: " + num/dropRate + " Ores per second\nTotal Ore Dropped: " + totalOreDropped;
        return dropperInfo;
    }

    

    

    // public void dropOre() {
    //     Item itemInFront = getItemInFront();
    //     if (itemInFront instanceof ProcessingItem) {
    //         itemInFront = getItemInFront();
    
    //         if (itemInFront instanceof ProcessingItem) {
    //             ProcessingItem processingItem = (ProcessingItem) itemInFront;
    //             Ore ore = createOre();
    //             processingItem.setCurrentOre(ore);
    //             totalOreDropped++;
    //         }
    //     }

    
    // private void setCurrentOre(Ore ore) {
    //     Ore[] temp = ((ProcessingItem) item).getStoredOreArray();
    
    //     // Find the first empty slot in the array and add the ore
    //     for (int i = 0; i < temp.length; i++) {
    //         if (temp[i] == null) {
    //             temp[i] = ore;
    //             break; // Break out of the loop after adding one ore
    //         }
    //     }

   
}
