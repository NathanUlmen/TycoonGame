import java.math.BigInteger;

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


        // player.getInventory().printInventory();

        // player.getInventory().addItem(generator.rewardItem(ItemGenerator.RewardType.STANDARD_CHEST), 1);

        // player.getInventory().printInventory();

        // System.out.println(new Conveyor().toString());

        // for (int i = 0; i < 100; i++) {
        //     System.out.println(generator.rewardItem(ItemGenerator.RewardType.STANDARD_CHEST).toString());
        // } 
        
        
    }
}
