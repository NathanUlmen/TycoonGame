//The OreRealm is a stack of max Length 500(Ore limit) and when its created it will be full of 500 basic ore objects.
//Droppers will "pop"/pull their ore from the OreRealm rather than making a new ore object each time they drop an ore.
//When a furnace sells an Ore it will reset it and return the ore to the OreRealm.
//This allows for ore objects to be recycled and limits the number of ore objects in that can be present in the tycoon.

import java.util.Arrays;

public class OreRealm implements StackADT<Ore> {
    private final static int DEFAULT_CAPACITY = 500;

    private static OreRealm instance;
    private Ore[] stackOfOre;
    private int top;

    public OreRealm() {
        this(DEFAULT_CAPACITY);
        fillStackWithOre();
    }

    @SuppressWarnings("unchecked")
    public OreRealm(int initialCapacity) {
        this.top = 0;
        this.stackOfOre = new Ore[initialCapacity];
    }

    public static OreRealm getOreRealmInstance(){
        if(instance == null) {
            instance = new OreRealm();
        }
        return instance;
    }

    @Override
    public void push(Ore element) {
        // if (this.size() == this.stack.length) {
        //     // expand the capacity
        //     expandCapacity();
        // }
        this.stackOfOre[this.top] = element;
        this.top++;
    }

    @Override
    public Ore pop() {
        if (this.isEmpty()) {
            throw new EmptyCollectionException("stack");
        }
        this.top--;
        Ore result  = this.stackOfOre[this.top];
        this.stackOfOre[this.top] = null;
        return result;
    }

    @Override
    public Ore peek() {
        if (this.isEmpty()) {
            throw new EmptyCollectionException("stack");
        }
        Ore result  = this.stackOfOre[this.top];
        return result;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return this.top;
    }

    // @SuppressWarnings("unchecked")
    private void expandCapacity() {
        // E[] temp = (E[])(new Object[this.stack.length * 2]);
        // for (int i = 0; i < this.stack.length; i++) {
        //     temp[i] = this.stack[i];
        // }
        // this.stack = temp;
        this.stackOfOre = Arrays.copyOf(stackOfOre, stackOfOre.length * 2);
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
            push(new Ore());
        }
    }
    
}


