public class Ore {
    protected long oreValue;
    protected String oreName;
    private boolean isDeleted;
    

    // public Ore(String oreName, double oreValue) {
    //     this.oreName = oreName;
    //     this.oreValue = oreValue;
    // }

    public Ore() {
        this.oreName = "Default Ore(Parent of All)";
        this.oreValue = 1;
        this.isDeleted = false;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public long getOreValue() {
        return this.oreValue;
    }

    public String getOreName() {
        return this.oreName;
    }

    public void delete() {
        isDeleted = true;
    }
}
