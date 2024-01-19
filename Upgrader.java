import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

public abstract class Upgrader extends ProcessingItem {
    private String upgraderEffect;
    protected Ore ore;
    protected static final MathContext hundreths = new MathContext(5);
    protected UpgradeTag upgradeTag;

    public Upgrader(String upgraderEffect, int positionX, int positionY, String itemName, int dimensionX, int dimensionY, Direction direction, UpgradeTag upgradeTag, ItemTier tier, BigInteger value) {
        super(positionX, positionY, itemName, dimensionX, dimensionY, direction, tier, ItemType.UPGRADER, value);
        this.upgraderEffect = upgraderEffect;
        this.upgradeTag = upgradeTag;
    }

    @Override
    public void process(Ore ore) {
        if (ore.getUpgradeTag(upgradeTag) > 0) {
            upgrade(ore);
            ore.decrementUpgradeTag(upgradeTag);
        }
    }

    protected abstract void upgrade(Ore ore);

    protected abstract BigDecimal upgradeEffect(BigDecimal newOreValue);

    protected abstract int tempChange(int oreTemperature);

    protected abstract int multiOreChange(int multiOre);

    protected boolean canUpgrade(int numberOfUpgrades, int maxUpgrades) {
        return numberOfUpgrades < maxUpgrades;
    }

    public String toString() {
        return "Name: " + getItemName() + "\tPosition: X:" + getPositionX() + " Y:" + getPositionY();
    }


} 