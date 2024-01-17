import java.math.BigDecimal;
import java.math.BigInteger;

public class GoldDropper extends Dropper{

    public GoldDropper() {
        super(1000, 0, 0, "Gold Dropper", 0, 0, Direction.UPWARDS, ItemTier.NORMAL, BigInteger.valueOf(1000));
    }
    @Override
    protected BigDecimal baseOreValue() {
        return BigDecimal.valueOf(100);
    }

    @Override
    protected String setName() {
        return "Gold Ore";
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
