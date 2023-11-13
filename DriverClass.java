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
        
            
        Player player = new Player(BigInteger.valueOf(0), 0, 0);
        Dropper[] droppers = new Dropper[3];
        Upgrader[] upgrader = new Upgrader[3];
        TheGameQueue theQueue = new TheGameQueue();
        Furnace furnace = new BasicFurnace(0, 0, null, 0, null, null, player);
        upgrader[0] = new BasicUpgrader(null);
        upgrader[1] = new TheUpgrader(null);
        NumberFormat scientificFormat = new DecimalFormat("0.0E0");


        droppers[0] = new IronDropper();
        droppers[1] = new RubyDropper();
        droppers[2] = new GoldDropper();

        System.out.println(player.getWallet());

        for (Dropper dropper : droppers) {
            dropper.startDropping();
        }

        try {
            Thread.sleep(5000); // Sleep for 10 seconds to allow ore generation
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (Dropper dropper : droppers) {
            dropper.stopDropping();
        }

        theQueue.addItem(upgrader[0], 0);
        theQueue.addItem(upgrader[1], 1);
        theQueue.addItem(furnace, 2);

        theQueue.tycoonTick();

        
         for (Dropper dropper : droppers) {
            System.out.println(dropper.toString());
        }

        System.out.println("\n" + player.getWallet());
        





        //Maybe make a for each method that adds each upgrader to the upgrade queue?

    

    }
}
