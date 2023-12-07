import java.math.BigDecimal;
import java.math.RoundingMode;

public class TheUpgrader extends Upgrader{

    public TheUpgrader() {
        super("(2(x+10))^1.0275", 0, 0, "The Upgrader", 8, 8, Direction.UPWARDS, UpgradeTag.THE_FINAL_UPGRADER);
    }
    
    public TheUpgrader(OreDecorator addition) {
        super(addition);
        this.internal = addition;
        this.ore = null;
    }

    public TheUpgrader(Ore ore) {
        super(ore);
        this.ore = ore;
        this.internal = null;
    }

    @Override
    protected void upgrade(OreDecorator ore) {
        // if (ore.prepareTags().getUpgradeTag(upgradeIndex) > 0)  {
            setStoredOre(new TheUpgrader(ore));
        //     ore.prepareTags().decrementUpgradeTag(upgradeIndex);
        // }
        
    }

    @Override
    protected BigDecimal upgradeEffect(BigDecimal newOreValue) {
        //Equation: (2(oreValue+10))^1.0275
        return BigDecimal.valueOf(2).multiply(newOreValue.add(BigDecimal.TEN)).pow((int) 1.0275).round(hundreths);
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
