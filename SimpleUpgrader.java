import java.math.BigInteger;

public abstract class SimpleUpgrader extends Upgrader{

    public SimpleUpgrader(String name, String upgraderEffect, CircularOreArray<Ore> sharedOreArray, int positionX,
            int positionY, String itemName, int dimensionX, int dimensionY) {
        super(name, upgraderEffect, sharedOreArray, positionX, positionY, itemName, dimensionX, dimensionY);
        //TODO Auto-generated constructor stub
    }

    // public void simpleUpgrade(Ore ore) {
    //     if (ore.hasUpgradeTag(getThisUpgraderTag()) != getThisUpgraderTag()) {
    //         BigInteger newOreValue = ore.getOreValue();
    //         ore.setOreValue(upgradeEffect(newOreValue));
    //         ore.addUpgradeTag(getThisUpgraderTag());
    //     } else {
    //         System.out.println("Ore has been upgraded the max number of times!");
    //     }
    // }
     
    //This will Work for all upgraders that are only able to upgrade the ore Once.
    @Override
    protected void performUpgrade(Ore ore) {
        if (ore.hasUpgradeTag(getThisUpgraderTag()) != getThisUpgraderTag()) {
            BigInteger newOreValue = ore.getOreValue();
            ore.setOreValue(upgradeEffect(newOreValue));
            ore.addUpgradeTag(getThisUpgraderTag());
        } else {
            System.out.println("Ore has been upgraded the max number of times!");
        }
    }
    
}