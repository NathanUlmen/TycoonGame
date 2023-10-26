public class IronOre extends Ore implements OreInterface {
    
    public IronOre() {
        super();
        this.oreValue = 2;
        this.oreName = "Iron Ore";
    }

    @Override
    public long getValue() {
        return oreValue;
    }


}