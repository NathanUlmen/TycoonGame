import java.math.BigInteger;

public class GoldOre extends Ore implements OreInterface{
    public GoldOre() {
        this.oreName = "Gold Ore";
        this.oreValue = BigInteger.valueOf(100);
        
    }

    @Override
    public BigInteger getValue() {
        return oreValue;
    }

}
