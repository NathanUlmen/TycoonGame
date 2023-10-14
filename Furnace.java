public abstract class Furnace {
    private double oreSellBonus, processSpeed;
    
    protected Furnace(double oreSellBonus, double processSpeed) {
        this.oreSellBonus = oreSellBonus;
        this.processSpeed = processSpeed;
    }

}
