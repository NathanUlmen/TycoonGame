public class GoldDropper extends Dropper{
    public GoldDropper() {
        super(1000, oreQueue, 0, 0, "Gold Dropper", 0, 0, Direction.UPWARDS);
    }
    
    @Override
    protected Ore createOre() {
        return new GoldOre();
    }
    
}
