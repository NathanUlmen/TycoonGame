// The

import java.util.List;
import java.util.Random;

public class ItemGenerator {
    public enum RewardType {STANDARD_CHEST, LUCKY_CHEST, SUPER_LUCKY_CHEST, RIGGED_CHEST, PRESTIEGE};
    private static Player player = Player.getPlayerInstance();
    private static ListOfAllGameItems listOfGameItems = ListOfAllGameItems.getGameItemsInstance();
    private final long seed = 123;
    private Random generator= new Random();

    public ItemGenerator() {
        System.exit(0);
    }

    public int coinFlip() {
        return generator.nextInt(2); //Heads will be considered 0 and tails will be considered 1;
    }

    public int rangeHundred() {
        return generator.nextInt(101); //returns a number between 0 and 100;
    }

    public Item rewardItem(RewardType type) {
        switch (type) {
            case STANDARD_CHEST:
                return rewardChestItem(75, 24, 1);
            case LUCKY_CHEST:
                return rewardChestItem(52, 46,  2);
            case SUPER_LUCKY_CHEST:
                return rewardChestItem(1, 75, 24);
            case RIGGED_CHEST:
                return rewardChestItem(0,0, 100);
            case PRESTIEGE:
                return rewardPrestiegeItem();
        }
        return null;
    }

    private Item rewardChestItem(int shopWeight, int researchWeight, int exoticWeight) {
        if (exoticWeight == 100) {
            //logic for Rigged Chest
        }
        int roll = rangeHundred();

        // System.out.println("Roll: " + roll);

        if (roll <= exoticWeight) {
            return new ResetterUpgrader();
        } else if (roll <= researchWeight + exoticWeight) {
            return new GoldDropper();
        } else if (roll <= shopWeight + researchWeight + exoticWeight) {
            return new BasicFurnace();
        }
        return new Conveyor();
    }

    public Item rewardPrestiegeItem() {
        //Get List of Available Prestiege Items from game List by passing in player prestige level.
        List<Item> eligbleItems = listOfGameItems.getEligblePrestiegeItems(player.getPrestigeLevel());
        return eligbleItems.get(generator.nextInt(eligbleItems.size()));
        
    }

}
