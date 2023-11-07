import java.math.BigInteger;

public class RubyOre extends Ore{

    public RubyOre() {
       super(oreObserver, oreValue, 0, 0, "Ruby Ore", 1, 1);
       this.oreObserver = oreObserver;
        oreObserver.registerObserver(this);
       this.oreValue = BigInteger.valueOf(100);
       this.oreName = "Ruby Ore"; 
    }

    @Override
    public void handlePositionChange(Ore ore) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handlePositionChange'");
    }

}
