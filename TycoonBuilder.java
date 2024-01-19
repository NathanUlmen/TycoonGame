// TheTycoonBuilder would:

// Look for each furnace

// Look for each Item the has nothing to feed into, the item must also have an item feeding into it.

// Create a list for each of these "systems" and place the item at the "front"(Item to fire first) of the list

// Then it will call getItemBehind, and add that item to the list, repeat until the "system" has been mapped out.

// Only conveyors will be able to take ore from all sides which means that I will only have to check to see if there are objects to left and right when I am on conveyor items.


// it will then have all the items setItem to push to.


// This method will be called everytime an item is placed or removed.

import java.util.*;

public class TycoonBuilder {
    private static TycoonBuilder tycoonBuilder;
    protected static TheMap theMap = TheMap.getTheMapInstance();
    private List<List<Item>> tycoonSystems = new ArrayList<>();
    public List<Item> allSystems = new ArrayList<>(2501);
    private List<Dropper> listOfDroppers = new ArrayList<>(2501);

    private OreRealm oreRealm = OreRealm.getOreRealmInstance();

    public static TycoonBuilder getTycoonBuilderInstance() {
        if (tycoonBuilder == null) {
            return tycoonBuilder = new TycoonBuilder();
        }
        return tycoonBuilder;
    }


    //This method will fire each List of Different systems, firing the items inside of the list in the correct order.
    public void tycoonTick() {
        //Would check to see if wasModified before calling updateTycoon.
        updateTycoon();
        fireAllSystems();
        //Go through all active ore on the map and set it so that they are able to be moved again.
        for (Ore ore : oreRealm.getActiveOre()) {
            ore.setProcessable(true);
        }
    }

    public void fireAllSystems() {
        for (Item item : allSystems) {
            ((ProcessingItem) item).processAndPush();
            //System.out.println(item.toString() + " fired");
        }
        for (Dropper dropper : listOfDroppers) {
            dropper.dropOre();
            // System.out.println("Dropped Ore!");
        }


    }

    public void updateTycoon() {
        //Goes through all items on the map and sets the items around them
        for (Item item : theMap.getFilledCoordinates()) {
            item.setAllSurroundingItems();
        }
//       setAllPlacedItems();
//       setAllPlacedItemsParallel();
        //Goes through all items on the map and identifies systems.
        identifySystems();
        //  identifySystemsParallel();
        //Goes through all potential systems and map them out.
        createSystems();
    }

    public void alternate() {
        setAllPlacedItems();
        for (Item item : theMap.getFilledCoordinates()) {
            ((ProcessingItem) item).processAndPush();
        }

    }

    //This method will map out and "create" the systems, so that they can be fired in the correct order.
//              1
//              | 
//              2  
//              |   
//              3   
//              | 
//     10--8--6--4--5--7--9   
//     |                 |
//     12                11
//     |                 |
//     14                13
//     |                 |
//     16                15----18----20
//     |                 |           |
//     19                17          21
//                       |           | 
    public void createSystems() {
        allSystems.clear();
        for (List<Item> list : tycoonSystems) {
            for (Item item : list) {
                //  exploreSystemQueue(item);
                exploreSystem(item);
            }
        }
    }

    public void identifySystems() {
        tycoonSystems.clear();
        listOfDroppers.clear();
        for (Item item : theMap.getFilledCoordinates()) {
            switch (item.getType()) {
                case FURNACE:
                case UPGRADER:
                    if (item.getItemInFront() == null && itemBehindIsLinked(item)) {
                        List<Item> newSystem = new ArrayList<>();
                        newSystem.add(item);
                        tycoonSystems.add(newSystem);
                        //System.out.println("Furnace added to tycoonSystems.");
                    }
                    break;
                case CONVEYOR:
                    if (item.getItemInFront() == null && itemBehindIsLinked(item) || itemToRightIsLinked(item) || itemToLeftIsLinked(item)) {
                        List<Item> newSystem = new ArrayList<>();
                        newSystem.add(item);
                        tycoonSystems.add(newSystem);
                        //System.out.println("Conveyor added to tycoonSystems");
                    }
                    break;
                case DROPPER:
                    listOfDroppers.add((Dropper) item);
                    break;

            }
        }
    }

    public void identifySystemsParallel() {
        tycoonSystems.clear();
        listOfDroppers.clear();
        theMap.getFilledCoordinates().parallelStream().forEach(item -> {
                    switch (item.getType()) {
                        case FURNACE:
                        case UPGRADER:
                            if (item.getItemInFront() == null && itemBehindIsLinked(item)) {
                                List<Item> newSystem = new ArrayList<>();
                                newSystem.add(item);
                                tycoonSystems.add(newSystem);
                                //System.out.println("Furnace added to tycoonSystems.");
                            }
                            break;
                        case CONVEYOR:
                            if (item.getItemInFront() == null && itemBehindIsLinked(item) || itemToRightIsLinked(item) || itemToLeftIsLinked(item)) {
                                List<Item> newSystem = new ArrayList<>();
                                newSystem.add(item);
                                tycoonSystems.add(newSystem);
                            }
                            break;
                        case DROPPER:
                            listOfDroppers.add((Dropper) item);
                            break;
                    }
                }
        );
    }

    private void exploreSystem(Item currentItem) {
        if (currentItem == null || currentItem instanceof Dropper) {
            return;
        } //Guard Statement

        // if (!allSystems.contains(currentItem)) {
        allSystems.add(currentItem);
        // }
        if (currentItem instanceof Upgrader || currentItem instanceof Furnace) {
            //furances and upgraders can only take items from behind.
            if (itemBehindIsLinked(currentItem)) {
                exploreSystem(currentItem.getItemBehind());
            }
        } else if (currentItem instanceof Conveyor) {
            //conveyors can take items from left, right, and behind.

            if (itemBehindIsLinked(currentItem)) {
                exploreSystem(currentItem.getItemBehind());
            }
            if (itemToLeftIsLinked(currentItem)) {
                exploreSystem(currentItem.getItemToLeft());
            }
            if (itemToRightIsLinked(currentItem)) {
                exploreSystem(currentItem.getItemToRight());
            }
        }
    }

    //This method will look for systems that dont have an end, they are just one big circle.
    public void identifyLoopingSystems() {

    }

    //This method will return all the objects that are on theMap and makes a list of them, it will also SetItemInFront for them.
    public void setAllPlacedItems() {
        for (Item item : theMap.getFilledCoordinates()) {
            item.setAllSurroundingItems();
        }
    }

    public void setAllPlacedItemsParallel() {
        theMap.getFilledCoordinates().parallelStream().forEach(Item::setAllSurroundingItems);
    }

    public List<Item> getAllPlacedItems() {
        return theMap.getFilledCoordinates();
    }

    public List<List<Item>> getTycoonSystems() {
        return tycoonSystems;
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

    private void exploreSystemQueue(Item currentItem) {
        currentItem.getItemBehind();
    }


}



