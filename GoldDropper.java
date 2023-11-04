public class GoldDropper extends Dropper{
    public GoldDropper(int dropRate, CircularOreArray<Ore> sharedOreArray) {
        super(1000, sharedOreArray, 0, 0, "Gold Dropper", 0, 0);
    }
    
    @Override
    protected Ore createOre() {
        return new GoldOre();
    }
    
}
