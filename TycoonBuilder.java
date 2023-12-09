// TheTycoonBuilder would:

// Look for each furnace

// Look for each Item the has nothing to feed into, the item must also have an item feeding into it.

// Create a list for each of these "systems" and place the item at the "front"(Item to fire first) of the list

// Then it will call getItemBehind, and add that item to the list, repeat until the "system" has been mapped out.

// Only conveyors will be able to take ore from all sides which means that I will only have to check to see if there are objects to left and right when I am on conveyor items.
		


// it will then have all the items setItem to push to.


// This method will be called everytime an item is placed or removed.
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;


public class TycoonBuilder {
    //This might not be using the same instance of TheMaps as the items are(Use singleton design pattern?)
    protected static TheMap theMap = TheMap.getTheMapInstance();
    private List<List<Item>> tycoonSystems = new ArrayList<>();
    public List<Item> allItems = new ArrayList<>();
    public List<Item> system = new ArrayList();

    private BreadthFirstSearchQueue systemExplorerQueue = new BreadthFirstSearchQueue();
    

    //This method will fire each List of Different systems, firing the items inside of the list in the correct order.
    public void tycoonTick() {
        for (Item item : system) {
            if(item instanceof ProcessingItem) {
                ((ProcessingItem) item).processAndPush();
            } else if( item instanceof Dropper) {
                ((Dropper)item).dropOre();
            }
        }
    }

    //This method will set make all placed items set their ItemInFront.
    public void connectSystems() {
        for (Item item : system) {
            item.setItemInFront();
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
        system.clear();
        for (List<Item> list : tycoonSystems) {                                                         
            for (Item item : list) {
                // system.add(item);
                exploreSystem(item);
                    //Do I use a recursive method to solve this???
                    //Maybe use an algorithm called Breadth-First Search(BFS) to do this
            }
        }
    }


    //Goes through all placed items and identifies end points of systems.
    //THIS HAS NOT BEEN TESTED
    public void identifySystems() {
        int index = 0;
        tycoonSystems.clear();
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

    // public void identify(Item item) {
    //     switch () {
    //         case Furnace:
                
    //             break;
        
    //         case ProcessingItem :

    //             break;

    //         case Conveyor :

    //             break;
    //     }
    // }

    //This method will look for systems that dont have an end, they are just one big circle.
    public void identifyLoopingSystems(){
        //from what I can find it seems like I could approach this using an algorithm called
        //Depth First Search(DFS)
    }

    //This method will return all the objects that are on theMap and makes a list of them, it will also SetItemInFront for them.
    public void setAllPlacedItems() {
        allItems.clear();
        ArrayList<Point> filledCoordinates = theMap.getFilledCoordinates();
        for (Point coordinate : filledCoordinates) {
            theMap.getItem(coordinate.getX(), coordinate.getY()).setItemInFront();
            allItems.add(theMap.getItem(coordinate.getX(), coordinate.getY()));
        }
    }

    public List<Item> getAllPlacedItems() {
        return allItems;
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

    private void exploreSystem(Item currentItem) {
        if (currentItem == null || currentItem instanceof Dropper) {
            return;
        }
        system.add(currentItem);
    
        if (currentItem instanceof Furnace || currentItem instanceof Upgrader) {
            //furances and upgraders can only take items from behind.
            exploreSystem(currentItem.getItemBehind());

        } else if (currentItem instanceof Conveyor) {
            //conveyors can take items from left, right, and behind.
            exploreSystem(currentItem.getItemToLeft());
            exploreSystem(currentItem.getItemToRight());
            exploreSystem(currentItem.getItemBehind());
        }
    }

    private class BreadthFirstSearchQueue implements QueueADT<Item>{
        private int front, rear, count;
        private Item[] queue;

        @Override
        public void enqueue(Item element) {
            if (size() == queue.length) {
                expandCapcaity();
            }
            queue[rear] = element;
            count++;
        }

        @Override
        public Item dequeue() {
            if (isEmpty()) {
                throw new NoSuchElementException("Nothing left in the Queue");
            }
            Item result = queue[front];
            queue[front]= null;
            count--;
            return result;

        }

        @Override
        public Item first() {
            if (isEmpty()) {
                throw new NoSuchElementException("Nothing in the Queue!");
            }
            return queue[front];
        }

        @Override
        public boolean isEmpty() {
            return size() == 0;
        }

        @Override
        public int size() {
            return count;
        }

        private void expandCapcaity() {
            Item[] biggerQueue = Arrays.copyOf(queue, queue.length * 2);
            queue = biggerQueue;
        }
        
    }

    private class DepthFirstSearchStack implements StackADT<Item>{
        private Item[] stackOfItems;
        private int top;

        @Override
        public void push(Item element) {
            //check to expand
            this.stackOfItems[this.top] = element;
            this.top++;
        }

        @Override
        public Item pop() {
            //Check to see if empty
            Item result = stackOfItems[this.top];
            stackOfItems[this.top] = null;
            top--;
            return result;
        }

        @Override
        public Item peek() {
            //Check to see if empty
            return stackOfItems[this.top];
        }

        @Override
        public boolean isEmpty() {
            return size() == 0;
        }

        @Override
        public int size() {
            return this.top;
        }
    
    }
}

