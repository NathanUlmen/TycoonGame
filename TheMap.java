//TheMap keeps track of all items that are placed.

public class TheMap {

    public Item[][] theMap;
    
    public TheMap() {
        theMap = new Item[20][20];
    }
    //This method adds an item to specific coordinates
    public void addItemToMap(Item item, int X, int Y) {
       theMap[X][Y] = item;
    }
    //This method checks to see if there is an item present at the specific coordinates.
    public boolean isFilled(int X, int Y) {
        return theMap[X][Y] != null;
    }

    //this method gets the item at a specific set of coordinates
    public Item getItem(int X, int Y) {
        if (isFilled(X, Y)) {
            return theMap[X][Y];
        } return null;
    }
}
