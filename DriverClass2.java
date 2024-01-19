import java.math.BigInteger;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class DriverClass2 {
    final static Player player = Player.getPlayerInstance();

    static Dropper[] droppers = new Dropper[10];
    static Conveyor[] conveyors = new Conveyor[8000];
    static Upgrader[] upgraders = new Upgrader[100];
    static Furnace[] furnaces = new Furnace[20];
    static ItemGenerator generator = new ItemGenerator();

    public static void main(String[] args) {
        for (int i = 0; i < droppers.length; i++) {

            if (i % 3 == 0) {
                droppers[i] = new RubyDropper();
                upgraders[i] = new TheUpgrader();
            } else {
                upgraders[i] = new BasicUpgrader();
                droppers[i] = new IronDropper();
            }
            Player.inventory.addItem(droppers[i], 1);
            Player.inventory.addItem(upgraders[i], 2);
        }

        System.out.println();
        System.out.println(player.getInventory().hasItem(new RubyDropper()));
        System.out.println(player.getInventory().hasItem(new ResetterUpgrader()));
        player.setWallet(BigInteger.valueOf(10000));
        System.out.println("Wallet Before:" + player.getWallet());
        player.getInventory().printInventory();

        player.sellItem(new BasicFurnace());

        System.out.println("Wallet After:" + player.getWallet());
        player.getInventory().printInventory();

        test();


    }

    private static void test() {
        int numOfThreads = Runtime.getRuntime().availableProcessors();
        int min, max;
        min = max = 0;

        int chunck = 100 / numOfThreads;

        for (int i = 0; i < numOfThreads; i++) {
            System.out.println("Min: " + (chunck * i) + "Max: " + (chunck * +(i + 1)));
        }
    }
}
