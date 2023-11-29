import java.math.BigDecimal;

public class Ore {
    private BigDecimal oreValue;
    private int oreTemperature, upgradeCount, multiOre, oreHistory;
    private String oreName;


    public Ore() {
        this.oreValue = BigDecimal.valueOf(0);
        this.oreTemperature = 0;
        this.oreName = "";
        this.upgradeCount = 0;
        this.multiOre = 1;
    }

    //
    public void applyUpgrade(BigDecimal oreValueAfterUpgrade, int temperatureAfterUpgrade, int multiOreAfterUpgrade) {
        this.oreValue = oreValueAfterUpgrade;
        this.oreTemperature = temperatureAfterUpgrade;
        this.multiOre = multiOreAfterUpgrade;
    }

    public void applyName(String name) {
        this.oreName = name;
    }

    public void applyTemperature(int temperatureAfterUpgrade) {
        this.oreTemperature = temperatureAfterUpgrade;
    }

    public void applyBaseStats(BigDecimal startingValue, int startingTemp, int StartingMultiOre, String name) {
        this.oreValue = startingValue;
        this.oreName = name;
        this.oreTemperature = startingTemp;
        this.multiOre = StartingMultiOre;
    }
    
    public BigDecimal getOreValue() {
        return oreValue;
    }

    public void setOreValue(BigDecimal newValue) {
        this.oreValue = newValue;
    }

    public int getOreTemp() {
        return this.oreTemperature;
    }
    
    public String getName() {
        return this.oreName;
    }

    public int getUpgradeCount() {
        return upgradeCount;
    }

    public int getMultiOre() {
        return multiOre;
    }

    public void setMultiOre(int newMultiOre) {
        this.multiOre = newMultiOre;
    }

    public int getOreHistory() {
		return oreHistory;
	}

	public void setOreHistory(int oreHistory) {
		this.oreHistory = oreHistory;
	}

    public void reset() {
        this.oreValue = BigDecimal.valueOf(0);
        this.oreTemperature = 0;
        this.oreName = "";
        this.upgradeCount = 0;
        this.multiOre = 0;
    }

    

    public String toString() {
        String bars = " -----------------";
        String oreToString = bars + "\nName: " + oreName + "\nValue: " + oreValue + 
            "\nTemperature: " + oreTemperature + "\nUpgrade Count: " + upgradeCount + 
            "\nState: ";
        return oreToString;
    }
}
