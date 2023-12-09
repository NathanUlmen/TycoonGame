import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Player {
    private int prestigeLevel, prestigeCurrency;
    private long specialPoints;
    private BigInteger wallet = BigInteger.valueOf(0);
    private static Player playerInstance;
    private List<Stack<Item>> inventory = new ArrayList<>();
    private Stack<Item> stackOfItems = new Stack<>();
    private long numberOfTicks = 0;

    public Player(BigInteger wallet, int prestigeLevel, int prestigeCurrency) {
        this.wallet = wallet;
        this.prestigeLevel = prestigeLevel;
        this.prestigeCurrency = prestigeCurrency;
    }

    public Player() {
        
    }
    //Method to addItem to inventory
    public void addItem(Item item, int quantity) {
        for (Stack<Item> stack : inventory) {
            if (stack.peek().equals(item)) {
                for (int i = 0; i < quantity; i++) {
                    stack.push(item);
                }
                return;
            }
        }
    }
    //Method to removeItem from inventory
    public void removeItem(Item item) {
        for (Stack<Item> stack : inventory) {
            if (stack.peek().equals(item)) {
                stack.pop();
                return;
            }
        }
    }

    public void addToWallet(BigInteger oreValue) {
        wallet = wallet.add(oreValue);
    }

    public BigInteger getWallet() {
        return wallet;
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
