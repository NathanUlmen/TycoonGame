import java.util.ArrayList;
import java.util.List;

//List of all items in the game.
public class ListOfAllGameItems {
    ArrayList<Item> reasearchItems, shopItems, prestiegeItems, otherItems;
    private static ListOfAllGameItems gameItemsInsance;
    
    
    public static ListOfAllGameItems getGameItemsInstance() {
        if (gameItemsInsance == null) {
            return gameItemsInsance = new ListOfAllGameItems();
        }
        return gameItemsInsance;
    }


    public List<Item> getEligblePrestiegeItems(int playerPrestiegeLevel) {
        int min, max;
        min = max=  0;
        //Measure based on thresholds that new Items are unlocked at. So for example if you unlock new items at prestiege level 20 then you need to add another statement.
        if (playerPrestiegeLevel <= 0) {
            //max = max index of items that player is eligble for. 
            //EX: if my prestiege level is 0, that means that I am eligble to recieve 10 different items which means that my max is now ten.
        } else if ( playerPrestiegeLevel<= 20) {

        }

        //split the list of eligble items
        

        return prestiegeItems.subList(min, max);
    }

    public List<Item> getEligibleResearchItems() {
        int min, max;
        min = max = 0;
        //Dont know how I am going to handle what research Items players are eligble for...

        return reasearchItems.subList(min, max);
    }

    public List<Item> getEligibleShopItems() {
        int min, max;
        min = max = 0;
        //Shop Items that you are eligible for will be based off the "peak/most" amount of money youve obtained this prestiege level.
        
        return shopItems.subList(min, max);
    }

    public void populatePrestiegeItems() {
        prestiegeItems = new ArrayList<>();
        //Will go through and add items, the order they are added in matters, should be orded based on what prestiege level they are unlocked at.
        prestiegeItems.add(new ResetterUpgrader());
    }

    public void populateResearchItems() {
        reasearchItems = new ArrayList<>();

        //Should Make an algorithm to sort this.
        // prestiegeItems.add();
    }

    public void populateShopItems() {
        shopItems = new ArrayList<>();
    }

    public void populateOtherItems() {
        otherItems = new ArrayList<>();
    }

    
}
