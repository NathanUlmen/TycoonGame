import java.util.ArrayDeque;
import java.util.Queue;

public class Furnace2 extends Item implements ProcessingItem2 {
    protected Ore ore;
    private Queue<Ore> storedOre = new ArrayDeque<>(Constants.STORED_ORE_LIMIT);
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
       for (Ore ore: storedOre) {
           sell(ore);
           storedOre.remove(ore);
       }
    }

    public void sell(Ore ore) {

    }

    @Override
    public void pushToItem() {

    }

    @Override
    public boolean isEmpty() {
        return this.ore == null;
    }
}
