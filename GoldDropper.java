public class GoldDropper extends Dropper{
    public GoldDropper(int dropRate, String dropperName, CircularOreArray<Ore> sharedOreArray) {
        super(1000, "Gold Mine", sharedOreArray);
    }
    
    @Override
    protected Ore createOre() {
        return new GoldOre();
    }
    
}
