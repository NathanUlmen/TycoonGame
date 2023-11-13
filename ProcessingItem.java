public class ProcessingItem extends Item {
    private Ore storedOre;
    
    public ProcessingItem(int positionX, int positionY, String itemName, int dimensionX, int dimensionY, int direction) {
        super(positionX, positionY, itemName, dimensionX, dimensionY, direction);
    }

    //This method should call another method 
    // public void attemptProcess(Ore ore) {
    //     if () {
            
    //     }
    // }

    public void setCurrentOre(Ore ore) {
        this.storedOre = ore;
    }

    public Ore getStoredOre() {
        return storedOre;
    }

    public boolean isOreStored() {
        return storedOre != null;
    }

    public void moveOre() {
        if (isOreStored()) {
            
        }
    }

    public void nextOre() {
        
    }


}
