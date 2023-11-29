//The Furnace Class takes an ore and processes it, returning it to the OreRealm and granting you money;
import java.math.BigDecimal;

public abstract class Furnace extends ProcessingItem{
    private double processSpeed;
    private String processEffect;
    protected static OreRealm oreRealm = OreRealm.getOreRealmInstance();
    protected static Player player = Player.getPlayerInstance();

    public Furnace(int positionX, int positionY, String itemName, double processSpeed, String processEffect, Player player, Direction direction) {
        super(positionX, positionY, itemName, positionX, positionY, direction);
        this.processSpeed = processSpeed;
        this.processEffect = processEffect;
        // this.oreQueue = oreQueue;
    }

    @Override
    public void process(OreDecorator ore) {
        sell(ore);
    }

    public void sell(OreDecorator ore) {
        Ore preparedOre = ore.prepare();
        preparedOre.setOreValue(processEffect(preparedOre.getOreValue()));
        player.addToWallet(preparedOre.getOreValue().toBigInteger());
        preparedOre.reset();
        setStoredOre(null);
        oreRealm.push(preparedOre);
        System.out.println("Sold!");
    }

    //Applies a bonus to the ore before selling it EX: doubles ore value or adds 10 to ore value.
    protected abstract BigDecimal processEffect(BigDecimal soldOreValue);

    public String toString() {
        String furnaceInfo = "Name: " +getItemName() + "\tEffect: " + processEffect + "\tPosition: X:" + getPositionX() + " Y:" + getPositionY();
        return furnaceInfo;
    }

    

}


