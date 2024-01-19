import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Furnace2 extends Item implements ProcessingItem2 {
    private int currentSpecialProgress;
    private final long specialPointsReward;
    protected final int specialThreshold;

    protected Ore ore;
    private ArrayList<Ore> storedOre = new ArrayList<>(Constants.STORED_ORE_LIMIT);

    protected Player player = Player.getPlayerInstance();

    public Furnace2(String name, String description, String itemValue, String itemTier, long specialPointsReward, int specialThreshold) {
        this.specialPointsReward = specialPointsReward;
        this.specialThreshold = specialThreshold;
    }

    @Override
    public void setStoredOre(Ore oreToBeStored) {
        this.ore = oreToBeStored;
    }

    @Override
    public void addOre(Ore ore) {
        storedOre.add(ore);
    }

    @Override
    public void processOre() {
        for (Ore ore : storedOre) {
            sell(ore);
            ore.reset();
            oreRealm.takeOre(ore);
            storedOre.remove(ore);
        }
    }

    public void sell(Ore ore) {
        BigDecimal processedValue = processEffect(ore.getOreValue().multiply(BigDecimal.valueOf(ore.getMultiOre())));
        player.addToWallet(processedValue.toBigInteger());

    }

    public void calculateSpecialPoints(Ore preparedOre) {
        int increment = preparedOre.getMultiOre();
        for (int i = 0; i < increment; i++) {
            currentSpecialProgress++;
            if (specialThreshold < currentSpecialProgress) {
                player.setSpecialPoints(player.getSpecialPoints() + specialPointsReward);
                currentSpecialProgress = 0;
            }
        }
    }

    public BigDecimal processEffect(BigDecimal value) {

        return null;
    }

    @Override
    public void pushToItem() {

    }

    @Override
    public boolean isEmpty() {
        return this.ore == null;
    }
}
