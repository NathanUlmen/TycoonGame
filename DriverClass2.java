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
        Upgrader[] genericUpgrader = new Upgrader[40];
        Furnace furnace2 = new BasicFurnace();
        TheUpgrader theUpgrader = new TheUpgrader();
        Conveyor[] conveyors = new Conveyor[2900];
        Upgrader[] upgraderz = new Upgrader[2500];


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
        for (int i = 0; i < genericUpgrader.length; i++) {
            if (i == 20) {
                genericUpgrader[i] = new ResetterUpgrader();
            } else if(i == 15){
                genericUpgrader[i] = new TheUpgrader();
            } else {
                genericUpgrader[i] = new BasicUpgrader();
            }
            
            genericUpgrader[i].placeItem(genericUpgrader.length-i, 6, Direction.RIGHT);
        }
        
        furnace.placeItem(genericUpgrader.length+1, 6, Direction.RIGHT);

        


        

        //Test2(A 2500 item long line of Basic Upgraders with a dropper at the beginning and a furnace at the end:
        // droppers[0] = new IronDropper();
        // droppers[0].placeItem(0, 2, Direction.RIGHT);
        // for (int i = 0; i < upgraderz.length; i++) {
        //     upgraderz[i] = new BasicUpgrader();
        //     upgraderz[i].placeItem(1+i, 2, Direction.RIGHT);
        // }

        // furnace.placeItem(upgraderz.length, 2, Direction.RIGHT);
        
    





        Timer timer = new Timer();

        class Task extends TimerTask {
            @Override
            public void run() {
                tycoonBuilder.setAllPlacedItems();
                tycoonBuilder.identifySystems();
                tycoonBuilder.createSystems();
                tycoonBuilder.tycoonTick();
                droppers[0].dropOre();


                // System.out.println("Ore dropped: " + droppers[0].getTotalOreDropped());
                 System.out.println("You have made " + scientificFormat.format(player.getWallet())
                  + " or " +player.getWallet() + "\nCurrentSpcialPoints: " + player.getSpecialPoints());
                //System.out.println("Task executed at: " + System.currentTimeMillis() +"\n");
            }
        }
    

        timer.scheduleAtFixedRate(new Task() {
            
        }, 0, 1);
        
    }

    
}
