import java.util.LinkedList;

public class TheGameQueue {
    private static Item[] theTycoon = new Item[100];
    private int queueSize;

    // private static LinkedList<ProcessingItem> theTycoon = new LinkedList<>();
    // private static LinkedList<Ore> oreQueue = new LinkedList<>();  
    


    public TheGameQueue() {
        queueSize = 0;
    }

    public void addItem(Item item, int index) {
        theTycoon[index] = item;
        queueSize++;
    }
    

    public void removeItem(Item item, int index) {
        theTycoon[index] = null;
    }

    public void processOre() {
            for (int i = 0; i < queueSize; i++) {
                item.process();
            }
        }
    }

    public void displayQueue() {
        for (ProcessingItem item : theTycoon) {
            System.out.println(item.getClass().getSimpleName());
        }
    }
}
