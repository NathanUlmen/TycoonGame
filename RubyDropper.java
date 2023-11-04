public class RubyDropper extends Dropper{

    public RubyDropper(int dropRate, CircularOreArray<Ore> sharedOreArray) {
        super(1000, sharedOreArray, 0, 0, "Ruby Dropper", 0, 0);
        
    }

    @Override
    protected Ore createOre() {
        return new RubyOre();
    }
    
}
