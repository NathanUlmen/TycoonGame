import java.math.BigInteger;

public class BasicFurnace extends Furnace{

    public BasicFurnace(double processSpeed) {
        super(5, "Basic Furnace");
        //TODO Auto-generated constructor stub
    }

    @Override
    protected BigInteger processEffect(Ore ore) {
        BigInteger earnings = ore.getOreValue();
        return earnings;
    }
    
}
