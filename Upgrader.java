import java.math.BigDecimal;

public abstract class Upgrader extends ProcessingItem implements OreDecorator{
    private String upgraderEffect;
    protected Ore ore;
    protected OreDecorator internal;
    protected boolean canUpgrade;


    public Upgrader(String upgraderEffect, int positionX, int positionY, String itemName, int dimensionX, int dimensionY, Direction direction) {
        super(positionX, positionY, itemName, dimensionX, dimensionY, direction);
        // super(positionX, positionY, itemName, dimensionX, dimensionY);
        this.upgraderEffect = upgraderEffect;
    }

    public Upgrader(OreDecorator addition) {
        this.internal = addition;
        this.ore = null;
    }

    public Upgrader(Ore ore) {
        this.ore = ore;
        this.internal = null;
        
    }
    
    @Override
    public OreDecorator process(OreDecorator ore) {
        System.out.println("Upgraded!");
        return ore = upgrade(ore);
    }

    // //this will upgrade the ore, still need to figure out how to make the sharedOreArray.get() automated so I dont have to set it manually. 
    // public void upgrade(Ore ore) {
    //     performUpgrade(ore);
    // }

    @Override
    public Ore prepare() {
        Ore result = (ore != null) ? ore : internal.prepare();
        result.applyUpgrade(upgradeEffect(result.getOreValue()), tempChange(result.getOreTemp()));
        return result;
    }
    
    
    protected abstract OreDecorator upgrade(OreDecorator ore);

    protected abstract BigDecimal upgradeEffect(BigDecimal newOreValue);

    protected abstract int tempChange(int oreTemperature);

    protected boolean canUpgrade(int numberOfUpgrades ,int maxUpgrades) {
        return numberOfUpgrades <= maxUpgrades;
    }

    //the specific upgrade effect will vary depending on the upgrader.
    

    //gets the upgrader tag of the upgrader.
    // protected abstract UpgradeTags getThisUpgraderTag();

    //
    public String toString() { 
        //String upgraderInfo = "Upgrader Name: " + getItemName() + "\nUpgrader Effect: Increases ore value by " + upgraderEffect;
        return "Upgrader Name: " + getItemName() + "\nUpgrader Effect: Increases ore value by " + upgraderEffect;
    }
   
} 