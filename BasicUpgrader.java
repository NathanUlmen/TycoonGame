import java.math.BigDecimal;

public class BasicUpgrader extends Upgrader{
    private static final int maxUpgrades = 4;
    private boolean canModify;
    private static int numberOfUpgrades;

    public BasicUpgrader() {
        super("+ 4", 0, 0, "Basic Upgrader", 4, 5, Direction.UPWARDS, 4);
        //s
    }

    public BasicUpgrader(OreDecorator addition) {
        super(addition);
        this.internal = addition;
        this.ore = null;
        // this.numberOfUpgrades = getNumberOfUpgrades();
        // upgradeable = BasicUpgrader.numberOfUpgrades <= maxUpgrades;
        // numberOfUpgrades++;
    }

    public BasicUpgrader(Ore ore) {
        super(ore);
        this.ore = ore;
        this.internal = null;
        // upgradeable = this.numberOfUpgrades <= 4;
        // numberOfUpgrades++;
    }
    

    @Override
    protected int tempChange(int oreTemperature) {
        return oreTemperature;
    }

    @Override
    protected BigDecimal upgradeEffect(BigDecimal newOreValue) {
        return newOreValue.multiply(BigDecimal.valueOf(400000000));
        // return BigDecimal.valueOf(2).multiply(newOreValue.add(BigDecimal.TEN)).pow((int) 1.0275);
    }

    @Override
    protected void upgrade(OreDecorator ore) {
        setStoredOre(new BasicUpgrader(ore));
    }

    @Override
    protected int multiOreChange(int multiOre) {
        return multiOre;
    }
    
}
