public class Ore {
    protected long oreValue;
    protected String oreName;
    private boolean isDeleted;
    

    public Ore() {
        this.oreName = "Default Ore(Parent of All)";
        this.oreValue = 1;
        this.isDeleted = false;
    }

    //might not need this.
    public boolean isDeleted() {
        return isDeleted;
    }

    //returns the value of the ore.
    public long getOreValue() {
        return oreValue;
    }

    public String getOreName() {
        return oreName;
    }

    //might not need this.
    public void delete() {
        isDeleted = true;
    }

    //sets the value of the ore. This probably needs work.
    public void setOreValue() {
        oreValue = oreValue + 0;
    }
}
