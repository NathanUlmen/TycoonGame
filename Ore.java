import java.math.BigInteger;

public abstract class Ore extends Item implements Observer{
    protected static BigInteger oreValue;
    protected String oreName;
    private boolean isDeleted;
    private UpgradeTags LatestUpgradeTag = UpgradeTags.UNUPGRADED_TAG;
    private UpgradeTags[] upgradeTagArray = new UpgradeTags[3];
    private int nextOpenSlot = 0;
    protected static Subject oreObserver = new OreObserver();
    

    public Ore(Subject oreObserver, BigInteger oreValue, int positionX, int positionY, String itemName, int dimensionX, int dimensionY) {
        super(positionX, positionY, itemName, dimensionX, dimensionY);
        this.oreObserver = oreObserver;
        oreObserver.registerObserver(this);
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


    @Override
    public void update(Ore ore) {
        
        
    }

}
