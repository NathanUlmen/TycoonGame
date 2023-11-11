public class TheMap {


    public Item[][] theMap;
    
    public TheMap() {
        theMap = new Item[20][20];
    }

    public void addItemToMap(Item item, int X, int Y) {
       theMap[X][Y] = item;
    }

    public boolean isFilled(int X, int Y) {
        return theMap[X][Y] != null;
    }

    public Item getItem(int X, int Y) {
        if (isFilled(X, Y)) {
            return theMap[X][Y];
        } return null;
    }
}
