public class Wallet {
    private long balance;

    public Wallet() {
        this.balance = 0;
    }

    public void addToWallet(long sellValue) {
        balance += sellValue;
    }

    public void subtractFromWallet(long purchaseCost) {
        balance -= purchaseCost;
    }

    public long getBalance() {
        return balance;
    }

    public void resetBalance() {
        
    }
}