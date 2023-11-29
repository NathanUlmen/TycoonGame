import java.math.BigDecimal;

public class BasicUpgrader extends Upgrader{
    private final int maxUpgrades = 4;
    private static int numberOfUpgrades = 0;

    public BasicUpgrader() {
        super("+ 4", 0, 0, "Basic Upgrader", 4, 5, Direction.UPWARDS);
        
    }

    public BasicUpgrader(OreDecorator addition) {
        super(addition);
        this.internal = addition;
        this.ore = null;
        // numberOfUpgrades++;
    }

    public BasicUpgrader(Ore ore) {
        super(ore);
        this.ore = ore;
        this.internal = null;
        // numberOfUpgrades++;
    }
    

    @Override
    protected int tempChange(int oreTemperature) {
        return oreTemperature;
    }

    @Override
    protected BigDecimal upgradeEffect(BigDecimal newOreValue) {
        return newOreValue = newOreValue.add(BigDecimal.valueOf(4));
    }

    @Override
    protected void upgrade(OreDecorator ore) {
        // if (canUpgrade(BasicUpgrader.numberOfUpgrades, maxUpgrades) && ore != null) {
            ore = new BasicUpgrader(ore);
            setStoredOre(ore);
        //}
    }

}
