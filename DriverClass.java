import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DriverClass {
    public static void main(String[] args) {
        long tracker = System.currentTimeMillis();
        
            
        Player player = new Player(BigInteger.valueOf(0), 0, 0);
        Dropper[] droppers = new Dropper[3];
        Upgrader[] upgrader = new Upgrader[4];
        TheGameQueue theQueue = new TheGameQueue();
        Furnace furnace = new BasicFurnace(0, 0, null, 0, null, null, player);
        upgrader[0] = new BasicUpgrader();
        upgrader[1] = new TheUpgrader();
        upgrader[2] = new BasicUpgrader();
        upgrader[3] = new BasicUpgrader();
        NumberFormat scientificFormat = new DecimalFormat("0.0E0");


        droppers[0] = new IronDropper();
        droppers[1] = new RubyDropper();
        droppers[2] = new GoldDropper();

        Ore goldOre = new GoldOre();
        Ore goldOre2 = new GoldOre();
        Ore goldOre3 = new GoldOre();


        //Currently wont upgrade the ore stored in upgrader[0] due to the way I made the logic, upgrader[0] never has the ore in this scenario. 
        //It goes like this: Furnace finds nothing, upgrader[1] finds gold ore in upgrader[0] and pullsAndProcess() it. upgrader[0] finds no linked item.
        // furnace finds gold ore in upgrader[1] and pulls and processes it. No ore is left in the system.
        theQueue.addItem(upgrader[0], 0);
        theQueue.addItem(upgrader[1], 1);
        theQueue.addItem(upgrader[2], 2);
        theQueue.addItem(upgrader[3], 3);
        theQueue.addItem(furnace, 4);

        furnace.setPreviousItem(upgrader[1]);
        upgrader[1].setPreviousItem(upgrader[0]);

        upgrader[0].setCurrentOre(goldOre2);

        theQueue.tycoonTick();


        
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

        // theQueue.addItem(upgrader[0], 0);
        // theQueue.addItem(upgrader[1], 1);
        // theQueue.addItem(furnace, 2);

        // theQueue.tycoonTick();

        
        //  for (Dropper dropper : droppers) {
        //     System.out.println(dropper.toString());
        // }

        System.out.println("\n" + player.getWallet());
        upgrader[1].setPreviousItem(null);
        upgrader[2].setPreviousItem(upgrader[3]);
        upgrader[0].setPreviousItem(upgrader[2]);
        upgrader[3].setPreviousItem(upgrader[0]);
        upgrader[2].setCurrentOre(goldOre3);
        
        for (int i = 0; i < 900000; i ++) {
            theQueue.tycoonTick();
        }
        
        upgrader[0].setPreviousItem(null);
        upgrader[1].setPreviousItem(upgrader[0]);
        upgrader[2].setPreviousItem(upgrader[1]);
        furnace.setPreviousItem(upgrader[2]);

        for (int i = 0; i < 100; i ++) {
            theQueue.tycoonTick();
        }
        System.out.println("\n" + player.getWallet());

        




        //Maybe make a for each method that adds each upgrader to the upgrade queue?

        long tracker2 = System.currentTimeMillis();
        tracker = tracker2 - tracker;
        System.out.println("Time in Milliseconds: " + tracker);
    }
}
