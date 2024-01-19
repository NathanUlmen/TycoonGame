import java.math.BigInteger;

public class TheShop {
    private static ListOfAllGameItems allGameItems = ListOfAllGameItems.getGameItemsInstance();
    private static Player playerInstance = Player.getPlayerInstance();

    private static TheShop theShop;


    public TheShop() {

    }

    public static TheShop getShopInstance() {
        if (theShop == null) {
            return theShop = new TheShop();
        } else {
            return theShop;
        }
    }

    public Item sellToPlayer(Item itemToBeSold) {
        if (playerInstance.getWallet().compareTo(itemToBeSold.getValue()) == 1) {
            playerInstance.subtractFromWallet(itemToBeSold.getValue());
        }
        return itemToBeSold;//Might be an error here....
    }

    public void buyItemFromPlayer(Item toBeBought) {
        if (0 == 0) {

        }
        playerInstance.addToWallet(toBeBought.getValue().divide(BigInteger.valueOf(2)));
    }

}
