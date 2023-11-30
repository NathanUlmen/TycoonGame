import java.math.BigInteger;

public class Player {
    private int prestigeLevel, prestigeCurrency;
    private long specialPoints;
    private BigInteger wallet = BigInteger.valueOf(0);
    private static Player playerInstance;

    

    public Player(BigInteger wallet, int prestigeLevel, int prestigeCurrency) {
        this.wallet = wallet;
        this.prestigeLevel = prestigeLevel;
        this.prestigeCurrency = prestigeCurrency;
    }

    public Player() {
        
    }

    public void addToWallet(BigInteger oreValue) {
        wallet.add(oreValue);
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

    public String toString() {
        String playerInfo = "Prestige Level: " + prestigeLevel + "\tWallet: " + wallet + "\tPlayer Prestige Currency: " + prestigeCurrency + "\tSpecial Points: " + specialPoints;
        return playerInfo;
    }


}
