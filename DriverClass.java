import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Timer;
import java.util.TimerTask;

public class DriverClass {
    static final int hundred = 100;
    static final int ten = 10;
    static final int thousand = 1000;
    static final int twentyFiveHundred = 2500;
    static final int twentyThousand = 20000;
    static long count = 0;
    final static TycoonBuilder tycoonBuilder = TycoonBuilder.getTycoonBuilderInstance();
    final static Player player = Player.getPlayerInstance();
    static Dropper[] droppers = new Dropper[ten];
    static Conveyor[] conveyors = new Conveyor[8000];
    static Upgrader[] upgraders = new Upgrader[2500];
    static Furnace[] furnaces = new Furnace[2500];
    static NumberFormat scientificFormat = new DecimalFormat("0.0E0");
    static OreRealm oreRealm = OreRealm.getOreRealmInstance();

    static Ore ore = new Ore();

    public static void main(String[] args) {
        //Test Bed:

        //Test 1(A line of upgraders leading into one furnace):
        //Initialize and place Droppers
        // droppers[0] = new IronDropper();
        // droppers[1] = new GoldDropper();
        // droppers[2] = new RubyDropper();

        // droppers[0].placeItem(1, 5, Direction.UPWARDS);
        // droppers[1].placeItem(2, 5, Direction.UPWARDS);
        // droppers[2].placeItem(3, 5, Direction.UPWARDS);


        // // Initialize and place Processing Items
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
        for (int i = 0; i < upgraders.length - 1; i++) {
            upgraders[i] = new BasicUpgrader();
            upgraders[i].placeItem(1 + i, 2, Direction.RIGHT);
            conveyors[i] = new Conveyor();
            conveyors[i].placeItem(1 + i, 10, Direction.RIGHT);
            // if (i % 5 == 0) {
            //     // conveyors[i].setOre(ore);
            // }
            // furnaces[i] = new BasicFurnace();
            // furnaces[i].placeItem(4+i, i, Direction.RIGHT);
        }
        // furnaces[0].removeItem();
        furnaces[0] = new BasicFurnace();
        furnaces[0].placeItem(upgraders.length, 2, Direction.RIGHT);

        tycoonBuilder.updateTycoon();
        tycoonBuilder.tycoonTick();
        FixedTest(300000);
//         InfinteTimerTest(1);
        // timedTest(10);

    }

    private static void FixedTest(int numberOfTicks) {
        long start, end;
        start = System.currentTimeMillis();
        // tycoonBuilder.updateTycoon();
        for (int i = 0; i < numberOfTicks; i++) {
            tycoonBuilder.tycoonTick();
//             tycoonBuilder.fireAllSystems();
            // System.out.println("Number of active ore: " + oreRealm.getNumberOfOreNotInStack());
            // System.out.println("Number of Ore Dropped: " + droppers[0].getTotalOreDropped());
        }

        // System.out.println(tycoonBuilder.getTycoonSystems());
        // System.out.println(tycoonBuilder.getAllPlacedItems());

        end = System.currentTimeMillis();
        NumberFormat nf = NumberFormat.getNumberInstance();
        String formattedMilliseconds = nf.format(end - start);
        String formattedNumberOfTicks = nf.format(numberOfTicks);

        String infoString = "\nIt took ";
        infoString += formattedMilliseconds + " Milliseconds";
        infoString += " or " + (end - start) / 1000 + " Seconds";
        infoString += " to run tycoonTick " + formattedNumberOfTicks + " times.";
        System.out.println(infoString);
        System.out.println("You have made " + scientificFormat.format(player.getWallet())
                + " or " + player.getWallet() + "\nCurrent Special Points: " + player.getSpecialPoints());
    }

    private static void InfinteTimerTest(int period) {
        Timer timer = new Timer();

        class Task extends TimerTask {

            @Override
            public void run() {
                // tycoonBuilder.setAllPlacedItems();
                // tycoonBuilder.identifySystems();
                // tycoonBuilder.createSystems();
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

    private static void timedTest(long timeToRun) {
        long start, end;
        int ticks = 0;
        start = System.currentTimeMillis();
        end = start + (timeToRun * 1000);
        tycoonBuilder.updateTycoon();
        while (System.currentTimeMillis() < end) {
            tycoonBuilder.fireAllSystems();
            ticks++;
            end = System.currentTimeMillis();
        }
        NumberFormat nf = NumberFormat.getNumberInstance();
        String formattedMilliseconds = nf.format(end - start);
        String formattedNumberOfTicks = nf.format(ticks);

        String infoString = "Ran " + ticks + " ticks in " + timeToRun + " seconds";
        System.out.println(infoString);
    }

    private static void simpleSetup() {

    }
}
