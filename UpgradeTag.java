//This is the upgradeTag class, it is used to limit the number of times an ore can be upgraded by a specific upgrader type.
public enum UpgradeTag {
    BASIC_UPGRADER(0, 2500, false),
    THE_FINAL_UPGRADER(1, 1, false),
    RENEWAL_FORGE(2,1, true);
    

    private final int maxUpgrades;
    private final int upgradeIndex;
    private final boolean isResetter;

    UpgradeTag(int upgradeIndex, int maxUpgrades, boolean isResetter) {
        this.upgradeIndex = upgradeIndex;
        this.maxUpgrades = maxUpgrades;
        this.isResetter = isResetter;
    }

    public int getMaxUpgrades() {
        return maxUpgrades;
    }

    public int getTagIndex() {
        return upgradeIndex;
    }

    public boolean isResetter() {
        return isResetter;
    }
}
