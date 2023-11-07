//Not finished yet

import java.math.BigInteger;

public abstract class Furnace extends Item {
    private double processSpeed;
    private String processEffect;
    protected CircularOreArray<Ore> sharedOreArray;
    protected Player player;

    public Furnace(double processSpeed, String furnaceName, String processEffect, CircularOreArray<Ore> sharedOreArray, Player player) {
        this.processSpeed = processSpeed;
        this.processEffect = processEffect;
        this.sharedOreArray = sharedOreArray;
        this.player = player;
    }

    //Should remove the ore from the circularOreArray and sell it/add the ore value to your wallet
    public void sell(Ore ore) {
        ore = sharedOreArray.get(1);
        if (ore.isDeleted() != false) {
            System.out.println("This ore has already been sold and is invalid!");
        } else {
            BigInteger soldOreValue = ore.getOreValue();
            ore.setOreValue(processEffect(soldOreValue));
            player.setWallet(ore.getOreValue());
            ore.delete();
            sharedOreArray.remove(1);
        }
    }

    //APplies a bonus to the ore before selling it EX: doubles ore value or adds 10 to ore value.
    protected abstract BigInteger processEffect(BigInteger soldOreValue);

    public String toString() {
        String furnaceInfo = "";
        return furnaceInfo;
    }

}


