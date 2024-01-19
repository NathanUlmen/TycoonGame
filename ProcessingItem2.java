import java.util.ArrayDeque;
import java.util.Queue;

public interface ProcessingItem2 {
    void setStoredOre(Ore oreToBeStored);

    void addOre(Ore ore);

    public void processOre();

    public void pushToItem();

    public boolean isEmpty();

}
