import java.text.DecimalFormat;
import java.text.NumberFormat;

public class DriverClass {
    public static void main(String[] args) {
        Dropper[] droppers = new Dropper[3];
        Furnace furnace = new BasicFurnace(0);
        Wallet wallet = new Wallet();
        CircularOreArray<Ore> sharedOreArray = new CircularOreArray<Ore>(250);
        Upgrader[] upgrader = new Upgrader[2];
        upgrader[0] = new BasicUpgrader(null, sharedOreArray);
        upgrader[1] = new TheUpgrader(null, null, sharedOreArray);
        NumberFormat scientificFormat = new DecimalFormat("0.0E0");

    
        System.out.println(sharedOreArray.toString());
        droppers[0] = new IronDropper(0, null, sharedOreArray);
        droppers[1] = new GoldDropper(0, null, sharedOreArray);
        droppers[2] = new RubyDropper(0, null, sharedOreArray);

        System.out.println("Balance: " + wallet.getBalance());
        // droppers[0].startDropping();
        droppers[1].startDropping();
        // droppers[2].startDropping();

        try {
            Thread.sleep(2000); // Sleep for 10 seconds to allow ore generation
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        droppers[1].stopDropping();
        // droppers[1].stopDropping();
        // droppers[2].stopDropping();

        // System.out.println(droppers[0].getTotalOreDropped());
        // System.out.println(droppers[1].getTotalOreDropped());;
        // System.out.println(droppers[2].getTotalOreDropped());;
        System.out.println("Intitial Value: " + sharedOreArray.get(1).getOreValue());
        
        upgrader[0].upgrade(sharedOreArray.get(1));

        System.out.println("After Upgrade: " + sharedOreArray.get(1).getOreValue());

        upgrader[1].upgrade(sharedOreArray.get(1));
        System.out.println("Upgraded by THE Upgrader: " + scientificFormat.format(sharedOreArray.get(1).getOreValue()));
    
        

        System.out.println(scientificFormat.format(sharedOreArray.get(1).getOreValue()));
        


        
        System.out.println(upgrader[1].toString());




        // droppers[0].stopDropping();
        droppers[1].stopDropping();
        System.out.println("Done");

        

        

        

      

        
        
        
    }

}
