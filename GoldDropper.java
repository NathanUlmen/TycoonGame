import java.math.BigDecimal;

public class GoldDropper extends Dropper{

    public GoldDropper() {
        super(1000, 0, 0, "Gold Dropper", 0, 0, Direction.UPWARDS);
    }

    public GoldDropper(Ore ore) {
        super(ore);
        this.ore = ore;
        this.internal = null;
    }
    
    @Override
    protected OreDecorator createOre() {
        OreDecorator ore = new GoldDropper((Ore) oreRealm.pop());
        return ore;
    }

    @Override
    protected BigDecimal baseOreValue() {
        return BigDecimal.valueOf(4);
    }

    @Override
    protected String setName() {
        return "Gold Ore";
    }

    @Override
    protected int startingTemp() {
        return 0;
    }
    
}
