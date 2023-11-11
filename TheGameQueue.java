//TheGameQueue is the class that stores the Queue of items placed down.

import java.util.LinkedList;

public class TheGameQueue {
    private static Item[] theTycoon = new Item[100];
    private int queueSize;

    // private static LinkedList<ProcessingItem> theTycoon = new LinkedList<>();
    // private static LinkedList<Ore> oreQueue = new LinkedList<>();  
    


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

    public void processOre() {
        //for (ProccessingItem processingItem : theTycoon) {
        //      processingItem.process() <----- 
        //                      process() this process method is the one I am working on in the ProcessingItem class(I decided to rename the ConveyorType class to "ProcessingItem")
        //                      1.This process method should have the item check to see if it is storing any ore, if it is then it will carry out the method 
        //                      that corressponds to the what the item is(upgrade, sell, move)
        
        //                      2.What happens next? does the item push the ore forward to the next item in the queue?
        //                      Does the item pull the ore from the item that feeds into it?
        //                      In both these scenarios how does the Item know whats before and whats after it in the queue?
        //                      TheGameQueue knows the order of the items but the items themselves dont what comes before ore after them based on my understanding.


        //                      The process method will then call move the ore to the next item in the Queue (How will it do this? How does it know which item is next in the queue?)
        //                                          
        //}
        for (int i = 0; i < queueSize; i++) {

        }
    }

    public void displayQueue() {
        for (ProcessingItem item : theTycoon) {
            System.out.println(item.getClass().getSimpleName());
        }
    }
}
