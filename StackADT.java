public interface StackADT<E> {
    
    void push(E element);

    E pop();

    E peek();

    boolean isEmpty();

    int size();

    String toString();
}
