public class IronDropper extends Dropper{
    public IronDropper(int dropRate) {
        super(dropRate);
        dropRate = 5000;
    }

    @Override
    protected Ore createOre() {
        return new IronOre();
    }
}
