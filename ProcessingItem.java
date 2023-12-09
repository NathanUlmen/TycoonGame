public abstract class ProcessingItem extends Item{
    protected OreDecorator storedOre;
    // private ProcessingItem itemToPushTo = itemInFront;
    private final boolean hasBeenUpgraded =  false;
    
    public ProcessingItem(int positionX, int positionY, String itemName, int dimensionX, int dimensionY, Direction direction, ItemTier tier, ItemType type) {
        super(positionX, positionY, itemName, dimensionX, dimensionY, direction, tier, type);
    }

    public ProcessingItem() {

    }
    
    public void processOre() {
        process(storedOre);
    }

    public void pushToItem() {
        if (itemToPushTo != null && itemToPushTo.isEmpty()) {
            itemToPushTo.setStoredOre(this.storedOre);
            setStoredOre(null);
        }
    }

    public void processAndPush() {
        if (storedOre != null) {
            processOre();
            pushToItem();
        }
    }

    public void setStoredOre(OreDecorator oreToBeStored) {
        this.storedOre = oreToBeStored;
    }

    public boolean isEmpty() {
        return storedOre == null;
    }


    // public void setCurrentOre(OreDecorator ore) {
    //     for (int i = 0; i < storedOreArray.length; i++) {
    //         if (storedOreArray[i] == null) {
    //             storedOreArray[i] = ore;
    //             break;
    //         }
    //     }
    // }

    //logic needs work this is broken AF
    // private void addOre() {
    //     OreDecorator[] tempArray = itemToPushTo.getStoredOreArray();
    //     for (int i = 0; i <= storedOreArray.length; i++) 
    //         if(tempArray[i] == null) {
    //             tempArray[i] = storedOreArray[i];
    //             storedOreArray[i] = null;
    //         }
        

    //     itemToPushTo.setStoredOreArray(tempArray);
        
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
    

        // for (int i = 0; i < 4; i++) {
        //     itemToPushTo.
        // }

    // public OreDecorator[] getStoredOreArray() {
    //     return storedOreArray;
    // }

    // public int storedOreCount() {
    //     int count = 0;
    //     for (Ore ore : storedOreArray) {
    //         if (ore != null) {
    //             count++;
    //         }
    //     }
    //     return count;
    // }

    public void setItemToPushTo(Item item) {
        if (item instanceof ProcessingItem) {
            this.itemToPushTo = (ProcessingItem) item;
        } else {
            this.itemToPushTo = null;
        }
    }

    // public boolean isOreStored() {
    //     return storedOreArray != null;
    // }

    // public void processAndPush() {
    //     if (isOreStored()) {
    //         int transferCount = 5;
    //             for (int i = 0; i < transferCount; i++) {
    //                 if (storedOreArray[i] != null) {
    //                     process(storedOreArray[i]);
    //                     if (this instanceof Furnace) {
    //                         storedOreArray[i] = null;
    //                     }
    //                 }
    //             }
    //     setItemToPushTo(getItemInFront());
    //         if(itemToPushTo != null && isOreStored()) {
    //             pushOre();
    //         }
    //     }
    // }
    

    // private void pushOre() {
    //     addOre();
    // }

    // public void setStoredOreArray(OreDecorator[] newStoredOreArray) {
    //     this.storedOreArray = newStoredOreArray;
    // }

    // public String storedOreArrayToString() {
    //     StringBuilder result = new StringBuilder("Stored Ore In " + getItemName() + ":\n");
    
    //     for (Ore ore : storedOreArray) {
    //         if (ore != null) {
    //             result.append(ore.toString()).append("\n");
    //         }
    //     }
    
    //     return result.toString();
    // }
    
    public abstract void process(OreDecorator ore);


}