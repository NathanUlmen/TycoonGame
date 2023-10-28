public class GoldOre extends Ore implements OreInterface{
    public GoldOre() {
        this.oreName = "Gold Ore";
        this.oreValue = 100;
        
    }

    @Override
    public long getValue() {
        return oreValue;
    }

    @Override
    public void setOreValue() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setOreValue'");
    }
}
