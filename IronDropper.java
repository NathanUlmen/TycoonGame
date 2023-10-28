public class IronDropper extends Dropper{
    public IronDropper(int dropRate, String dropperName, CircularOreArray<Ore> sharedOreArray) {
        super(2000, "Iron Mine", sharedOreArray);
    }

    @Override
    protected Ore createOre() {
        return new IronOre();
    }
}
