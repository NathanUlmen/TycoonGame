import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.Queue;

public class Upgrader2 extends Item implements ProcessingItem2{
    protected Ore ore;
    ProcessingItem2 itemInFront;
    private Queue<Ore> storedOre = new ArrayDeque<>(Constants.STORED_ORE_LIMIT);

    private int numberToMove =1;
    protected UpgradeTag upgradeTag;
//    private Upgrade upgrade;
    @Override
    public void setStoredOre(Ore oreToBeStored) {

    }

    @Override
    public void addOre(Ore ore) {
        storedOre.add(ore);
    }

    //Unfinished.
    @Override
    public void processOre() {
        for (int i = 0; i < numberToMove; i++) {
            if (storedOre.peek() != null) {
                if (itemInFront == null) {
                    Ore oreToBeMoved = storedOre.remove();
                    oreToBeMoved.reset();
                    oreRealm.takeOre(oreToBeMoved);
                    setStoredOre(null);
                } else {
                    upgradeAndMove();
                }
            }
        }
    }

    private void upgradeAndMove() {
        if (storedOre.peek() != null && storedOre.peek().canBeProcessed()) {
            Ore oreToBeMoved = storedOre.remove();
            if (oreToBeMoved.getUpgradeTag(upgradeTag) > 0) {
                upgrade(oreToBeMoved);
                oreToBeMoved.decrementUpgradeTag(upgradeTag);
            }
            oreToBeMoved.setProcessable(false);
            itemInFront.addOre(oreToBeMoved);
        }
    }

    @Override
    public void pushToItem() {
        if (itemInFront != null && itemInFront.isEmpty() && ore.canBeProcessed()) {
            ore.setProcessable(false);
            itemInFront.setOre(this.ore);
            setStoredOre(null);
        }
    }
    @Override
    public boolean isEmpty() {
        return this.ore == null;
    }
    public void upgrade(Ore ore) {
//        upgrade.upgrade(this.ore);
        ore.applyUpgrade(upgradeEffect(this.ore.getOreValue()));
    }
    public BigDecimal upgradeEffect(BigDecimal oreValue) {
        return oreValue.add(BigDecimal.valueOf(1));
    }

}
