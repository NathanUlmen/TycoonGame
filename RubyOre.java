import java.math.BigInteger;

public class RubyOre extends Ore implements OreInterface{

    public RubyOre() {
       super();
       this.oreValue = BigInteger.valueOf(100);
       this.oreName = "Ruby Ore"; 
    }


    @Override
    public BigInteger getValue() {
        return oreValue;
    }
}
