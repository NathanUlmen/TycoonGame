import java.math.BigDecimal;
import java.math.RoundingMode;

public class TheUpgrader extends Upgrader{
    protected final int upgradeLimit = 1;

    public TheUpgrader() {
        super("(2(x+10))^1.0275", 0, 0, "The Upgrader", 8, 8, Direction.UPWARDS, 1);
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
        setStoredOre(new TheUpgrader(ore));
    }

    @Override
    protected BigDecimal upgradeEffect(BigDecimal newOreValue) {
        //Equation: (2(oreValue+10))^1.0275
        // newOreValue = new BigDecimal(Math.pow(newOreValue.add(BigDecimal.valueOf(10)).multiply(BigDecimal.valueOf(2)).doubleValue(), 1.0275), hundreths);
        
        // .setScale(hundreths, RoundingMode.HALF_UP);
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
