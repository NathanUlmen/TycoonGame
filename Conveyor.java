import java.util.LinkedList;

public abstract class Conveyor extends ProcessingItem implements Process{
    public Conveyor(int positionX, int positionY, String itemName, int dimensionX, int dimensionY, int direction) {
        super(positionX, positionY, itemName, dimensionX, dimensionY, direction);
        //TODO Auto-generated constructor stub
    }

    private LinkedList<Ore> oreQueue;

    public void move(Ore ore) {

    }

    @Override
    public void process(Ore ore) {
        move(ore);
    }

}
