public class RubyDropper extends Dropper{

    public RubyDropper(int dropRate, String dropperName) {
        super(dropRate);
        
    }

    @Override
    protected Ore createOre() {
        return new RubyOre();
    }
    
}
