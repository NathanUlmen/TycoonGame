//Not finished yet

import java.math.BigInteger;
import java.util.LinkedList;

public abstract class Furnace extends Item implements ProcessingItem{
    private double processSpeed;
    private String processEffect;
    protected CircularOreArray<Ore> sharedOreArray;
    protected Player player;
    private LinkedList<Ore> oreQueue = new LinkedList<>();

    public Furnace() {
        this.processSpeed = processSpeed;
        this.processEffect = processEffect;
        // this.oreQueue = oreQueue;
        this.player = player;
    }

    @Override
    public void process(Ore ore) {
        sell(ore);
    }

    //Should remove the ore from the circularOreArray and sell it/add the ore value to your wallet
    public void sell(Ore ore) {
        if (ore.isDeleted() != false) {
            System.out.println("This ore has already been sold and is invalid!");
        } else {
            BigInteger soldOreValue = ore.getOreValue();
            ore.setOreValue(processEffect(soldOreValue));
            player.setWallet(ore.getOreValue());
            ore.delete();
            // oreQueue.remove(ore);
        }
    }

    //APplies a bonus to the ore before selling it EX: doubles ore value or adds 10 to ore value.
    protected abstract BigInteger processEffect(BigInteger soldOreValue);

    public String toString() {
        String furnaceInfo = "";
        return furnaceInfo;
    }

}


