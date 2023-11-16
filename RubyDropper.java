

public class RubyDropper extends Dropper{

    public RubyDropper() {
        super(1000, oreQueue, 0, 0, "Ruby Dropper", 0, 0, Direction.UPWARDS);
        
    }

    @Override
    protected Ore createOre() {
        return new RubyOre();
    }
    
}
