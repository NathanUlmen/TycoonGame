import java.math.BigInteger;

public class IronOre extends Ore implements OreInterface {
    
    public IronOre() {
        super();
        this.oreValue = BigInteger.valueOf(2);
        this.oreName = "Iron Ore";
    }

    @Override
    public BigInteger getValue() {
        return oreValue;
    }
}
