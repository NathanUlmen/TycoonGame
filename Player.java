import java.math.BigInteger;

public class Player {
    private int prestigeLevel, prestigeCurrency;
    private long specialPoints;
    private BigInteger wallet = BigInteger.valueOf(0);
    private BigInteger mostMoneyObtained = BigInteger.valueOf(0);
    private static Player playerInstance;
    public static Inventory inventory = Inventory.getInventoryInstance();
    private long numberOfTicks = 0;
    protected static TheShop shopInstance = TheShop.getShopInstance();

    public Player(BigInteger wallet, int prestigeLevel, int prestigeCurrency) {
        this.wallet = wallet;
        this.prestigeLevel = prestigeLevel;
        this.prestigeCurrency = prestigeCurrency;
    }

    public Player() {
        
    }
    

    public void addToWallet(BigInteger value) {
        wallet = wallet.add(value);
        mostMoneyObtainedCheck();
    }

    public void subtractFromWallet(BigInteger value) {
        wallet = wallet.subtract(value);
    }

    public void setWallet(BigInteger valueToSetTo)  {
        wallet = valueToSetTo;
        mostMoneyObtainedCheck();
    }

    private void mostMoneyObtainedCheck() {
        if (mostMoneyObtained.compareTo(wallet) == -1) {
            mostMoneyObtained = wallet;
        }
    }

    public BigInteger getWallet() {
        return wallet;
    }

    public BigInteger getMostMoneyObtained() {
        return mostMoneyObtained;
    }

    public Inventory getInventory() {
        return inventory;
    }
    public void incrementPrestigeLevel(){
        prestigeLevel++;
    }

    public int getPrestigeLevel(){
        return prestigeLevel;
    }

    public void setPrestigeLevel(int newPrestigeLevel) {
        this.prestigeLevel = newPrestigeLevel;
    }

    public void setPrestigeCurrency(){
        prestigeCurrency =1;
    }

    public int getPrestigeCurrency() {
        return prestigeCurrency;
    }

    public void setSpecialPoints(long newSpecialPointsValue) {
        this.specialPoints = newSpecialPointsValue;
    }

    public long getSpecialPoints() {
        return specialPoints;
    }

    public void buyItem(Item itemToBeBought) {
        inventory.addItem(shopInstance.sellToPlayer(itemToBeBought), 1);
    }

    public void sellItem(Item itemToBeSold) {
        if (inventory.hasItem(itemToBeSold)) {
            inventory.removeItem(itemToBeSold);
            shopInstance.buyItemFromPlayer(itemToBeSold);
        }
    }



    public static Player getPlayerInstance() {
        if(playerInstance == null) {
            playerInstance = new Player();
        }
        return playerInstance;
    }

    public void incrementTicks() {
        numberOfTicks++;
    }

    public long getNumberOfTicks() {
        return numberOfTicks;
    }

    public String toString() {
        String playerInfo = "Prestige Level: " + prestigeLevel + "\tWallet: " + wallet + "\tPlayer Prestige Currency: " + prestigeCurrency + "\tSpecial Points: " + specialPoints;
        return playerInfo;
    }

    


}
