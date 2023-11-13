public abstract class ProcessingItem extends Item{
    private Ore storedOre;
    private ProcessingItem itemToPullFrom;
    
    public ProcessingItem(int positionX, int positionY, String itemName, int dimensionX, int dimensionY, int direction) {
        super(positionX, positionY, itemName, dimensionX, dimensionY, direction);
    }

    //This method should call another method 
    // public void attemptProcess(Ore ore) {
    //     if () {
            
    //     }
    // }

    public void setPreviousItem(ProcessingItem itemToPullFrom) {
        this.itemToPullFrom = itemToPullFrom;
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

    public void pullAndProcessOre() { 
        if (itemToPullFrom != null) {
            if (itemToPullFrom.isOreStored()) {
                pullOre();
                this.process(getStoredOre());
            }
        }
    }

    public void pullOre() {
        setCurrentOre(itemToPullFrom.getStoredOre());
        itemToPullFrom.setCurrentOre(null);
    }

    
    public abstract void process(Ore ore);


}
