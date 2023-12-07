import java.math.BigDecimal;

public class Ore {
    private BigDecimal oreValue;
    private int oreTemperature, upgradeCount, multiOre, oreHistory;
    private String oreName;
    private int[] upgradeTag = new int[400]; //The number of different upgraders in the game.
    private UpgradeTag upgradeTags;

    public Ore() {
        this.oreValue = BigDecimal.valueOf(0);
        this.oreTemperature = 0;
        this.oreName = "";
        this.upgradeCount = 0;
        this.multiOre = 1;
        setDefualtTags();
    }

    public void applyUpgrade(BigDecimal oreValueAfterUpgrade, int temperatureAfterUpgrade, int multiOreAfterUpgrade) {
        this.oreValue = oreValueAfterUpgrade;
        this.oreTemperature = temperatureAfterUpgrade;
        this.multiOre = multiOreAfterUpgrade;
        this.upgradeCount++;
    }

    public void applyBaseStats(BigDecimal startingValue, int startingTemp, int StartingMultiOre, String name) {
        this.oreValue = startingValue;
        this.oreName = name;
        this.oreTemperature = startingTemp;
        this.multiOre = StartingMultiOre;
    }


    public int getUpgradeTag(UpgradeTag tag) {
        return upgradeTag[tag.getTagIndex()];
    }

    public void decrementUpgradeTag(UpgradeTag tag) {
        if (upgradeTag[tag.getTagIndex()] > 0) {
            upgradeTag[tag.getTagIndex()]--;
        }
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
        setDefualtTags();
    }

    public void resetNonResetterTags() {
        for (UpgradeTag tag : UpgradeTag.values()) {
            if (!tag.isResetter()) {
                setUpgradeTag(tag);
            }
        }
    }

    public void setDefualtTags() {
        for (UpgradeTag tag: UpgradeTag.values()) {
            setUpgradeTag(tag);
        }
    }

    private void setUpgradeTag(UpgradeTag tag) {
        upgradeTag[tag.getTagIndex()] = tag.getMaxUpgrades();
    }

    public String toString() {
        String bars = " -----------------";
        String oreToString = bars + "\nName: " + oreName + "\nValue: " + oreValue + 
            "\nTemperature: " + oreTemperature + "\nUpgrade Count: " + upgradeCount + 
            "\nState: ";
        return oreToString;
    }
}
