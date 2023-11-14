import java.math.BigInteger;


public class BasicFurnace extends Furnace{

    public BasicFurnace(int positionX, int positionY, String itemName, double processSpeed, String furnaceName, String processEffect, Player player) {
        super(positionX, positionY, itemName, processSpeed, processEffect, processEffect, player);
        
    }

    @Override
    protected BigInteger processEffect(BigInteger soldOreValue) {
        return soldOreValue;
    }
    
}
