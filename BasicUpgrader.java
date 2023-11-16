import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

public class BasicUpgrader extends ComplexUpgrader{

    public BasicUpgrader() {
        super("+ 4", 0, 0, "Basic Upgrader", 4, 5, Direction.UPWARDS);
        
    }
    
    @Override
    protected BigInteger upgradeEffect(BigInteger newOreValue) {
        // return newOreValue = newOreValue.add(BigInteger.valueOf(4));
        return newOreValue = newOreValue.multiply(BigInteger.valueOf(1000000000));
    
    }

    @Override
    protected UpgradeTags getThisUpgraderTag() {
        return UpgradeTags.BASIC_UPGRADE_TAG;
    }


}
