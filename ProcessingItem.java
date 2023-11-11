public class ProcessingItem extends Item {
    private Ore storedOre;
    
    public ProcessingItem() {
        super();
    }

    //This method should call another method 
    public void attemptProcess(Ore ore) {
        if () {
            
        }
    }

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
        if (storedOre != null) {
            
        }
    }

    public void nextOre() {
        
    }


}
