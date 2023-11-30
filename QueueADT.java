public interface QueueADT<E> {
    
    void enqueue(E element);

    E dequeue();

    E first();

    boolean isEmpty();

    int size();

    String toString();
}
