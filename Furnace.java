public abstract class Furnace {
    private double processSpeed;
    private static Wallet sharedWallet;

    public Furnace(double processSpeed, String furnaceName) {
        this.processSpeed = processSpeed;
    }

    public static void setSharedWallet(Wallet wallet) {
        sharedWallet = wallet;
    }

    public void sell(Ore ore) {
        if (ore != null && !ore.isDeleted()) {
            long sellValue = processEffect(ore);
            if (sharedWallet != null) {
                sharedWallet.addToWallet(sellValue);
                ore.delete(); // Delete the ore
            } else {
                System.out.println("Shared wallet not set. Cannot add earnings.");
            }
        } else {
            System.out.println("No ore to be sold.");
        }
    }

    protected abstract long processEffect(Ore ore);

    // public void resetEarnings() {
    //     // You can reset earnings or the shared wallet balance here
    //     if (sharedWallet != null) {
    //         sharedWallet.resetBalance();
    //     }
    // }
}

    // private void addToWallet(long sellValue) {
    //     addToWallet(sellValue);
    // }

    // public void resetEarnings() {
    //     earnings = 0;
    // }

    // public long getEarnings() {
    //     return earnings;
    // }

    // public String getFurnaceName() {
    //     return furnaceName;
    // }

    // private void addToEarnings(long earningsFromSale) {
    //     earnings += earningsFromSale;
    // }


