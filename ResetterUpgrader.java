import java.math.BigDecimal;
import java.math.BigInteger;

public class ResetterUpgrader extends Upgrader {

    public ResetterUpgrader() {
        super("Multiplies ore value by upgrade count / 10 and resets all upgrade tags", 0, 0, "Renewal Forge", 10, 10, Direction.UPWARDS, UpgradeTag.RENEWAL_FORGE, ItemTier.PRESTIGE, BigInteger.valueOf(0));
    }

    @Override
    protected void upgrade(Ore ore) {
        ore.applyUpgrade(upgradeEffect(ore.getOreValue()));
        ore.resetNonResetterTags();
    }

    @Override
    //Ore.getUpgradeCount might not work, needs testing.
    protected BigDecimal upgradeEffect(BigDecimal newOreValue) {
        newOreValue = newOreValue.multiply(BigDecimal.valueOf(1), hundreths);
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
