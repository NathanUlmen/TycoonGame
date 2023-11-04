import java.math.BigInteger;

public abstract class ComplexUpgrader extends Upgrader{

    public ComplexUpgrader(String name, String upgraderEffect, CircularOreArray<Ore> sharedOreArray, int positionX,
            int positionY, String itemName, int dimensionX, int dimensionY) {
        super(name, upgraderEffect, sharedOreArray, positionX, positionY, itemName, dimensionX, dimensionY);
        //TODO Auto-generated constructor stub
    }

    //For upgraders that can upgrade the same ore multiple times. This doesnt work currently
    @Override
    protected void performUpgrade(Ore ore) {
        if (ore.hasUpgradeTag(getThisUpgraderTag()) != getThisUpgraderTag()) {
            BigInteger newOreValue = ore.getOreValue();
            ore.setOreValue(upgradeEffect(newOreValue));
            ore.addUpgradeTag(getThisUpgraderTag());
        }
    }
}
 