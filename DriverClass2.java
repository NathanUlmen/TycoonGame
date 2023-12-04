import java.text.DecimalFormat;
import java.text.NumberFormat;
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
        Conveyor[] conveyors = new Conveyor[2900];

        //Test Bed:

        //Test 1(A line of upgraders leading into one furnace):
        //Initialize and place Droppers
        droppers[0] = new IronDropper();
        droppers[1] = new GoldDropper();
        droppers[2] = new RubyDropper();
        
        droppers[0].placeItem(1, 5, Direction.UPWARDS);
        // droppers[1].placeItem(2, 5, Direction.UPWARDS);
        // droppers[2].placeItem(3, 5, Direction.UPWARDS);


        //Initialize and place Processing Items
        for (int i = 0; i < basicUpgraders.length; i++) {
            basicUpgraders[i] = new BasicUpgrader();
            basicUpgraders[i].placeItem(basicUpgraders.length-i, 6, Direction.RIGHT);
            theQueue.addItem(basicUpgraders[i], i+1);
        }
        
        furnace.placeItem(basicUpgraders.length+1, 6, Direction.RIGHT);

        //Test2(The entire 50x50 map is filled with conveyor items, making a snaking pattern, a dropper is in the top right corner and a furnace is in the bottom right):
        // for (int i = 0; i < conveyors.length; i++) {
        //     conveyors[i] = new Conveyor();
        // }

        // droppers[0] = new IronDropper();
        // droppers[0].placeItem(0, 0, Direction.UPWARDS);

        // for (int i = 0; i < 48; i++) {
        //     conveyors[i].placeItem(0, i+1, Direction.UPWARDS);
        // }

        // furnace.placeItem(0, 49, Direction.UPWARDS);
        





        Timer timer = new Timer();

        class Task extends TimerTask {
            @Override
            public void run() {
                    tycoonBuilder.setAllPlacedItems();
                    tycoonBuilder.identifySystems();
                    tycoonBuilder.createSystems();
                    tycoonBuilder.tycoonTick();
                    droppers[0].dropOre();


                System.out.println("Ore dropped: " + droppers[0].getTotalOreDropped());
                System.out.println("You have made " + scientificFormat.format(player.getWallet())
                 + " or " +player.getWallet() + "\nCurrentSpcialPoints: " + player.getSpecialPoints());
                //System.out.println("Task executed at: " + System.currentTimeMillis() +"\n");
            }
        }
    

        timer.scheduleAtFixedRate(new Task() {
            
        }, 0, 1);
        
    }

    
}
