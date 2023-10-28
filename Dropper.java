import java.util.Timer;
import java.util.TimerTask;

public class Dropper {
    private int dropRate; // The number of ore objects to be dropped per second
    private int totalOreDropped = 0; //The number of ore objects this dropper has created.
    private Timer timer;
    public String dropperName;
    private DropperListener listener;
    protected CircularOreArray<Ore> sharedOreArray;

    public Dropper(int dropRate, String dropperName, CircularOreArray<Ore> sharedOreArray) {
        this.totalOreDropped = totalOreDropped;
        this.dropRate = dropRate;
        this.timer = new Timer();
        this.dropperName = dropperName;
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
                if (sharedOreArray.size() < 250 ) {
                    Ore ore = createOre();
                    sharedOreArray.add(ore);
                    totalOreDropped++;
                    System.out.println(dropperName + " is Mining a new ore! (Ore# : " + totalOreDropped + ")");
                } else {
                    System.out.println("Ore Limit Reached! Production Paused.");
                }               
                    
            }
        }, 0, dropRate); // Schedule the task to run every 1000 milliseconds (1 second)
    }

    //Havent done anything with this yet.
    public void setListener(DropperListener listener) {
        this.listener = listener;
    }
    
    //creates an ore object
    protected Ore createOre() {
        return new Ore(); 
    }

    //Toggles the dropper off.
    public void stopDropping() {
        if (timer != null) {
            timer.cancel();
            timer = null;
            System.out.println(dropperName + " ore production halted.");
        } else {
            System.out.println(dropperName + " is not dropping ore.");
        }
    }

    //returns the total number of ore that the dropper has produced.
    public int getTotalOreDropped() {
        return totalOreDropped;
    }

}
