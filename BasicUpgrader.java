import java.math.BigDecimal;
import java.math.RoundingMode;

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
         return newOreValue.add(BigDecimal.valueOf(4));
//        return BigDecimal.valueOf(2).multiply(newOreValue.add(BigDecimal.valueOf(10))).pow((int) 1.0275);
    }

    @Override
    protected void upgrade(Ore ore) {
        ore.applyUpgrade(upgradeEffect(ore.getOreValue()));
    }

    @Override
    protected int multiOreChange(int multiOre) {
        return multiOre;
    }
    
}
