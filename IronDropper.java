public class IronDropper extends Dropper{
    public IronDropper(int dropRate, String dropperName) {
        super(2000, "Iron Mine");
    }

    @Override
    protected Ore createOre() {
        return new IronOre();
    }
}
