import java.math.BigDecimal;

public class ResetterUpgrader extends Upgrader {
    private final int maxUpgrades = 1;
    protected int numberOfUpgrades = 0;

    public ResetterUpgrader() {
        super("Multiplies ore value by upgrade count / 10 and resets all upgrade tags", 0, 0, "Renewal Forge", 10, 10, Direction.UPWARDS, 1);
    }

    public ResetterUpgrader(OreDecorator addition) {
        super(addition);
        this.internal = addition;
        this.ore = null;
    }

    public ResetterUpgrader(Ore ore) {
        super(ore);
        this.ore = ore;
        this.internal = null;
    }

    @Override
    protected void upgrade(OreDecorator ore) {
        setStoredOre(new ResetterUpgrader(ore.prepare()));
    }

    @Override
    //Ore.getUpgradeCount might not work.
    protected BigDecimal upgradeEffect(BigDecimal newOreValue) {
        newOreValue = newOreValue.multiply(BigDecimal.valueOf(ore.getUpgradeCount()/10), hundreths);
        return newOreValue;
    }

    @Override
    protected int tempChange(int oreTemperature) {
        return oreTemperature;
    }

    @Override
    protected int multiOreChange(int multiOre) {
        return multiOre;
    }
    
}
