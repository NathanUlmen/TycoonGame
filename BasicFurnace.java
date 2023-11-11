import java.math.BigInteger;
import java.util.LinkedList;

public class BasicFurnace extends Furnace{

    public BasicFurnace(double processSpeed, String furnaceName, String processEffect, Player player) {
        super();
    }

    @Override
    protected BigInteger processEffect(BigInteger soldOreValue) {
        return soldOreValue;
    }
    
}
