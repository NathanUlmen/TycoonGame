import java.util.Timer;
import java.util.TimerTask;

public class Dropper {
    private int dropRate; // The number of ore objects to be dropped per second
    private int totalOreDropped = 0; //The number of ore objects this dropper has created.
    private Timer timer;
    private String dropperName;
    private DropperListener listener;

    public Dropper(int dropRate) {
        this.totalOreDropped = totalOreDropped;
        this.dropRate = dropRate;
        this.timer = new Timer();
        this.dropperName = dropperName;
    }

    public void startDropping() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                    Ore ore = createOre();
                    totalOreDropped++;
                    System.out.println("Mining a new ore! (Ore# : " + totalOreDropped + ")");
            }
        }, 0, dropRate); // Schedule the task to run every 1000 milliseconds (1 second)
    }

    public void setListener(DropperListener listener) {
        this.listener = listener;
    }
    
    protected Ore createOre() {
        return new Ore(); // Default ore creation
    }

    public void stopDropping() {
        timer.cancel();
        timer.purge();
        System.out.println("Ore production halted.");
    }

    public void getTotalOreDropped() {
        System.out.println(this.dropperName + "Has dropped " + totalOreDropped + "ore");
    }

    // public static void main(String[] args) {
    //     // Example usage of the Dropper class
    //     Dropper dropper = new Dropper(5); // Set the drop rate to 5 ores per second
    //     dropper.startDropping();
    // }
}
