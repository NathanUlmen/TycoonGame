import java.math.BigDecimal;

public class TheUpgrader extends Upgrader{
    protected final int upgradeLimit = 1;

    public TheUpgrader() {
        super("(2(x+10))^1.0275", 0, 0, "The Upgrader", 8, 8, Direction.UPWARDS);
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
        ore = new TheUpgrader(ore);
        setStoredOre(ore);
    }

    @Override
    protected BigDecimal upgradeEffect(BigDecimal newOreValue) {
        //Equation: (2(oreValue+10))^1.0275
        newOreValue = new BigDecimal(Math.pow(newOreValue.add(BigDecimal.valueOf(10)).multiply(BigDecimal.valueOf(2)).doubleValue(), 1.0275), hundreths);
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
