import java.math.BigInteger;

public class Ore {
    protected BigInteger oreValue;
    protected String oreName;
    private boolean isDeleted;
    

    public Ore() {
        this.oreName = "Default Ore(Parent of All)";
        this.oreValue = oreValue;
        this.isDeleted = false;
    }

    //might not need this.
    public boolean isDeleted() {
        return isDeleted;
    }

    //returns the value of the ore.
    public BigInteger getOreValue() {
        return oreValue;
    }

    public String getOreName() {
        return oreName;
    }

    //might not need this.
    public void delete() {
        isDeleted = true;
    }

    //sets the value of the ore from an upgrader. This probably needs work.
    public void setOreValue(BigInteger newOreValue) {
        oreValue = newOreValue;
    }

    public String toString() {
        String oreInfo = "Ore Name: " + oreName + "\nOre Value: " + oreValue + "Ore State: " + isDeleted;
        return oreInfo;
    }
}
