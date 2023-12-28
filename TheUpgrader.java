import java.math.BigDecimal;

public class TheUpgrader extends Upgrader{

    public TheUpgrader() {
        super("(2(x+10))^1.0275", 0, 0, "The Upgrader", 8, 8, Direction.UPWARDS, UpgradeTag.THE_FINAL_UPGRADER, ItemTier.PINNACLE);
    }

    @Override
    protected void upgrade(Ore ore) {
        ore.applyUpgrade(upgradeEffect(ore.getOreValue()));
    }

    @Override
    protected BigDecimal upgradeEffect(BigDecimal newOreValue) {
        //Equation: (2(oreValue+10))^1.0275
        return BigDecimal.valueOf(2).multiply(newOreValue.add(BigDecimal.valueOf(10))).pow((int) 1.0275);
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
