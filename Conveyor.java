import java.util.LinkedList;

public abstract class Conveyor extends ProcessingItem implements Process{
    private LinkedList<Ore> oreQueue;

    public void move(Ore ore) {

    }

    @Override
    public void process(Ore ore) {
        move(ore);
    }

}
