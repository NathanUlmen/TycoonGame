import java.math.BigDecimal;

public class Ore {
    private BigDecimal oreValue;
    private int oreTemperature, upgradeCount;
    private String oreName;
    private boolean isDeleted;

    public Ore() {
        this.oreValue = BigDecimal.valueOf(0);
        this.oreTemperature = 0;
        this.oreName = "";
        this.isDeleted = false;
        this.upgradeCount = 0;
    }

    //
    public void applyUpgrade(BigDecimal oreValueAfterUpgrade, int temperatureAfterUpgrade) {
        this.oreValue = oreValueAfterUpgrade;
        this.oreTemperature = temperatureAfterUpgrade;
    }

    public void applyName(String name) {
        this.oreName = name;
    }

    public void applyTemperature(int temperatureAfterUpgrade) {
        this.oreTemperature = temperatureAfterUpgrade;
    }

    public void applyBaseStats(BigDecimal startingValue, int startingTemp, String name) {
        this.oreValue = startingValue;
        this.oreName = name;
        this.oreTemperature = startingTemp;
    }
    
    public BigDecimal getOreValue() {
        return oreValue;
    }

    public void setOreValue(BigDecimal newValue) {
        this.oreValue = newValue;
    }

    public int getOreTemp() {
        return oreTemperature;
    }
    
    public String getName() {
        return oreName;
    }
    
    public void delete() {
        isDeleted = true;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public int getUpgradeCount() {
        return upgradeCount;
    }

    public void reset() {
        this.oreValue = BigDecimal.valueOf(0);
        this.oreTemperature = 0;
        this.oreName = "";
        this.isDeleted = false;
        this.upgradeCount = 0;
    }

    public String toString() {
        String bars = " -----------------";
        String oreToString = bars + "\nName: " + oreName + "\nValue: " + oreValue + 
            "\nTemperature: " + oreTemperature + "\nUpgrade Count: " + upgradeCount + 
            "\nState: " + isDeleted + "\n";
        return oreToString;
    }
}
