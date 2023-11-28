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
        wallet = wallet.add(oreValue);
    }

    public BigInteger getWallet() {
        return wallet;
    }

    public void setPrestigeLevel(){
        prestigeLevel ++;
    }

    public int getPrestigeLevel(){
        return prestigeLevel;
    }

    public void setPrestigeCurrency(){
        prestigeCurrency =1;
    }

    public int getPrestigeCurrency() {
        return prestigeCurrency;
    }

    public static Player getPlayerInstance() {
        if(playerInstance == null) {
            playerInstance = new Player();
        }
        return playerInstance;
    }

    public String toString() {
        String playerInfo = "Prestige Level: " + prestigeLevel + "\nWallet: " + wallet + "\nPlayer Prestige Currency: " + prestigeCurrency;
        return playerInfo;
    }


}
