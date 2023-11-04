public class IronDropper extends Dropper{
    public IronDropper(int dropRate, CircularOreArray<Ore> sharedOreArray) {
        super(2000, sharedOreArray, 0, 0, "Iron Dropper", 0, 0);
    }

    @Override
    protected Ore createOre() {
        return new IronOre();
    }
}
