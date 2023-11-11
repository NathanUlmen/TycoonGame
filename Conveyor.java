import java.util.LinkedList;

public abstract class Conveyor extends Item implements ProcessingItem{
    private LinkedList<Ore> oreQueue;

    public void move(Ore ore) {

    }

    @Override
    public void process(Ore ore) {
        move(ore);
    }

}
