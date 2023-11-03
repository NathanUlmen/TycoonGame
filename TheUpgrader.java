import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

public class TheUpgrader extends Upgrader{

    public TheUpgrader(String upgraderName, String upgraderEffect, CircularOreArray<Ore> sharedOreArray) {
        super("The Upgrader", "(sqr(x+x/3 +10) *1.3)^2.055", sharedOreArray);
    }
    
    @Override
    protected BigInteger upgradeEffect(BigInteger newOreValue) {
        BigDecimal val1 = new BigDecimal(newOreValue);
        BigDecimal val2 = new BigDecimal(newOreValue);

        val1 = val1.add(val2.divide(BigDecimal.valueOf(3), MathContext.DECIMAL32));
        // System.out.println("After adding x to x and dividing by 3: " + val1);
        val1 = val1.add(BigDecimal.valueOf(10));
        // System.out.println("After adding 10: " + val1);
        val1 = val1.sqrt(MathContext.DECIMAL32);
        // System.out.println("After sqr: " + val1);

        val1 = val1.multiply(BigDecimal.valueOf(3), MathContext.DECIMAL32);
        // System.out.println("After multiplying by 1.2: " + val1);

        val1 = new BigDecimal(Math.pow(val1.doubleValue(), 2.033));
        // val1 = val1.pow((int) 2.055, MathContext.DECIMAL32);
        //System.out.println("After raising to 2.055: " + val1);
        newOreValue = val1.toBigInteger();
        // System.out.println(newOreValue);    

        return newOreValue;
    }
}
