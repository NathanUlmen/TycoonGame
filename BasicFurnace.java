import java.math.BigDecimal;
import java.math.BigInteger;


public class BasicFurnace extends Furnace{

    public BasicFurnace(Player player) {
        super(0, 0, "Basic Furnace", 0, "Sells ore with no Bonus", player, Direction.UPWARDS);
        
    }


    @Override
    protected BigDecimal processEffect(BigDecimal soldOreValue) {
        return soldOreValue;
    }
    
}
