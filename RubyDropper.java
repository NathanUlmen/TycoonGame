import java.math.BigDecimal;
import java.math.BigInteger;

public class RubyDropper extends Dropper{

    public RubyDropper() {
        super(1000, 0, 0, "Ruby Dropper", 0, 0, Direction.UPWARDS, ItemTier.NORMAL, BigInteger.valueOf(4000));
        
    }
    
    @Override
    protected BigDecimal baseOreValue() {
        return BigDecimal.valueOf(600);
    }

    @Override
    protected String setName() {
        return "Ruby Ore";
    }

    @Override
    protected int startingTemp() {
        return 0;
    }

    @Override
    protected int startingMultiOre() {
        return 1;
    }
    
}
