//TheMap keeps track of all items that are placed.

import java.util.ArrayList;

public class TheMap {

    private static TheMap theMapInstance;
    public final Item[][] theMap;
    private final int MAP_DIMENSION = 5000;
    private final ArrayList<Point> occupiedCoordinates = new ArrayList<>();
    
    public TheMap() {
        theMap = new Item[MAP_DIMENSION][MAP_DIMENSION];
    }
    //Used for the singleton design pattern.
    public static TheMap getTheMapInstance() {
        if (theMapInstance == null) {
            theMapInstance = new TheMap();
        }
        return theMapInstance;
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
        if(X < 0 || X > MAP_DIMENSION -1 || Y < 0 || Y > MAP_DIMENSION -1) {
            return false;
        } else {
            return theMap[X][Y] != null;
        }
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
        Point newPoint = new Point(X, Y);
        occupiedCoordinates.add(newPoint);
    }
    //This might not work like I think it does
    public void removeCoordinates(int X, int Y) {
        Point pointToBeRemoved = new Point(X, Y);
        occupiedCoordinates.remove(pointToBeRemoved);
    }

    public ArrayList<Point> getFilledCoordinates() {
        return occupiedCoordinates;
    }


}
