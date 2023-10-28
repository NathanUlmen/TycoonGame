public class DriverClass {
    public static void main(String[] args) {
        Dropper[] droppers = new Dropper[3];
        Furnace furnace = new BasicFurnace(0);
        int[] activeOre = new int[droppers.length];
        Ore ironOre = new IronOre();
        Ore goldOre = new GoldOre();
        Ore ore;
        Wallet wallet = new Wallet();
        CircularOreArray<Ore> sharedOreArray = new CircularOreArray<Ore>(250);
    
        System.out.println(sharedOreArray.toString());
        droppers[0] = new IronDropper(0, null, sharedOreArray);
        droppers[1] = new GoldDropper(0, null, sharedOreArray);
        droppers[2] = new RubyDropper(0, null, sharedOreArray);

        furnace.sell(goldOre);
        System.out.println("Balance: " + wallet.getBalance());
        droppers[0].startDropping();
        droppers[1].startDropping();
        droppers[2].startDropping();

        
        
        //droppers[1].startDropping();

        try {
            Thread.sleep(26000); // Sleep for 10 seconds to allow ore generation
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        droppers[0].stopDropping();
        droppers[1].stopDropping();
        droppers[2].stopDropping();

        System.out.println(droppers[0].getTotalOreDropped());
        System.out.println(droppers[1].getTotalOreDropped());;
        System.out.println(droppers[2].getTotalOreDropped());;
        
        // Retrieve and store the total ore counts for each Dropper
        // furnace.sell();

        System.out.println(sharedOreArray.toString());
        
        // droppers[1].stopDropping();

        // System.out.println("Total Active ore:");
        // for (int i = 0; i < droppers.length; i++) {
        //     activeOre[i] = droppers[i].getTotalOreDropped();
        // }

        // Print the total ore counts for each Dropper
        // for (int i = 0; i < droppers.length; i++) {
        //     System.out.println(droppers[i].dropperName + " created " + activeOre[i] + " ore objects.");
        // }

        // for (int i = 0; i <= 5; i++) {
        //     furnace.sell(ironOre);
        // }

        // System.out.println("Wallet Balance: " + wallet.getBalance());

        // for (int i = 0; i <= 12; i++) {
        //     furnace.sell(goldOre);
        // }

        // System.out.println("Wallet Balance: " + wallet.getBalance());
        
        

        // droppers[0].getTotalOreDropped();
        // droppers[1].getTotalOreDropped();
        System.out.println("Done");

        

        

      

        
        
        
    }

}
