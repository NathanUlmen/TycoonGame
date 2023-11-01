import java.math.BigInteger;

public abstract class Upgrader {
    private String upgraderName;
    private String upgraderEffect;
    protected CircularOreArray<Ore> sharedOreArray;

    public Upgrader(String upgraderName, String upgraderEffect, CircularOreArray<Ore> sharedOreArray) {
        this.sharedOreArray = sharedOreArray;
        this.upgraderName = upgraderName;
        this.upgraderEffect = upgraderEffect;
    }
    //this will upgrade the ore, still need to figure out how to make the sharedOreArray.get() automated so I dont have to set it manually. 
    public void upgrade(Ore ore) {
        ore = sharedOreArray.get(1);
        BigInteger newOreValue = ore.getOreValue();
        upgradeEffect(newOreValue);
        ore.setOreValue(upgradeEffect(newOreValue));
    }
    
    //the specific upgrade effect will vary depending on the upgrader.
    protected BigInteger upgradeEffect(BigInteger newOreValue) {
        newOreValue= newOreValue.add(BigInteger.valueOf(1));
        return newOreValue;
    }

    // 
    public void addUpgradeTag() {

    }

    //
    public String toString() { 
        String upgraderInfo = "Upgrader Name: " + upgraderName + "\nUpgrader Effect: Increases ore value by " + upgraderEffect;
        return upgraderInfo;
    }
} 