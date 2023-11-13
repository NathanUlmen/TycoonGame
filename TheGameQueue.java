//TheGameQueue is the class that stores the Queue of items placed down.

import java.util.LinkedList;

public class TheGameQueue {
    private ProcessingItem processingItem;
    private static Item[] theTycoon = new Item[100];
    private int queueSize;

    // private static LinkedList<ProcessingItem> theTycoon = new LinkedList<>();
    private static LinkedList<Ore> oreQueue = new LinkedList<Ore>();  
    


    public TheGameQueue() {
        queueSize = 0;
    }

    //adds an item to the queue at a specific part in it
    public void addItem(Item item, int index) {
        theTycoon[index] = item;
        queueSize++;
    }
    
    //removes an item from the queue at a specific index. 
    public void removeItem(Item item, int index) {
        theTycoon[index] = null;
    }

    // public void processOre() {
    //     for (Ore ore : oreQueue) {
    //         for (Item item : theTycoon) {
    //         if (item instanceof Upgrader) {
    //             ((Upgrader)item).upgrade(ore);
    //             } else if (item instanceof Conveyor) {
    //                 ((Conveyor)item).move(ore);
    //             } else if (item instanceof Furnace) {
    //                 ((Furnace)item).sell(ore);
    //             }
    //         }
    //     }
    // }

        
    // This will be the core method of the entire game, every time its called it will cause the tycoon to "tick". When a tick happens a couple of different things will occur,
    // all ProcessingItems will fire off the process method in order from end of queue to beginning(Queue starts at end and last thing that happens is droppers create ore).
    // This process method will "pull" the ore object stored in the item behind it and call the method that corresponds with what item it is(upgrade, sell, move).
            // 1.This effectively means that a conveyor item is just a placed holder, all it does is pull and hold ore?

            // 2.The ore objects will be stored inside the ProcessingItems. Droppers will effectively insert ore into a ProcessingItem. (This means they need an index of where they are at in the Queue?)
            // What if I want to be able to store multiple ore in a ProcessingItem at one time? EX: there are 2 ore on the same conveyor.

            // 3.How does the ProcessingItem know which item it will be pulling from? What if when a "tick" occurs a processingItem pulls an ore into it from the previous ProcessingItem in the Queue but also
            // has a dropper try and insert an ore int it?

            // 4.Sticking with the "tick" theme should I make the droppers function sort of similar to how crops grow in minecraft? Every time this "tick" occurs do Increment a "dropRate" value on the dropper and once that
            // "dropRate" value reaches a certain threshold it creates a new ore? (EX: Every ten game ticks the dropper creates a new ore)

            // 5. How will this work in real time when someone is presumably changing the tycoon(Queue) at the same time that its "ticking"? 
            // 6. If I have a high "tick" rate that means the tycoon will be fast and if I have a low tick rate the tycoon will be slow. What if I want specific upgraders/conveyors to have different speeds?
            // Do I do something similar to what I speculated about in point #4 and make it so they only call their process method after X number of ticks? if so Items will need to be able to store a multiple ore 
            // at the same time.
            // 7. If I wanted to store multiple ore in one Item does that mean that I would need to have each item have their own queue that stores ore?

    public void tycoonTick() {
        for (int i = 0; i < queueSize; i++) {
            ((ProcessingItem) theTycoon[i]).pullAndProcessOre();
        }
        
                                    
        //this is the pullAndProcess() method:
        //Do this for each object in the Queue. Start from last item in queue go to first,

        //Check to see if ore is currently stored in object: isOreStored();
            
        //check to see if there is an object it can pull ore from: getItem();

        //call to object linked to see if it has ore. :getItem().isOreStored();

        //if the object its pulling from has an ore pull that ore: pullOre();

        //once that ore is pulled into item perform process effect on the ore(upgrade/sell).

        //after that all processing Items have been gone through, go through all droppers,

        //dropper will check to see if ore limit is true or false.
        //dropper will check to see if the Processing item its inserting an ore into has an ore
        //if no ore is present the dropper will then insert an ore into that object.
        }
        

        
}
