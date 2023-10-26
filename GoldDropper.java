public class GoldDropper extends Dropper{
    public GoldDropper(int dropRate, String dropperName) {
        super(1000, "Gold Mine");
    }
    
    @Override
    protected Ore createOre() {
        return new GoldOre();
    }
    
}
