// The

import java.util.Random;

public class ItemGenerator {
    public enum RewardType {STANDARD_CHEST, LUCKY_CHEST, SUPER_LUCKY_CHEST, RIGGED_CHEST, PRESTIEGE};
    private final long seed = 123;
    private Random generator= new Random();

    public ItemGenerator() {

    }
    public int coinFlip() {
        return generator.nextInt(2); //Heads will be considered 0 and tails will be considered 1;
    }

    public int rangeHundred() {
        return generator.nextInt(101); //returns a number between 0 and 100;
    }

    public Item rewardPrestiegeItem() {

        return new Conveyor();
    }

    public Item rewardItem(RewardType type) {
        switch (type) {
            case STANDARD_CHEST:
                return generateChestItem(75, 24, 1);
            case LUCKY_CHEST:
                return generateChestItem(52, 46,  2);
            case SUPER_LUCKY_CHEST:
                return generateChestItem(1, 75, 24);
            case RIGGED_CHEST:
                return generateChestItem(0,0, 100);
            case PRESTIEGE:
                return new Conveyor();
        }

        return new Conveyor();
    }

    private Item generateChestItem(int shopWeight, int researchWeight, int exoticWeight) {
        int roll = rangeHundred();

        // System.out.println("Roll: " + roll);

        if (roll <= exoticWeight) {
            return new ResetterUpgrader();
        } else if (roll <= researchWeight + exoticWeight) {
            return new GoldDropper();
        } else if (roll <= shopWeight + researchWeight + exoticWeight) {
            return new BasicFurnace();
        }

        return new Conveyor(); //Should never return this....
    }










}
