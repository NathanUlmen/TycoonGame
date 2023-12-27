public class DriverClass2 {
    final static Player player = Player.getPlayerInstance();  

    static Dropper[] droppers = new Dropper[10];
    static Conveyor[] conveyors = new Conveyor[8000];
    static Upgrader[] upgraders = new Upgrader[2500];
    static Furnace[] furnaces = new Furnace[20];

    public static void main(String[] args) {
        for (int i = 0; i < droppers.length; i++) {
            droppers[i] = new IronDropper();
            if (i % 3 == 0) {
                upgraders[i] = new TheUpgrader();
            } else {
                upgraders[i] = new BasicUpgrader();
            }
            player.inventory.addItem(droppers[i], 1);
            player.inventory.addItem(upgraders[i], 1);
        }

        player.inventory.printInventoryAsList();
        player.inventory.printInventory();

        player.inventory.sortInventory();

        player.inventory.printInventoryAsList();
        player.inventory.printInventory();
    }
}
