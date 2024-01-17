//The OreRealm is a stack of max Length 500(Ore limit) and when its created it will be full of 500 basic ore objects.
//Droppers will "pop"/pull their ore from the OreRealm rather than making a new ore object each time they drop an ore.
//When a furnace sells an Ore it will reset it and return the ore to the OreRealm.
//This allows for ore objects to be recycled and limits the number of ore objects in that can be present in the tycoon.
//The oreRealm also keeps track of the ore that are active in the tycoon, and is used to set ore state to moveable at the end of each tick.

import java.util.ArrayList;
import java.util.List;

public class OreRealm {
    private static OreRealm oreRealmInstance;
    private final Ore[] stackOfOre;
    private final List<Ore> activeOre;
    private int top = 0;

    public OreRealm() {
        this.top = Constants.ORE_LIMIT;
        stackOfOre = new Ore[Constants.ORE_LIMIT];
        activeOre = new ArrayList<>(Constants.ORE_LIMIT);
        fillStackWithOre();
    }

    public static OreRealm getOreRealmInstance(){
        if(oreRealmInstance == null) {
            oreRealmInstance = new OreRealm();
        }
        return oreRealmInstance;
    }

    public void takeOre(Ore element) {
        activeOre.remove(element);
        this.stackOfOre[this.top] = element;
        this.top++;
    }

    public Ore giveOre() {
        this.top--;
        Ore result = this.stackOfOre[this.top];
        this.stackOfOre[this.top] = null;
        activeOre.add(result);
        return result;
    }

    public Ore peek() {
        if (this.isEmpty()) {
            throw new EmptyCollectionException("stack");
        }
        return this.stackOfOre[this.top];
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return this.top;
    }

    public String toString() {
        String result = "";

        for (Ore item : stackOfOre) {
            result += "[" + item + "]";
        }
        return result;
    }

    public void fillStackWithOre() {
        for (int i = 0; i < stackOfOre.length; i++) {
            stackOfOre[i] = new Ore();
        }
    }

    public int getNumberOfOreNotInStack() {
        return activeOre.size();
    }

    public List<Ore> getActiveOre() {
        return activeOre;
    }
    public int getActiveOre2() {
        return Constants.ORE_LIMIT-size();
    }

}


