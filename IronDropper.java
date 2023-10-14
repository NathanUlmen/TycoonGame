public class IronDropper extends Dropper{
    private String dropperName;
    public IronDropper(int dropRate) {
        super(dropRate);
        dropRate = 5000;
        dropperName = "Iron Mine";
    }

    @Override
    protected Ore createOre() {
        return new IronOre();
    }
}
