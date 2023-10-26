public class GoldOre extends Ore implements OreInterface{
    public GoldOre() {
        this.oreName = "Gold Ore";
        this.oreValue = 100;
        
    }

    @Override
    public long getValue() {
        return oreValue;
    }
}
