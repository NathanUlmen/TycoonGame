//The Furnace Class takes an ore and sells it, getting rid of it and granting you money

import java.math.BigInteger;
import java.util.LinkedList;

public abstract class Furnace extends ProcessingItem{
    private double processSpeed;
    private String processEffect;
    
    protected Player player;
    private LinkedList<Ore> oreQueue = new LinkedList<>();

    public Furnace(int positionX, int positionY, String itemName, double processSpeed, String furnaceName, String processEffect, Player player) {
        super(positionX, positionY, "Furnace", positionX, positionY, direction);
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
            setCurrentOre(null);
        }
    }

    //APplies a bonus to the ore before selling it EX: doubles ore value or adds 10 to ore value.
    protected abstract BigInteger processEffect(BigInteger soldOreValue);

    public String toString() {
        String furnaceInfo = "";
        return furnaceInfo;
    }

}


