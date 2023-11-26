import java.math.BigDecimal;

public class ResetterUpgrader extends Upgrader {
    private final int maxUpgrades = 1;
    protected int numberOfUpgrades = 0;

    public ResetterUpgrader(String upgraderEffect, int positionX, int positionY, String itemName, int dimensionX,
            int dimensionY, Direction direction) {
        super("Multiplies ore value by upgrade count / 10 and resets all upgrade tags", positionX, positionY, itemName, dimensionX, dimensionY, direction);
    }

    public ResetterUpgrader(OreDecorator addition) {
        super(addition);
        this.internal = addition;
        this.ore = null;
        this.numberOfUpgrades++;
    }

    public ResetterUpgrader(Ore ore) {
        super(ore);
        this.ore = ore;
        this.internal = null;
        this.numberOfUpgrades++;
    }

    @Override
    protected void upgrade(OreDecorator ore) {
        if (canUpgrade(this.numberOfUpgrades, maxUpgrades)) {
            ore = new ResetterUpgrader(ore.prepare());
            setStoredOre(ore);
        }
        
    }

    @Override
    protected BigDecimal upgradeEffect(BigDecimal newOreValue) {
        newOreValue = newOreValue.multiply(BigDecimal.valueOf(ore.getUpgradeCount()/10), hundreths);
        return newOreValue;
    }

    @Override
    protected int tempChange(int oreTemperature) {
        return oreTemperature;
    }
    
}
