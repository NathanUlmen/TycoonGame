//This is used to see if an ore has been upgraded by a specific upgrader via a bitwise, bit must follow binary(1, 2, 4, 8, 16, 32, 64, 128, etc.)

public enum OreHistory {
    RENEWAL_FORGE(1), FIRE(2), AIR(4);

    private final int bit;

    OreHistory(int bit) {
        this.bit = bit;
    }

    public boolean wasUpgraded(Ore ore) {
        return (ore.getOreHistory() & bit) == bit;
    }

    public void add(Ore ore) {
        if (this.wasUpgraded(ore)) {
            return;
        } // already upgraded with this upgrader
        ore.setOreHistory(ore.getOreHistory() + bit);
    }
}
