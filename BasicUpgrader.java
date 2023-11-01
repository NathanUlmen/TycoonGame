import java.math.BigInteger;

public class BasicUpgrader extends Upgrader{

    public BasicUpgrader(String upgraderName, CircularOreArray<Ore> sharedOreArray) {
        super("Basic Upgrader", "+ 4", sharedOreArray);
        //TODO Auto-generated constructor stub
    }
    
    @Override
    protected BigInteger upgradeEffect(BigInteger newOreValue) {
        return newOreValue = newOreValue.add(BigInteger.valueOf(4));
    }


}
