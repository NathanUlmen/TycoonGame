import java.util.LinkedList;

public abstract class Conveyor extends ProcessingItem {
    public Conveyor(int positionX, int positionY, String itemName, int dimensionX, int dimensionY, Direction direction) {
        super(positionX, positionY, itemName, dimensionX, dimensionY, direction);
        //TODO Auto-generated constructor stub
    }

    public void move(Ore ore) {

    }

    @Override
    public OreDecorator process(OreDecorator ore) {
        return ore;
    }

}
