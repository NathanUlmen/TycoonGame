// TheTycoonBuilder would:

// Look for each furnace

// Look for each Item the has nothing to feed into, the item must also have an item feeding into it.

// Create a list for each of these "systems" and place the item at the "front"(Item to fire first) of the list

// Then it will call getItemBehind, and add that item to the list, repeat until the "system" has been mapped out.

// Only conveyors will be able to take ore from all sides which means that I will only have to check to see if there are objects to left and right when I am on conveyor items.
		


// it will then have all the items setItem to push to.


// This method will be called everytime an item is placed or removed.

import java.util.ArrayList;
import java.util.List;

public class TycoonBuilder {
    protected static TheMap theMap = new TheMap();
    private List<List<Item>> tycoonSystems = new ArrayList<>();
    private List<Item> allItems = new ArrayList<>();
    private int index = 0;

    
    //This method will fire each List of Different systems, firing the items inside of the list in the correct order.
    public void tycoonTick() {
        
    }

    //This method will set make all placed items set their ItemInFront.
    public void connectSystems() {

    }

    //This method will map out and "create" the systems, so that they can be fired in the correct order.
    public void createSystems() {
        for (List<Item> list : tycoonSystems) {
            for (Item item : list) {
                if(item instanceof Furnace || item instanceof Upgrader) {
                    //Do I use a recursive method to solve this???
                } else if (item instanceof Conveyor) {

                }
            }
        }
    }

    //Goes through all placed items and identifies end points of systems.
    //THIS HAS NOT BEEN TESTED
    public void identifySystems() {
        for (Item item : allItems) {
            if(item instanceof Furnace) {
                //Create new system list and add this to front
                List<Item> newSystem = new ArrayList<>();
                newSystem.add(item);
                tycoonSystems.add(index, newSystem);
                index++;
            } else if (item.getItemInFront() == null) {
                if (item instanceof ProcessingItem) {
                    if (itemBehindIsLinked(item)) {
                        //Create a new system list and add this to the front.
                        List<Item> newSystem = new ArrayList<>();
                        newSystem.add(item);
                        tycoonSystems.add(index, newSystem);
                        index++;
                    } else if (item instanceof Conveyor) {
                        if(itemToRightIsLinked(item) || itemToLeftIsLinked(item)) {
                            //create a new system list and add this to the front.
                            List<Item> newSystem = new ArrayList<>();
                            newSystem.add(item);
                            tycoonSystems.add(index, newSystem);
                            index++;
                        }
                    }
                    


                }
                //Create new system list and ad
            }
        }
    }

    //This method will look for systems that dont have an end, they are just one big circle.
    public void identifyLoopingSystems(){
        
    }

    //item.getItemInFront() == null && item.getItemBehind() != null
    //Makes a list of all the placed Items.
    public void setAllItems() {
        allItems.add(getAllPlacedItems());
    }

    //This method will return all the objects that are on theMap.
    private Item getAllPlacedItems() {
        ArrayList<Point> filledCoordinates = theMap.getFilledCoordinates();
        for (Point coordinate : filledCoordinates) {
            int x = coordinate.getX();
            int y = coordinate.getY();
            return theMap.getItem(x, y);
        }
        return null;
    }

    private boolean itemBehindIsLinked(Item item) {
        Item itemBehind = item.getItemBehind();
        return itemBehind != null && itemBehind.getItemInFront() == item;
    }

    private boolean itemToRightIsLinked(Item item) {
        Item itemToRight = item.getItemToRight();
        return itemToRight != null && itemToRight.getItemInFront() == item;
    }

    private boolean itemToLeftIsLinked(Item item) {
        Item itemToLeft = item.getItemToLeft();
        return itemToLeft != null && itemToLeft.getItemInFront() == item;
    }


    
    





    // public void fireTycoons(List<List<ProcessingItem>> tycoonSystems) {
    //     // Iterate through each tycoon system
    //     for (List<ProcessingItem> tycoonSystem : tycoonSystems) {
    //         // Iterate through each processing item in the tycoon system
    //         for (ProcessingItem processingItem : tycoonSystem) {
    //             // Process and push the ore for each item
    //             processingItem.processAndPush();
    //         }
    //     }
    // }

    // public List<List<ProcessingItem>> buildTycoons() {
    //     List<List<ProcessingItem>> tycoonSystems = new ArrayList<>();

    //     for (int i = 0; i < theMap.theMap.length; i++) {
    //         for (int j = 0; j < theMap.theMap[i].length; j++) {
    //             Item currentItem = theMap.getItem(i, j);

    //             // Check if it's a furnace
    //             if (currentItem instanceof ProcessingItem) {
    //                 List<ProcessingItem> tycoonSystem = new ArrayList<>();
    //                 buildSystem((ProcessingItem) currentItem, tycoonSystem);
    //                 tycoonSystems.add(tycoonSystem);
    //             }
    //         }
    //     }

    //     connectTycoons(tycoonSystems);
    //     return tycoonSystems;

    // }

    // private void buildSystem(ProcessingItem currentItem, List<ProcessingItem> tycoonSystem) {
    //     tycoonSystem.add(currentItem);

    //     // Build the system by following the items to the right
    //     while (currentItem != null) {
    //         currentItem = (ProcessingItem) currentItem.getItemToRight();
    //         if (currentItem != null) {
    //             tycoonSystem.add(currentItem);
    //         }
    //     }

    //     // Build the system by following the items to the left
    //     currentItem = tycoonSystem.get(0);
    //     while (currentItem != null) {
    //         currentItem = (ProcessingItem) currentItem.getItemToLeft();
    //         if (currentItem != null) {
    //             tycoonSystem.add(currentItem);
    //         }
    //     }
    // }

    // private void connectTycoons(List<List<ProcessingItem>> tycoonSystems) {
    //     // Iterate through each tycoon system and setItemToPushTo for each item
    //     for (List<ProcessingItem> tycoonSystem : tycoonSystems) {
    //         for (int i = 0; i < tycoonSystem.size() - 1; i++) {
    //             ProcessingItem currentItem = tycoonSystem.get(i);
    //             ProcessingItem nextItem = tycoonSystem.get(i + 1);

    //             // SetItemToPushTo logic
    //             currentItem.setItemInFront();
    //         }
    //     }
    // }
}

