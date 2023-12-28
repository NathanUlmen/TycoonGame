import java.math.BigDecimal;

public class IronDropper extends Dropper{

    public IronDropper() {
        super(2000, 0, 0, "Iron Dropper", 0, 0, Direction.UPWARDS, ItemTier.NORMAL);
    }

    @Override
    protected BigDecimal baseOreValue() {
        return BigDecimal.valueOf(2);
    }

    @Override
    protected String setName() {
        return "Iron Ore";
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
