import java.math.BigInteger;

public class GoldOre extends Ore{
    public GoldOre() {
        super(oreObserver, oreValue, 0, 0, "Gold Ore", 1, 1);
        this.oreName = "Gold Ore";
        this.oreValue = BigInteger.valueOf(100);
        
    }

    

    @Override
    public void handlePositionChange(Ore ore) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handlePositionChange'");
    }

}
