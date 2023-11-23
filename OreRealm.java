//The ore Realm will be a queue of max Length 500(Ore limit). When the ore realm is created it will be full of 500 basic ore objects.
// Droppers will pull their ore from the ore realm rather than making a new ore object each time they drop an ore and furnaces will return the ore objects fualt ore objects into it, basically
//recycles the ore objects and limits the amount of ore that can be in the tycoon at a time.

import java.util.EmptyStackException;

public class OreRealm<E> implements QueueInterface<E> {

    private final static int DEFAULT_CAPACITY = 100;
    private E[] queue;
    private int front, rear, count;

    public OreRealm() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public OreRealm(int initialCapacity) {
        front = rear = count = 0;
        this.queue = (E[])(new Object[initialCapacity]);
    }

    @Override
    public void enqueue(E element) {
        if (size() == queue.length) {
            expandCapacity();
        }
        queue[rear] = element;
        rear = (rear + 1) % queue.length;
        count++;
    }

    @Override
    public E dequeue() {
        if (this.isEmpty()) {
            throw new EmptyCollectionException("queue");
        }
        E result = queue[front];
        queue[front] = null;

        front = (front + 1) % queue.length;
        count--;
        return result;
    }

    @Override
    public E first() {
        if (this.isEmpty()) {
            throw new EmptyCollectionException("queue");
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

    public String toString() {
        String result = "[";
        int index = this.front;

        for (int i = 0; i < size(); i++) {
            if (i > 0) {
                result += ", ";
            }
            result += queue[index];
            index = (index + 1) % queue.length;
        }

        result += "]";

        return result;
    }

    @SuppressWarnings("unchecked")
    private void expandCapacity() {
        // E[] larger = Arrays.copyOf(queue, queue.length * 2);
        E[] larger = (E[])(new Object[queue.length*2]);
        for (int i = 0; i < size(); i++) {
            larger[i] = queue[front];
            front = (front + 1) % queue.length;
        }
        front = 0;
        rear = this.size();
        queue = larger;
    }
    // private Ore[] oreQueue;
    // private int front, rear, count;
    // private static int capacity = 500;

    // public OreRealm() {
    //     this(capacity);
    // }

    // @SuppressWarnings("unchecked")
    // public OreRealm(int initialCapacity) {
    //     oreQueue = (Ore[]) (new Object[initialCapacity]);
    //     front = rear = count = 0;
    //     fillOreQueue();
    // }

    // @Override
    // public void enqueue(Ore element) {
    //     if (size() == oreQueue.length) {
    //         throw new ArrayIndexOutOfBoundsException(null);
    //     }
    //     oreQueue[rear] = element;
    //     rear = (rear + 1) % oreQueue.length;
    //     count++;
    // }

    // @Override
    // public Ore dequeue() {
    //     if (this.isEmpty()) {
    //         throw new EmptyStackException();
    //     }
    //     Ore result = oreQueue[front];
    //     oreQueue[front] = null;

    //     front = (front + 1) % oreQueue.length;
    //     count--;
    //     return result;
    // }

    // @Override
    // public Ore first() {
    //     if (this.isEmpty()) {

    //     }
    //     return oreQueue[front];
    // }

    // @Override
    // public boolean isEmpty() {
    //     return size() == 0;
    // }

    // @Override
    // public int size() {
    //     return count;
    // }

    // public String toString() {
    //     String result = "[";
    //     int index = this.front;

    //     for (int i = 0; i < size(); i++) {
    //         if (i > 0) {
    //             result += ", ";
    //         }
    //         result += oreQueue[index];
    //         index = (index + 1) % oreQueue.length;
    //     }

    //     result += "]";

    //     return result;
    // }

    public void fillOreQueue() {
        for (int i = 0; i < queue.length; i++) {
            enqueue((E) new Ore());
        }
    }
}


