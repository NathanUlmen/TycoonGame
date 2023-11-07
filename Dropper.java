import java.util.Timer;
import java.util.TimerTask;

public abstract class Dropper extends Item{
    private int dropRate; // The number of ore objects to be dropped per second
    private int totalOreDropped = 0; //The number of ore objects this dropper has created.
    private Timer timer;
    // public String dropperName;
    protected static CircularOreArray<Ore> sharedOreArray;

    public Dropper(int dropRate, CircularOreArray<Ore> sharedOreArray, int positionX, int positionY, String itemName, int dimensionX, int dimensionY) {
        super(dimensionX, dimensionY, itemName, dimensionX, dimensionY);
        this.totalOreDropped = totalOreDropped;
        this.dropRate = dropRate;
        this.timer = new Timer();
        this.sharedOreArray = sharedOreArray;
    }

    //Toggles the dropper on, causing it to produce a new ore object and add it to the circular ore array. If the circular Ore array is full the droppers production is paused. 
    public void startDropping() {
        if (timer == null) {
            timer = new Timer();
        }
        
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (sharedOreArray.size() < 250 ) { //This should Be changed to an enum
                    oreInitializer();
                    System.out.println(getItemName() + " is Mining a new ore! (Ore# : " + totalOreDropped + ")");
                } else {
                    System.out.println("Ore Limit Reached! Production Paused.");
                }               
                    
            }
        }, 0, dropRate); // Schedule the task to run every X milliseconds (1 second = 1000)
    }

    //creates an ore object
    protected abstract Ore createOre();

    private void oreInitializer() {
        Ore ore = createOre();
        sharedOreArray.add(ore);
        ore.setPosition(getDropPoint(), getDropPoint());
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

    public int getDropPoint() {
        int dropPoint = 1;
        return dropPoint;
        
    }

    public String toString() {
        double num = 1000;
        String dropperInfo = "Dropper Name: " + getItemName() + "\nDrop Rate: " + num/dropRate + " Ores per second\nTotal Ore Dropped: " + totalOreDropped;
        return dropperInfo;
    }

}
