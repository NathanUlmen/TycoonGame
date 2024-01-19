import java.math.BigInteger;

public class Conveyor extends ProcessingItem {

    public Conveyor() {
        super(-1, -1, "Conveyor", 2, 2, Direction.UPWARDS, ItemTier.NORMAL, ItemType.CONVEYOR, BigInteger.valueOf(10));
        //TODO Auto-generated constructor stub
    }

    public void move(Ore ore) {

    }

    @Override
    public void process(Ore ore) {
        // System.out.println("Item moved!");
    }

    @Override
    public void morphTo(Item item) {

    }
}
