import java.math.BigDecimal;

public class RubyDropper extends Dropper{

    public RubyDropper() {
        super(1000, 0, 0, "Ruby Dropper", 0, 0, Direction.UPWARDS, ItemTier.NORMAL);
        
    }
    
    @Override
    protected BigDecimal baseOreValue() {
        return BigDecimal.valueOf(400);
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
