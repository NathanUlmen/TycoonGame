//The Furnace Class takes an ore and processes it, returning it to the OreRealm and granting you money;
import java.math.BigDecimal;
import java.math.BigInteger;

public abstract class Furnace extends ProcessingItem{
    private final double processSpeed;
    private final String processEffect;
    protected static final OreRealm oreRealm = OreRealm.getOreRealmInstance();
    protected static final Player player = Player.getPlayerInstance();
    private int currentSpecialProgress;
    private final long specialPointsReward;
    protected final int specialThreshold;


    public Furnace(int positionX, int positionY, String itemName, double processSpeed, String processEffect, Player player, Direction direction, int specialPointsReward, int specialThreshold, int currentSpecialProgress) {
        super(positionX, positionY, itemName, positionX, positionY, direction);
        this.processSpeed = processSpeed;
        this.processEffect = processEffect;
        this.specialPointsReward = specialPointsReward;
        this.specialThreshold = specialThreshold;
        // this.oreQueue = oreQueue;

    }

    @Override
    public void process(OreDecorator ore) {
        sell(ore);
    }

    public void sell(OreDecorator ore) {
        Ore preparedOre = ore.prepare();
        // preparedOre.setOreValue(processEffect(preparedOre.getOreValue()));
        //sells ore
        sellTheOre(preparedOre);
        
        // player.addToWallet(preparedOre.getOreValue().toBigInteger().multiply(BigInteger.valueOf(preparedOre.getMultiOre())));
        //Logic for special points
        calculateSpecialPoints(preparedOre);

        preparedOre.reset();
        setStoredOre(null);
        oreRealm.push(preparedOre);
        //System.out.println("Sold!");
    }

    private void sellTheOre(Ore preparedOre) {
        BigDecimal processedValue = processEffect(preparedOre.getOreValue().multiply(BigDecimal.valueOf(preparedOre.getMultiOre())));
        player.addToWallet(processedValue.toBigInteger());
    }

    private void calculateSpecialPoints(Ore preparedOre) {
        int increment = preparedOre.getMultiOre();
        for (int i = 0; i < increment; i++) {
            currentSpecialProgress++;
            if (specialThreshold < currentSpecialProgress) {
                player.setSpecialPoints(player.getSpecialPoints()+specialPointsReward);        
                currentSpecialProgress=0;
            }
        }
    }

    //Applies a bonus to the ore before selling it EX: doubles ore value or adds 10 to ore value.
    protected abstract BigDecimal processEffect(BigDecimal soldOreValue);

    public String toString() {
        String furnaceInfo = "Name: " +getItemName() + "\tEffect: " + processEffect + "\tPosition: X:" + getPositionX() + " Y:" + getPositionY();
        return furnaceInfo;
    }

    

}


