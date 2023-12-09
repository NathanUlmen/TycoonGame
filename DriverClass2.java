import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Timer;
import java.util.TimerTask;

public class DriverClass2 {
    static long count = 0;
    final static TycoonBuilder tycoonBuilder = TycoonBuilder.getTycoonBuilderInstance();
    final static Player player = Player.getPlayerInstance();  
    static Dropper[] droppers = new Dropper[9];
    static Upgrader[] upgrader = new Upgrader[4];
    static TheGameQueue theQueue = new TheGameQueue();
    static Furnace furnace = new BasicFurnace();
    static NumberFormat scientificFormat = new DecimalFormat("0.0E0");
    static Upgrader[] genericUpgrader = new Upgrader[40];
    static Furnace furnace2 = new BasicFurnace();
    static TheUpgrader theUpgrader = new TheUpgrader();
    static Conveyor[] conveyors = new Conveyor[2900];
    static Upgrader[] upgraderz = new Upgrader[2500];
    static Ore ore = new Ore();

    public static void main(String[] args) {
        // long count = 0;
        // TycoonBuilder tycoonBuilder = new TycoonBuilder();
        // Player player = Player.getPlayerInstance();  
        // Dropper[] droppers = new Dropper[9];
        // Upgrader[] upgrader = new Upgrader[4];
        // TheGameQueue theQueue = new TheGameQueue();
        // Furnace furnace = new BasicFurnace();
        // NumberFormat scientificFormat = new DecimalFormat("0.0E0");
        // Upgrader[] genericUpgrader = new Upgrader[40];
        // Furnace furnace2 = new BasicFurnace();
        // TheUpgrader theUpgrader = new TheUpgrader();
        // Conveyor[] conveyors = new Conveyor[2900];
        // Upgrader[] upgraderz = new Upgrader[2500];


        //Test Bed:

        //Test 1(A line of upgraders leading into one furnace):
        //Initialize and place Droppers
        // droppers[0] = new IronDropper();
        // droppers[1] = new GoldDropper();
        // droppers[2] = new RubyDropper();
        
        // droppers[0].placeItem(1, 5, Direction.UPWARDS);
        // droppers[1].placeItem(2, 5, Direction.UPWARDS);
        // droppers[2].placeItem(3, 5, Direction.UPWARDS);


        // Initialize and place Processing Items
        // for (int i = 0; i < genericUpgrader.length; i++) {
        //     if (i == 20) {
        //         genericUpgrader[i] = new ResetterUpgrader();
        //     } else if(i == 15){
        //         genericUpgrader[i] = new TheUpgrader();
        //     } else {
        //         genericUpgrader[i] = new BasicUpgrader();
        //     }
            
        //     genericUpgrader[i].placeItem(genericUpgrader.length-i, 6, Direction.RIGHT);
        // }
        
        // furnace.placeItem(genericUpgrader.length+1, 6, Direction.RIGHT);

        


        

        //Test2(A 2500 item long line of Basic Upgraders with a dropper at the beginning and a furnace at the end:
        droppers[0] = new IronDropper();
        droppers[0].placeItem(0, 2, Direction.RIGHT);
        for (int i = 0; i < upgraderz.length; i++) {
            upgraderz[i] = new BasicUpgrader();
            upgraderz[i].placeItem(1+i, 2, Direction.RIGHT);
            conveyors[i] = new Conveyor();
            conveyors[i].placeItem(1+i, 10, Direction.RIGHT);
            if (i % 5 == 0) {
                conveyors[i].setStoredOre(new BasicUpgrader(ore));
            }
            
        }
        furnace.placeItem(upgraderz.length, 2, Direction.RIGHT);

    
    


        // FixedTest(300000);
        InfinteTimerTest(1);


    }

    private static void FixedTest(int numberOfTicks) {
        long start, end;
        start = System.currentTimeMillis();
        while(count < numberOfTicks) {
            // tycoonBuilder.setAllPlacedItems();
            // tycoonBuilder.identifySystems();
            // tycoonBuilder.createSystems();
            tycoonBuilder.tycoonTick();
            count++;
        }
        end = System.currentTimeMillis();
        System.out.println(end-start + "Milliseconds");
        System.out.println((end-start)/1000 + " Seconds");
        System.out.println("You have made " + scientificFormat.format(player.getWallet())
                  + " or " +player.getWallet() + "\nCurrentSpcialPoints: " + player.getSpecialPoints());
    }

    private static void InfinteTimerTest(int period) {
        Timer timer = new Timer();

        class Task extends TimerTask {
            
            @Override
            public void run() {
                tycoonBuilder.setAllPlacedItems();
                tycoonBuilder.identifySystems();
                tycoonBuilder.createSystems();
                tycoonBuilder.tycoonTick();
                player.incrementTicks();
                // System.out.println("Ore dropped: " + droppers[0].getTotalOreDropped());
                // System.out.println("You have made " + scientificFormat.format(player.getWallet())
                //   + " or " +player.getWallet() + "\nCurrentSpcialPoints: " + player.getSpecialPoints());
                //System.out.println("Task executed at: " + System.currentTimeMillis() +"\n");
                System.out.println("Number of Ticks: " + player.getNumberOfTicks());
            }
        }
    

        timer.scheduleAtFixedRate(new Task() {
            
        }, 0, period);
    }

    
    
    
}
