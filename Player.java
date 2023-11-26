import java.math.BigInteger;

public class Player {
    private int prestigeLevel, prestigeCurrency;
    private BigInteger wallet = BigInteger.valueOf(0);

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

    public String toString() {
        String playerInfo = "Player Prestige Level: " + prestigeLevel + "\nPlayer Money: " + wallet + "\nPlayer Prestige Currency: " + prestigeCurrency;
        return playerInfo;
    }
}
