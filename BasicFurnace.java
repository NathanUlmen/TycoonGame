public class BasicFurnace extends Furnace{

    public BasicFurnace(double processSpeed) {
        super(5, "Basic Furnace");
        //TODO Auto-generated constructor stub
    }

    @Override
    protected long processEffect(Ore ore) {
        long earnings = ore.getOreValue() + 0;
        return earnings;
    }
    
}
