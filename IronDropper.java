import java.math.BigDecimal;

public class IronDropper extends Dropper{

    public IronDropper() {
        super(2000, 0, 0, "Iron Dropper", 0, 0, Direction.UPWARDS);
    }

    public IronDropper(Ore ore) {
        super(ore);
        this. ore = ore;
        this.internal = null;
    }

    @Override
    protected OreDecorator createOre() {
        OreDecorator ore = new IronDropper((Ore) oreRealm.dequeue());
        System.out.println("Ore Created!");
        return ore;
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
}
