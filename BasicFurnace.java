import java.math.BigDecimal;
import java.math.BigInteger;

public class BasicFurnace extends Furnace{

    public BasicFurnace() {
       super(0, 0, "Basic Furnace", 0, "Sells ore with no Bonus", Direction.UPWARDS, 10, 50, 0, ItemTier.NORMAL, BigInteger.valueOf(40));
    }

    @Override
    protected BigDecimal processEffect(BigDecimal soldOreValue) {
        return soldOreValue;
    }
    
}