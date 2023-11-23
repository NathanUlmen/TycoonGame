//The Furnace Class takes an ore and sells it, getting rid of it and granting you money
import java.math.BigDecimal;

public abstract class Furnace extends ProcessingItem{
    protected static OreRealm oreRealm = new OreRealm();
    Ore ore;
    private double processSpeed;
    private String processEffect;
    
    protected static Player player;

    public Furnace(int positionX, int positionY, String itemName, double processSpeed, String processEffect, Player player, Direction direction) {
        super(positionX, positionY, itemName, positionX, positionY, direction);
        this.processSpeed = processSpeed;
        this.processEffect = processEffect;
        // this.oreQueue = oreQueue;
        this.player = player;
    }

    @Override
    public OreDecorator process(OreDecorator ore) {
        sell(ore);
        return null;
    }

    public void sell(OreDecorator ore) {
        if (ore != null) {
            Ore preparedOre = ore.prepare();
            preparedOre.setOreValue(processEffect(preparedOre.getOreValue()));
            player.addToWallet(preparedOre.getOreValue().toBigInteger());
            preparedOre.reset();
            setStoredOre(null);
            oreRealm.enqueue(preparedOre);
            System.out.println("Sold!");
        }
        

    }

    //Should remove the ore from the circularOreArray and sell it/add the ore value to your wallet
    // public void sell(OreD ore) {
    //     if (!ore.isDeleted()) {
    //         BigInteger soldOreValue = ore.getOreValue();
    //         ore.setOreValue(processEffect(soldOreValue));
    //         player.setWallet(ore.getOreValue());
    //         ore.delete();
    //         System.out.println(ore.getOreName() + " sold for: " + ore.getOreValue());

    //         //When an ore is sold its value should be added to your wallet, it should be reset to a defualt 
    //         //ore and it should be added back into the "Ore Realm".
    //     }
    // }

    //APplies a bonus to the ore before selling it EX: doubles ore value or adds 10 to ore value.
    protected abstract BigDecimal processEffect(BigDecimal soldOreValue);

    public String toString() {
        String furnaceInfo = "";
        return furnaceInfo;
    }

    

}


