import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class DriverClass2 {
    public static void main(String[] args) {
        TycoonBuilder tycoonBuilder = new TycoonBuilder();
        Player player = new Player(BigInteger.valueOf(0), 0, 0);   
        Dropper[] droppers = new Dropper[9];
        Upgrader[] upgrader = new Upgrader[4];
        TheGameQueue theQueue = new TheGameQueue();
        Furnace furnace = new BasicFurnace(player);
        upgrader[0] = new BasicUpgrader();
        upgrader[1] = new TheUpgrader();
        upgrader[2] = new BasicUpgrader();
        upgrader[3] = new BasicUpgrader();
        NumberFormat scientificFormat = new DecimalFormat("0.0E0");
        BasicUpgrader[] basicUpgraders = new BasicUpgrader[900];
        Furnace furnace2 = new BasicFurnace(player);
        TheUpgrader theUpgrader = new TheUpgrader();

        basicUpgraders[0] = new BasicUpgrader();

        droppers[0] = new IronDropper();

        droppers[0].placeItem(5, 5);
        droppers[0].setDirection(Direction.UPWARDS);
        upgrader[0].placeItem(5, 6);
        upgrader[0].setDirection(Direction.RIGHT);
        basicUpgraders[0].placeItem(6, 6);
        basicUpgraders[0].setDirection(Direction.RIGHT);
        upgrader[1].placeItem(7, 6);
        upgrader[1].setDirection(Direction.RIGHT);
        theUpgrader.placeItem(8, 6);
        theUpgrader.setDirection(Direction.RIGHT);
        furnace2.placeItem(9, 6);
        furnace2.setDirection(Direction.RIGHT);


        basicUpgraders[0].setItemInFront();
        droppers[0].setItemInFront();
        upgrader[1].setItemInFront();
        upgrader[0].setItemInFront();
        furnace2.setItemInFront();
        theUpgrader.setItemInFront();

        System.out.println(droppers[0].getItemInFront().getItemName() + "\n" + upgrader[0].getItemInFront().getItemName());

        droppers[0].oreRealm.fillOreQueue();

        theQueue.addItem(droppers[0], 5);
        theQueue.addItem(furnace2, 0);
        theQueue.addItem(theUpgrader, 1);
        theQueue.addItem(basicUpgraders[0], 3);
        theQueue.addItem(upgrader[0], 4);
        theQueue.addItem(upgrader[1], 2);

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
                droppers[0].dropOre();
                System.out.println("You have made " + scientificFormat.format(player.getWallet())
                 + " or " +player.getWallet());
                System.out.println("Task executed at: " + System.currentTimeMillis() +"\n");
            }
        }
    

        timer.scheduleAtFixedRate(new Task() {
            
        }, 0, 750);
        
    }
}
