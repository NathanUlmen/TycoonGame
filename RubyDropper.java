public class RubyDropper extends Dropper{

    public RubyDropper(int dropRate, String dropperName) {
        super(dropRate);
        //TODO Auto-generated constructor stub
    }

    @Override
    protected Ore createOre() {
        return new RubyOre();
    }
    
}
