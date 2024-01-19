import java.util.ArrayDeque;
import java.util.Queue;

public class Conveyor2 extends Item implements ProcessingItem2 {
    protected Ore ore;
    private ProcessingItem2 itemInFront;
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
        if (itemInFront == null && storedOre.peek() != null) {
            Ore o = storedOre.remove();
            o.reset();
            oreRealm.takeOre(o);
        } else {
            if (storedOre.peek() != null && storedOre.peek().canBeProcessed()) {
                Ore o = storedOre.remove();
                o.setProcessable(false);
                itemInFront.addOre(o);
            }
        }
    }

    @Override
    public void pushToItem() {

    }

    @Override
    public boolean isEmpty() {
        return this.ore == null;
    }

    @Override
    public void morphTo(Item item) {

    }

    @Override
    public void reset() {

    }
}
