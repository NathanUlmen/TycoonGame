import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;



public class DriverClass {
    public static void main(String[] args) {
        long tracker = System.currentTimeMillis();
        int ticks = 0;
        Player player = new Player(BigInteger.valueOf(0), ticks, ticks);
        TheMap theMap = new TheMap();    
        Dropper[] droppers = new Dropper[3];
        Upgrader[] upgrader = new Upgrader[4];
        TheGameQueue theQueue = new TheGameQueue();
        Furnace furnace = new BasicFurnace(player);
        upgrader[0] = new BasicUpgrader();
        upgrader[1] = new TheUpgrader();
        upgrader[2] = new BasicUpgrader();
        upgrader[3] = new BasicUpgrader();
        NumberFormat scientificFormat = new DecimalFormat("0.0E0");
        BasicUpgrader[] basicUpgraders = new BasicUpgrader[900];
        

        


        
        

        droppers[0] = new IronDropper();
        droppers[1] = new RubyDropper();
        droppers[2] = new GoldDropper();

        // Ore goldOre = new GoldOre();
        // Ore goldOre2 = new GoldOre();
        // Ore goldOre3 = new GoldOre();

    
        for (int i = 0; i < droppers.length; i++) {
            droppers[i].setDirection(Direction.UPWARDS);
            theQueue.addItem(droppers[i], 4+i);
        }
        theQueue.addItem(droppers[0], 5);
        theQueue.addItem(droppers[1], 6);
        theQueue.addItem(droppers[2], 7);
        
        droppers[0].placeItem(1, 4);
        droppers[1].placeItem(2, 4);
        droppers[2].placeItem(3, 4);

        
        theQueue.addItem(upgrader[0], 0);
        theQueue.addItem(upgrader[1], 1);
        theQueue.addItem(upgrader[2], 2);
        theQueue.addItem(upgrader[3], 3);
        theQueue.addItem(furnace, 4);

        upgrader[0].placeItem(1, 5);
        upgrader[1].placeItem(2, 5);
        upgrader[2].placeItem(3, 5);
        upgrader[3].placeItem(4, 5);
        furnace.placeItem(5, 5);
        System.out.println(droppers[0].getItemInFront().getItemName());

        for (int i = 0; i < upgrader.length; i++) {
            upgrader[i].setDirection(Direction.RIGHT);
        }
        

        Timer timer = new Timer();

        class Task extends TimerTask {
            @Override
            public void run() {
                theQueue.tycoonTick();
                System.out.println("You have made " + player.getWallet());
                System.out.println("Task executed at: " + System.currentTimeMillis() +"\n");
            }
        }
    

        timer.scheduleAtFixedRate(new Task() {
            
        }, 0, 1000);


        
        // for (Dropper dropper : droppers) {
        //     dropper.startDropping();
        // }

        // try {
        //     Thread.sleep(5000); // Sleep for 10 seconds to allow ore generation
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }

        // for (Dropper dropper : droppers) {
        //     dropper.stopDropping();
        // }

        
        //  for (Dropper dropper : droppers) {
        //     System.out.println(dropper.toString());
        // }

        



        // upgrader[1].setPreviousItem(null);
        // upgrader[2].setPreviousItem(upgrader[3]);
        // upgrader[0].setPreviousItem(upgrader[2]);
        // upgrader[3].setPreviousItem(upgrader[0]);
        // upgrader[2].setCurrentOre(goldOre3);
        
        // for (int i = 0; i < 900000; i ++) {
        //     theQueue.tycoonTick();
        // }
        
        // upgrader[0].setPreviousItem(null);
        // upgrader[1].setPreviousItem(upgrader[0]);
        // upgrader[2].setPreviousItem(upgrader[1]);
        // furnace.setPreviousItem(upgrader[2]);

        // for (int i = 0; i < 100; i ++) {
        //     theQueue.tycoonTick();
        // }
        // System.out.println("\n" + player.getWallet());
        // theQueue.addItem(furnace, 0);

        // for (int i = 0; i < basicUpgraders.length; i++) {
        //     basicUpgraders[i] = new BasicUpgrader();

        //     // Add each BasicUpgrader to theQueue
        //     theQueue.addItem(basicUpgraders[i], i + 1); // Start from index 1 to avoid overwriting furnace

        //     // Set the previous item for each BasicUpgrader
        //     if (i > 0) {
        //         basicUpgraders[i].setPreviousItem(basicUpgraders[i - 1]);
        //     }

        //     // Set a GoldOre object in every other BasicUpgrader
            
        //         basicUpgraders[i].setCurrentOre(new GoldOre());
            
        // }
        // basicUpgraders[1].setPreviousItem(basicUpgraders[899]);

        // long tracker3 = System.currentTimeMillis();
        // for (int i = 0; i <1000; i++) {
        //     theQueue.tycoonTick();
        // }

        // furnace.setPreviousItem(basicUpgraders[899]);

        // for (int i = 0; i <100; i++) {
        //     theQueue.tycoonTick();
        // }

        // System.out.println("\n" + player.getWallet());
        // long tracker4 = System.currentTimeMillis();
        // tracker3 = tracker4 - tracker3;
        // System.out.println("Time in Milliseconds: " + tracker3);
        // System.out.println();
        


        //Maybe make a for each method that adds each upgrader to the upgrade queue?

        long tracker2 = System.currentTimeMillis();
        tracker = tracker2 - tracker;
        System.out.println("Time in Milliseconds: " + tracker);
    }
}
