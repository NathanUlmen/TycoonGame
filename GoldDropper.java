public class GoldDropper extends Dropper{
    public GoldDropper(int dropRate) {
        super(dropRate);
        dropRate = 1000;
    }
    
    @Override
    protected Ore createOre() {
        return new GoldOre();
    }
    
}
