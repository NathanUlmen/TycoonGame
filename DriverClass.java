public class DriverClass {
    public static void main(String[] args) {
        Dropper[] droppers = new Dropper[3];
        Furnace furnace = new BasicFurnace(0);
        Wallet wallet = new Wallet();
        CircularOreArray<Ore> sharedOreArray = new CircularOreArray<Ore>(250);
    
        System.out.println(sharedOreArray.toString());
        droppers[0] = new IronDropper(0, null, sharedOreArray);
        droppers[1] = new GoldDropper(0, null, sharedOreArray);
        droppers[2] = new RubyDropper(0, null, sharedOreArray);

        System.out.println("Balance: " + wallet.getBalance());
        droppers[0].startDropping();
        droppers[1].startDropping();
        droppers[2].startDropping();

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
        
        // furnace.sell();

        System.out.println(sharedOreArray.toString());
        
        System.out.println("Done");

        

        

      

        
        
        
    }

}
