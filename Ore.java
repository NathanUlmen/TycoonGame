import java.math.BigInteger;

public abstract class Ore {
    protected BigInteger oreValue;
    protected String oreName;
    private boolean isDeleted;
    private UpgradeTags LatestUpgradeTag = UpgradeTags.UNUPGRADED_TAG;
    private UpgradeTags[] upgradeTagArray = new UpgradeTags[3];
    private int nextOpenSlot = 0;
    private int orePositionX, orePositionY;

    public Ore() {
        this.oreName = "Default Ore(Parent of All)";
        this.oreValue = oreValue;
        this.isDeleted = false;
    }

    // public int getOrePositionX() {
    //     return orePositionX;
    // }

    // public int getOrePositionY() {
    //     return orePositionY;
    // }

    // public void setPositionX(int newX) {
    //     orePositionX = newX;
    // }

    // public void setPositionY(int newY) {
    //     orePositionY = newY;
    // }

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

    //returns the upgrade tag
    public UpgradeTags hasUpgradeTag(UpgradeTags searchedTag) {
        for (int i = 0; i < upgradeTagArray.length; i++) {
            if (upgradeTagArray[i] == searchedTag) {
                return upgradeTagArray[i];
            }
        }
        return null;
    }

    //adds an upgrade tag.
    public void addUpgradeTag(UpgradeTags upgradeTags) {
        upgradeTagArray[nextOpenSlot] = upgradeTags;
    }

    //gets the ores upgrade tag array.
    public UpgradeTags[] getUpgradeTagArray() {
        return upgradeTagArray;
    }
    
    public String toString() {
        String oreInfo = "Ore Name: " + oreName + "\nOre Value: " + oreValue + "Ore State: " + isDeleted;
        return oreInfo;
    }
}
