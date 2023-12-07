import java.math.BigDecimal;
import java.math.MathContext;

public abstract class Upgrader extends ProcessingItem implements OreDecorator{
    private String upgraderEffect;
    protected Ore ore;
    protected OreDecorator internal;
    protected static final MathContext hundreths = new MathContext(5);
    protected UpgradeTag upgradeTag;

    public Upgrader(String upgraderEffect, int positionX, int positionY, String itemName, int dimensionX, int dimensionY, Direction direction, UpgradeTag upgradeTag, ItemTier tier) {
        super(positionX, positionY, itemName, dimensionX, dimensionY, direction, tier);
        this.upgraderEffect = upgraderEffect;
        this.upgradeTag = upgradeTag;
    }

    public Upgrader(OreDecorator addition) {
        this.internal = addition;
        this.ore = null;
    }

    public Upgrader(Ore ore) {
        this.ore = ore;
        this.internal = null;   
    }
    
    @Override
    public void process(OreDecorator ore) {
        if (ore.prepareTags().getUpgradeTag(upgradeTag) > 0)  {
            upgrade(ore);
            ore.prepareTags().decrementUpgradeTag(upgradeTag);
        }
    }

    @Override
    public Ore prepare() {
        Ore result = (ore != null) ? ore : internal.prepare();
        // if (upgradeable) {
            result.applyUpgrade(upgradeEffect(result.getOreValue()), tempChange(result.getOreTemp()), multiOreChange(result.getMultiOre()));
        // }
        return result;
    }

    @Override
    public Ore prepareTags() {
        Ore result = (ore != null) ? ore : internal.prepareTags();
        return result;
    }

    protected abstract void upgrade(OreDecorator ore);

    protected abstract BigDecimal upgradeEffect(BigDecimal newOreValue);

    protected abstract int tempChange(int oreTemperature);

    protected abstract int multiOreChange(int multiOre);

    protected boolean canUpgrade(int numberOfUpgrades ,int maxUpgrades) {
        return numberOfUpgrades < maxUpgrades;
    }

    public String toString() { 
        return "Name: " + getItemName() + "\tEffect: Increases ore value by " + upgraderEffect + "\tPosition: X:" + getPositionX() + " Y:" + getPositionY();
    }
   
} 