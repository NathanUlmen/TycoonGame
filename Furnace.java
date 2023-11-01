//Not finished yet

import java.math.BigInteger;

public abstract class Furnace {
    private double processSpeed;

    public Furnace(double processSpeed, String furnaceName) {
        this.processSpeed = processSpeed;
    }

    //Should remove the ore from the circularOreArray and sell it/add the ore value to your wallet
    public void sell(Ore ore) {
        
    }

    //APplies a bonus to the ore before selling it EX: doubles ore value or adds 10 to ore value.
    protected abstract BigInteger processEffect(Ore ore);

    public String toString() {
        String furnaceInfo = "";
        return furnaceInfo;
    }

}


