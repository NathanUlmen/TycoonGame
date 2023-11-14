import java.math.BigInteger;

public abstract class Upgrader  extends ProcessingItem {
    private String upgraderEffect;

    public Upgrader(String upgraderEffect, int positionX, int positionY, String itemName, int dimensionX, int dimensionY, int direction) {
        super(positionX, positionY, itemName, dimensionX, dimensionY, direction);
        // super(positionX, positionY, itemName, dimensionX, dimensionY);
        this.upgraderEffect = upgraderEffect;
    }
    @Override
    public void process(Ore ore) {
        upgrade(ore);
    }

    //this will upgrade the ore, still need to figure out how to make the sharedOreArray.get() automated so I dont have to set it manually. 
    public  void upgrade(Ore ore) {
        performUpgrade(ore);
    }
    
    //
    protected abstract void performUpgrade(Ore ore);

    //the specific upgrade effect will vary depending on the upgrader.
    protected abstract BigInteger upgradeEffect(BigInteger newOreValue);

    //gets the upgrader tag of the upgrader.
    protected abstract UpgradeTags getThisUpgraderTag();

    //
    public String toString() { 
        String upgraderInfo = "Upgrader Name: " + getItemName() + "\nUpgrader Effect: Increases ore value by " + upgraderEffect;
        return upgraderInfo;
    }
} 