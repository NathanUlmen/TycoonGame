//TheGameQueue is the class that stores the Queue of items placed down.

import java.util.LinkedList;

public class TheGameQueue {
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
    // all ProcessingItems will fire off the process method in order from end of queue to begining(Queue starts at end and last thing that happens is droppers create ore).
    // This process method will "pull" the ore object stored in the item behind it and call the method that corresponds with what item it is(upgrade, sell, move).
            // 1.This effectively means that a conveyor item is just a placed holder, all it does is pull?

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
            
        }
        // for (ProccessingItem processingItem : theTycoon) {
        //      processingItem.process() <----- 
        //                      process() this process method is the one I am working on in the ProcessingItem class(I decided to rename the ConveyorType class to "ProcessingItem")
        //                      1.This process method should have the item check to see if it is storing any ore, if it is then it will carry out the method 
        //                      that corressponds to the what the item is(upgrade, sell, move)
        //                      2.What happens next? does the item push the ore forward to the next item in the queue?
        //                      Does the item pull the ore from the item that feeds into it?
        //                      In both these scenarios how does the Item know whats before and whats after it in the queue?
        //                      TheGameQueue knows the order of the items but the items themselves dont what comes before ore after them based on my understanding.
        //                      The process method will then call move the ore to the next item in the Queue (How will it do this? How does it know which item is next in the queue?)                               
        }
        

        
}
