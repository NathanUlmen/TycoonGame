public class DriverClass2 {
    final static Player player = Player.getPlayerInstance();  

    static Dropper[] droppers = new Dropper[10];
    static Conveyor[] conveyors = new Conveyor[8000];
    static Upgrader[] upgraders = new Upgrader[2500];
    static Furnace[] furnaces = new Furnace[20];

    public static void main(String[] args) {
        for (int i = 0; i < droppers.length; i++) {
            
            if (i % 3 == 0) {
                droppers[i] = new RubyDropper();
                upgraders[i] = new TheUpgrader();
            } else {
                upgraders[i] = new BasicUpgrader();
                droppers[i] = new IronDropper();
            }
            player.inventory.addItem(droppers[i], 1);
            player.inventory.addItem(upgraders[i], 2);
        }

        // player.inventory.printInventoryAsList();
        // player.inventory.printInventory();

        player.inventory.sortInventory();

        // player.inventory.printInventoryAsList();
        player.inventory.printInventory();
        player.inventory.removeItem(droppers[1]); 
        player.inventory.printInventory();
        // String filePath = "inventory_output.txt";

        // player.inventory.writeInventoryToFile(filePath);
    }
}
