import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

public class TheUpgrader extends SimpleUpgrader{

    public TheUpgrader() {
        super("(sqr(x+x/3 +10) * 3)^2.033", 0, 0, "The Upgrader", 8, 8, Direction.UPWARDS);
    }
    
    @Override
    protected BigInteger upgradeEffect(BigInteger newOreValue) {
        BigDecimal val1 = new BigDecimal(newOreValue);
        BigDecimal val2 = new BigDecimal(newOreValue);
        val1 = val1.add(val2.divide(BigDecimal.valueOf(3), MathContext.DECIMAL32));
        val1 = val1.add(BigDecimal.valueOf(10));
        val1 = val1.sqrt(MathContext.DECIMAL32);
        val1 = val1.multiply(BigDecimal.valueOf(3), MathContext.DECIMAL32);
        val1 = new BigDecimal(Math.pow(val1.doubleValue(), 2.033), (MathContext.DECIMAL32));
        newOreValue = val1.toBigInteger();

        return newOreValue;
        // return newOreValue = newOreValue.add(BigInteger.valueOf(4));
    }

    @Override
    protected UpgradeTags getThisUpgraderTag() {
        return UpgradeTags.THE_UPGRADE_TAG;
    }

}
