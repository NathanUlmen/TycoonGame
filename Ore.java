public class Ore {
    protected double oreValue;
    protected String oreName;
    

    // public Ore(String oreName, double oreValue) {
    //     this.oreName = oreName;
    //     this.oreValue = oreValue;
    // }

    public Ore() {
        this.oreName = "Default Ore(Parent of All)";
        this.oreValue = 1;
    }

    public double getOreValue() {
        return this.oreValue;
    }

    public String getOreName() {
        return this.oreName;
    }
}
