//TheMap keeps track of all items that are placed.

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class TheMap {

    public Item[][] theMap;
    private ArrayList<Point> occupiedCoordinates = new ArrayList<>();


    
    public TheMap() {
        theMap = new Item[50][50];
    }
    //This method adds an item to specific coordinates
    public void addItemToMap(Item item, int X, int Y) {
       theMap[X][Y] = item;
       item.setPositionX(X);
       item.setPositionY(Y);
       addCoordinates(X, Y);
    }

    public void removeItemFromMap(int X, int Y) {
        theMap[X][Y].setPositionX(-1);
        theMap[X][Y].setPositionY(-1);
        theMap[X][Y] = null;
        removeCoordinates(X, Y);
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

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < theMap.length; i++) {
            for (int j = 0; j < theMap[i].length; j++) {
                Item item = theMap[i][j];
                if (item != null) {
                    result.append(String.format("[%d,%d]: %s%n", i, j, item));
                }
            }
        }
        return result.toString();
    }

    public void addCoordinates(int X, int Y) {
        occupiedCoordinates.add(new Point(X, Y));
    }

    public void removeCoordinates(int X, int Y) {
        occupiedCoordinates.remove(new Point(X, Y));
    }


    public ArrayList<Point> getFilledCoordinates() {
        return occupiedCoordinates;
    }

}
