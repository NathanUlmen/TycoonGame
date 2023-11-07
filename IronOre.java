import java.math.BigInteger;

public class IronOre extends Ore {
    
    public IronOre() {
        super(oreObserver, oreValue, 0, 0, "Iron Ore", 1, 1);
        this.oreValue = BigInteger.valueOf(2);
        this.oreName = "Iron Ore";
    }

    @Override
    public void handlePositionChange(Ore ore) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handlePositionChange'");
    }


}