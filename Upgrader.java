import java.math.BigInteger;

public abstract class Upgrader  extends Item implements Observer{
    private String upgraderEffect;
    protected CircularOreArray<Ore> sharedOreArray;

    // public Upgrader(String name, String upgraderEffect, CircularOreArray<Ore> sharedOreArray, int positionX, int positionY, String itemName, int dimensionX, int dimensionY) {
    //     super(dimensionY, dimensionY, name, dimensionY, dimensionY);
    //     this.sharedOreArray = sharedOreArray;
    //     // this.upgraderName = upgraderName;
    //     this.upgraderEffect = upgraderEffect;
    // }

    public Upgrader(String name, String upgraderEffect, CircularOreArray<Ore> sharedOreArray, int positionX, int positionY, String itemName, int dimensionX, int dimensionY) {
        super(positionX, positionY, itemName, dimensionX, dimensionY);
        this.sharedOreArray = sharedOreArray;
        this.upgraderEffect = upgraderEffect;
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
    
    @Override
    public void update(Ore ore) {
        handlePositionChange(ore);
    }

    @Override
    public void handlePositionChange(Ore ore) {
        int orePositionX = ore.getPositionX();
        int orePositionY = ore.getPositionY();
        
        if (orePositionX == positionX && orePositionY == positionY) {
            // Perform the appropriate action on the Ore (upgrade, sell, etc.).
            upgrade(ore);
        }
    }
} 