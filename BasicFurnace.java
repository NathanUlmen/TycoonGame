import java.math.BigInteger;

public class BasicFurnace extends Furnace{

    public BasicFurnace(double processSpeed, String furnaceName, String processEffect, CircularOreArray<Ore> sharedOreArray, Player player) {
        super(5, "Basic Furnace", " + 0", sharedOreArray, player);
    }

    @Override
    protected BigInteger processEffect(BigInteger soldOreValue) {
        return soldOreValue;
    }
    
}
