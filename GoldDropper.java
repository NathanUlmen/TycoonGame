public class GoldDropper extends Dropper{
    private String dropperName;
    public GoldDropper(int dropRate) {
        super(dropRate);
        dropRate = 1000;
        dropperName = "Gold Mine";
    }
    
    @Override
    protected Ore createOre() {
        return new GoldOre();
    }
    
}
