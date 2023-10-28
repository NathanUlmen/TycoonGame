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

    public void setListener(DropperListener listener) {
        this.listener = listener;
    }
    
    protected Ore createOre() {
        return new Ore(); 
    }

    public void stopDropping() {
        if (timer != null) {
            timer.cancel();
            timer = null;
            System.out.println(dropperName + " ore production halted.");
        } else {
            System.out.println(dropperName + " is not dropping ore.");
        }
    }

    public int getTotalOreDropped() {
        return totalOreDropped;
    }

}
