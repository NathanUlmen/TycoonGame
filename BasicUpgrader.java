import java.math.BigInteger;
import java.util.LinkedList;

public class BasicUpgrader extends ComplexUpgrader{

    public BasicUpgrader() {
        super("+ 4", 4, 0, "Basic Upgrader", 4, 5, direction);
        
    }
    
    @Override
    protected BigInteger upgradeEffect(BigInteger newOreValue) {
        return newOreValue = newOreValue.add(BigInteger.valueOf(4));
    }

    @Override
    protected UpgradeTags getThisUpgraderTag() {
        return UpgradeTags.BASIC_UPGRADE_TAG;
    }


}
