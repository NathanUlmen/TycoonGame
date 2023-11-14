import java.util.LinkedList;

public abstract class Conveyor extends ProcessingItem {
    public Conveyor(int positionX, int positionY, String itemName, int dimensionX, int dimensionY, int direction) {
        super(positionX, positionY, itemName, dimensionX, dimensionY, direction);
        //TODO Auto-generated constructor stub
    }

    public void move(Ore ore) {

    }

    @Override
    public void process(Ore ore) {
        move(ore);
    }

}
