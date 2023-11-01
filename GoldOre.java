import java.math.BigInteger;

public class GoldOre extends Ore implements OreInterface{
    public GoldOre() {
        this.oreName = "Gold Ore";
        this.oreValue = BigInteger.valueOf(1000000000);
        
    }

    @Override
    public BigInteger getValue() {
        return oreValue;
    }

}
