public class RubyDropper extends Dropper{

    public RubyDropper(int dropRate, String dropperName) {
        super(2000, "Ruby Mine");
        
    }

    @Override
    protected Ore createOre() {
        return new RubyOre();
    }
    
}
