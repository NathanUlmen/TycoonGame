import java.math.BigInteger;

public abstract class ComplexUpgrader extends Upgrader{

    public ComplexUpgrader(String name, String upgraderEffect, int positionX,
            int positionY, String itemName, int dimensionX, int dimensionY) {
        super(name, upgraderEffect, positionX, positionY, itemName, dimensionX, dimensionY, dimensionY);
        //TODO Auto-generated constructor stub
    }

    //For upgraders that can upgrade the same ore multiple times. This doesnt work currently, its just using the logic of Simple upgrader.
    @Override
    protected void performUpgrade(Ore ore) {
        // if (ore.hasUpgradeTag(getThisUpgraderTag()) != getThisUpgraderTag()) {
        //     BigInteger newOreValue = ore.getOreValue();
        //     ore.setOreValue(upgradeEffect(newOreValue));
        //     ore.addUpgradeTag(getThisUpgraderTag());
        // } else {
        //     System.out.println("Ore has been upgraded the max number of times!");
        // }
        BigInteger newOreValue = ore.getOreValue();
        ore.setOreValue(upgradeEffect(newOreValue));
    }
}
 