import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class DriverClass {
    public static void main(String[] args) {
            
        CircularOreArray<Ore> sharedOreArray = new CircularOreArray<Ore>(250);
        Player player = new Player(BigInteger.valueOf(0), 0, 0);
        Dropper[] droppers = new Dropper[3];
        Furnace furnace = new BasicFurnace(0, null, null, sharedOreArray, player);
        Upgrader[] upgrader = new Upgrader[3];
        upgrader[0] = new BasicUpgrader(null, sharedOreArray);
        upgrader[1] = new TheUpgrader(null, null);
        NumberFormat scientificFormat = new DecimalFormat("0.0E0");

        System.out.println(sharedOreArray.size());
        System.out.println(sharedOreArray.toString());
        droppers[0] = new IronDropper(0, sharedOreArray);
        droppers[1] = new GoldDropper(0, sharedOreArray);
        droppers[2] = new RubyDropper(0, sharedOreArray);
        
        droppers[0].startDropping();
        droppers[1].startDropping();
        droppers[2].startDropping();

        try {
            Thread.sleep(6000); // Sleep for 10 seconds to allow ore generation
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        upgrader[1].setPosition(1, 1);
        

        droppers[0].stopDropping();
        droppers[1].stopDropping();
        droppers[2].stopDropping();

        System.out.println(sharedOreArray.toString());

        // System.out.println("Intitial Value: " + sharedOreArray.get(1).getOreValue());
        
        // upgrader[0].upgrade(sharedOreArray.get(1));

        // System.out.println("After Upgrade: " + sharedOreArray.get(1).getOreValue());

        // upgrader[1].upgrade(sharedOreArray.get(1));
        // System.out.println(sharedOreArray.get(1).getOreValue());
        // System.out.println("Upgraded by THE Upgrader: " + scientificFormat.format(sharedOreArray.get(1).getOreValue()));
    
        // System.out.println(scientificFormat.format(sharedOreArray.get(1).getOreValue()));

        // System.out.println("Intitial Value: " + sharedOreArray.get(2).getOreValue());






        // droppers[0].stopDropping();
        // droppers[1].stopDropping();
        System.out.println("Done");

        

        

        

      

        
        
        
    }

}
