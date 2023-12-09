import java.math.BigDecimal;

public class BasicUpgrader extends Upgrader{   

    public BasicUpgrader() {
        super("+ 4", 0, 0, "Basic Upgrader", 4, 5, Direction.UPWARDS, UpgradeTag.BASIC_UPGRADER, ItemTier.NORMAL);
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
    //   return newOreValue.add(BigDecimal.valueOf(4));
        return BigDecimal.valueOf(20).multiply(newOreValue.add(BigDecimal.TEN)).pow((int) 2.0275);
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
