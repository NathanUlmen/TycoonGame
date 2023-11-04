import java.math.BigInteger;

public class BasicUpgrader extends ComplexUpgrader{

    public BasicUpgrader(String upgraderName, CircularOreArray<Ore> sharedOreArray) {
        super("Basic Upgrader", "+ 4", sharedOreArray, -1, -1, upgraderName, 0, 0);
        //TODO Auto-generated constructor stub
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
