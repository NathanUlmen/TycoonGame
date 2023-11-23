import java.math.BigDecimal;
import java.math.MathContext;

public class TheUpgrader extends Upgrader{
    private int maxUpgrades = 1;
    private static int numberOfUpgrades = 0;

    public TheUpgrader() {
        super("(sqr(x+x/3 +10) * 3)^2.033", 0, 0, "The Upgrader", 8, 8, Direction.UPWARDS);
    }
    
    public TheUpgrader(OreDecorator addition) {
        super(addition);
        this.internal = addition;
        this.ore = null;
        numberOfUpgrades++;
    }

    public TheUpgrader(Ore ore) {
        super(ore);
        this.ore = ore;
        this.internal = null;
        numberOfUpgrades++;
    }
    
    // @Override
    // protected BigInteger upgradeEffect(BigInteger newOreValue) {
    //     BigDecimal val1 = new BigDecimal(newOreValue);
    //     BigDecimal val2 = new BigDecimal(newOreValue);
    //     val1 = val1.add(val2.divide(BigDecimal.valueOf(3), MathContext.DECIMAL32));
    //     val1 = val1.add(BigDecimal.valueOf(10));
    //     val1 = val1.sqrt(MathContext.DECIMAL32);
    //     val1 = val1.multiply(BigDecimal.valueOf(3), MathContext.DECIMAL32);
    //     val1 = new BigDecimal(Math.pow(val1.doubleValue(), 2.033), (MathContext.DECIMAL32));
    //     newOreValue = val1.toBigInteger();

    //     return newOreValue;
    //     // return newOreValue = newOreValue.add(BigInteger.valueOf(4));
    // }

    @Override
    protected OreDecorator upgrade(OreDecorator ore) {
        if (canUpgrade(TheUpgrader.numberOfUpgrades, maxUpgrades)) {
            ore = new TheUpgrader(ore);
        }
        return ore;
    }

    @Override
    protected BigDecimal upgradeEffect(BigDecimal newOreValue) {
        BigDecimal val1, val2;
        val1 = val2 = newOreValue;
        val1 = val1.add(val2.divide(BigDecimal.valueOf(3), MathContext.DECIMAL32));
        val1 = val1.add(BigDecimal.valueOf(10));
        val1 = val1.sqrt(MathContext.DECIMAL32);
        val1 = val1.multiply(BigDecimal.valueOf(3), MathContext.DECIMAL32);
        val1 = new BigDecimal(Math.pow(val1.doubleValue(), 2.033), (MathContext.DECIMAL32));
        newOreValue = val1;
        return newOreValue;
    }

    @Override
    protected int tempChange(int oreTemperature) {
        return oreTemperature;
    }

}
