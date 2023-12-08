public interface OreDecorator {

    Ore prepare();

    Ore prepareTags();

    int getUpgradeTag(UpgradeTag tag);

    void decrementUpgradeTag(UpgradeTag tag);

    // int getUpgradeCount();

}
