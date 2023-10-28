public class RubyDropper extends Dropper{

    public RubyDropper(int dropRate, String dropperName, CircularOreArray<Ore> sharedOreArray) {
        super(100, "Ruby Mine", sharedOreArray);
        
    }

    @Override
    protected Ore createOre() {
        return new RubyOre();
    }
    
}
