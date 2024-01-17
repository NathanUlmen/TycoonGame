import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class BasicUpgrader extends Upgrader{   

    public BasicUpgrader() {
        super("+ 4", 0, 0, "Basic Upgrader", 4, 5, Direction.UPWARDS, UpgradeTag.BASIC_UPGRADER, ItemTier.NORMAL, BigInteger.valueOf(40));
    }

    @Override
    protected int tempChange(int oreTemperature) {
        return oreTemperature;
    }

    @Override
    protected BigDecimal upgradeEffect(BigDecimal newOreValue) {
//        return newOreValue.add(BigDecimal.valueOf(4));
        return BigDecimal.valueOf(2).multiply(newOreValue.add(BigDecimal.valueOf(10))).pow((int) 1.0275);
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
