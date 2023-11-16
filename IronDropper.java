public class IronDropper extends Dropper{
    public IronDropper() {
        super(2000, oreQueue, 0, 0, "Iron Dropper", 0, 0, Direction.UPWARDS);
    }

    @Override
    protected Ore createOre() {
        return new IronOre();
    }
}
