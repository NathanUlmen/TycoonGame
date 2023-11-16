//The Dropper class creates Ore objects

import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

public abstract class Dropper extends Item{
    ProcessingItem itemToDropInto;
    Item item;
    private int dropRate; // The number of ore objects to be dropped per second
    private int totalOreDropped; //The number of ore objects this dropper has created.
    private Timer timer;
    public String dropperName;
    // protected static CircularOreArray<Ore> sharedOreArray;
    // private LinkedList<Ore> oreQueue = new LinkedList<>();
    protected static LinkedList<Ore> oreQueue = new LinkedList<Ore>();

    public Dropper(int dropRate, LinkedList<Ore> oreQueue, int positionX, int positionY, String itemName, int dimensionX, int dimensionY, Direction UPWARDS) {
        super(positionX, positionY, itemName, dimensionX, dimensionY, UPWARDS);
        this.totalOreDropped = totalOreDropped;
        this.dropRate = dropRate;
        this.timer = new Timer();
        this.oreQueue = oreQueue;
    }

    //Toggles the dropper on, causing it to produce a new ore object and add it to the circular ore array. If the circular Ore array is full the droppers production is paused. 
    // public void startDropping() {
    //     if (timer == null) {
    //         timer = new Timer();
    //     }
        
    //     timer.scheduleAtFixedRate(new TimerTask() {
    //         @Override
    //         public void run() {
    //             if (oreQueue.size() < 250 ) { //This should Be changed to an enum
    //                 initializeOre();
    //                 System.out.println(getItemName() + " is Mining a new ore! (Ore# : " + totalOreDropped + ")");
    //             } else {
    //                 System.out.println("Ore Limit Reached! Production Paused.");
    //             }               
                    
    //         }
    //     }, 0, dropRate); // Schedule the task to run every X milliseconds (1 second = 1000)
    // }

    //creates an ore object
    protected abstract Ore createOre();

    //Creates an ore object, adds it to the oreQueue, and increments the totalOreDropped
    private void initializeOre() {
        Ore ore = createOre();
        oreQueue.add(ore);
        totalOreDropped++;
    }

    //Toggles the dropper off.
    public void stopDropping() {
        if (timer != null) {
            timer.cancel();
            timer = null;
            System.out.println(getItemName() + " ore production halted.");
        } else {
            System.out.println(getItemName() + " is not dropping ore.");
        }
    }

    //returns the total number of ore that the dropper has produced.
    public int getTotalOreDropped() {
        return totalOreDropped;
    }

    public String toString() {
        double num = 1000;
        String dropperInfo = "Dropper Name: " + getItemName() + "\nDrop Rate: " + num/dropRate + " Ores per second\nTotal Ore Dropped: " + totalOreDropped;
        return dropperInfo;
    }

    public void dropOre() {
        Item itemInFront = getItemInFront();

    if (itemInFront instanceof ProcessingItem) {
        itemInFront = getItemInFront();
    
        if (itemInFront instanceof ProcessingItem) {
            ProcessingItem processingItem = (ProcessingItem) itemInFront;
            Ore ore = createOre();
            
            // Use the setCurrentOre method to add the ore to the ProcessingItem
            processingItem.setCurrentOre(ore);
            
            // Increment the totalOreDropped count
            // System.out.println("New ore Dropped!");
            totalOreDropped++;
        }
}

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

}
