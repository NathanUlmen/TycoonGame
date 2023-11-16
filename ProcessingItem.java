public abstract class ProcessingItem extends Item{
    
    protected Ore[] storedOreArray = new Ore[10];
    private ProcessingItem itemToPushTo;
    
    public ProcessingItem(int positionX, int positionY, String itemName, int dimensionX, int dimensionY, Direction direction) {
        super(positionX, positionY, itemName, dimensionX, dimensionY, direction);
    }

    //This method should call another method 
    // public void attemptProcess(Ore ore) {
    //     if () {
            
    //     }
    // }

    // public void setPreviousItem(ProcessingItem itemToPullFrom) {
    //     this.itemToPullFrom = itemToPullFrom;
    // }

    public void setCurrentOre(Ore ore) {
        for (int i = 0; i < storedOreArray.length; i++) {
            if (storedOreArray[i] == null) {
                storedOreArray[i] = ore;
                break;
            }
        }
    }

    private void addOre() {
        Ore[] tempArray = itemToPushTo.getStoredOreArray();
        for (int i = 0; i < 5; i++) {
            if(tempArray[i] == null) {
                tempArray[i] = storedOreArray[i];
                storedOreArray[i] = null;
            }
        }

        itemToPushTo.setStoredOreArray(tempArray);
        
        // if (itemToPushTo != null) {

        //     itemToPushTo.getStoredOreArray()
        //     Ore[] targetStoredOreArray = itemToPushTo.getStoredOreArray();
    
        //     // Calculate the number of ore to transfer (up to 4)
        //     int transferCount = Math.min(4, storedOreCount());
    
        //     // Transfer ore to the next item
        //     for (int i = 0; i < transferCount; i++) {
        //         if (targetStoredOreArray[i] == null) {
        //             targetStoredOreArray[i] = storedOreArray[i];
        //             storedOreArray[i] = null; // Remove the transferred ore from the current item
        //         }
        //     }
        // }
    }

        // for (int i = 0; i < 4; i++) {
        //     itemToPushTo.
        // }

    public Ore[] getStoredOreArray() {
        return storedOreArray;
    }

    public int storedOreCount() {
        int count = 0;
        for (Ore ore : storedOreArray) {
            if (ore != null) {
                count++;
            }
        }
        return count;
    }

    public void setItemToPushTo(Item item) {
        if (item instanceof ProcessingItem) {
            this.itemToPushTo = (ProcessingItem) item;
        } else {
            this.itemToPushTo = null;
        }
    }

    public boolean isOreStored() {
        return storedOreArray != null;
    }

    public void processAndPush() {
        if (isOreStored()) {
            int transferCount = 5;
                for (int i = 0; i < transferCount; i++) {
                    if (storedOreArray[i] != null) {
                        process(storedOreArray[i]);
                        if (this instanceof Furnace) {
                            storedOreArray[i] = null;
                        }
                    }
                }
        setItemToPushTo(getItemInFront());
            if(itemToPushTo != null && isOreStored()) {
                pushOre();
            }
        }
    }
    

    private void pushOre() {
        addOre();
    }

    public void setStoredOreArray(Ore[] storedOreArray) {
        this.storedOreArray = storedOreArray;
    }

    
    public abstract void process(Ore ore);


}
