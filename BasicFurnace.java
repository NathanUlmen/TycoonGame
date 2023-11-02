import java.math.BigInteger;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

public class BasicFurnace extends Furnace{

    public BasicFurnace(double processSpeed, String furnaceName, String processEffect, CircularOreArray<Ore> sharedOreArray, Player player) {
        super(5, "Basic Furnace", " + 0", sharedOreArray, player);
        //TODO Auto-generated constructor stub
    }

    @Override
    protected BigInteger processEffect(BigInteger soldOreValue) {
        return soldOreValue;
    }
    
}
