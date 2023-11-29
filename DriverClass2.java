import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class DriverClass2 {
    public static void main(String[] args) {
        TycoonBuilder tycoonBuilder = new TycoonBuilder();
        Player player = Player.getPlayerInstance();  
        Dropper[] droppers = new Dropper[9];
        Upgrader[] upgrader = new Upgrader[4];
        TheGameQueue theQueue = new TheGameQueue();
        Furnace furnace = new BasicFurnace();
        upgrader[0] = new BasicUpgrader();
        upgrader[1] = new TheUpgrader();
        upgrader[2] = new BasicUpgrader();
        upgrader[3] = new BasicUpgrader();
        NumberFormat scientificFormat = new DecimalFormat("0.0E0");
        BasicUpgrader[] basicUpgraders = new BasicUpgrader[40];
        Furnace furnace2 = new BasicFurnace();
        TheUpgrader theUpgrader = new TheUpgrader();

        //Test Bed:

        
        //Initialize and place Droppers
        
        droppers[0] = new IronDropper();
        droppers[1] = new GoldDropper();
        droppers[2] = new RubyDropper();

        droppers[0].placeItem(1, 5, Direction.UPWARDS);
        // droppers[1].placeItem(2, 5, Direction.UPWARDS);
        // droppers[2].placeItem(3, 5, Direction.UPWARDS);


        //Initialized and place ProcessingItems
        for (int i = 0; i < basicUpgraders.length; i++) {
            basicUpgraders[i] = new BasicUpgrader();
            basicUpgraders[i].placeItem(basicUpgraders.length-i, 6, Direction.RIGHT);
            theQueue.addItem(basicUpgraders[i], i+1);
        }
        
        furnace.placeItem(basicUpgraders.length+1, 6, Direction.RIGHT);
        theQueue.addItem(furnace, 0);
        // theQueue.addItem(droppers[2], basicUpgraders.length+1);
        // theQueue.addItem(droppers[1], basicUpgraders.length+2);
        theQueue.addItem(droppers[0], basicUpgraders.length+3);

        

        System.out.println(theQueue.toString());


        theQueue.connectAll();

        // tycoonBuilder.setAllPlacedItems();

        // tycoonBuilder.identifySystems();


        

        // System.out.println(tycoonBuilder.identifySystems().getItemName());
        // tycoonBuilder.identifySystems().getItemName();

        

        // droppers[0] = new IronDropper();
        // droppers[1] = new RubyDropper();
        // droppers[2] = new GoldDropper();

        // for (int i = 0; i <= 46; i++) {
        //     basicUpgraders[i] = new BasicUpgrader();
        //     basicUpgraders[i].placeItem(0+i, 10);
        //     System.out.println("I is: " + i);
        //     basicUpgraders[i].setDirection(Direction.RIGHT);
        // }

        // for (int i = 3; i < droppers.length ; i++) {
        //     droppers[i] = new GoldDropper();
        //     droppers[i].placeItem(0+i,  9);
        //     droppers[i].setDirection(Direction.UPWARDS);
        //     theQueue.addItem(droppers[i], 54+i);
        //     System.out.println(droppers[i].getItemInFront().getItemName() + i);
        // }

        // furnace2.placeItem(46, 10);
        // theQueue.addItem(furnace2, 140);
        // furnace.setDirection(Direction.UPWARDS);

        //List<List<ProcessingItem>> tycoonSystems = tycoonBuilder.buildTycoons();

        // droppers[0].setItemInFront();
        // droppers[1].setItemInFront();
        // droppers[2].setItemInFront();
        Timer timer = new Timer();

        class Task extends TimerTask {
            @Override
            public void run() {
                //tycoonBuilder.fireTycoons(tycoonSystems);
                theQueue.tycoonTick();
                System.out.println("Ore dropped: " + droppers[0].getTotalOreDropped());
                System.out.println("You have made " + scientificFormat.format(player.getWallet())
                 + " or " +player.getWallet() + "\nCurrentSpcialPoints: " + player.getSpecialPoints());
                System.out.println("Task executed at: " + System.currentTimeMillis() +"\n");
            }
        }
    

        timer.scheduleAtFixedRate(new Task() {
            
        }, 0, 100);
        
    }
}
