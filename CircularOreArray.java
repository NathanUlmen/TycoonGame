public class CircularOreArray<E> {
    private E[] array;
    private int size, capacity, front;

    public CircularOreArray (int capacity) {
        this.capacity = capacity;
        this.array = (E[]) new Object[capacity];
        this.size = 0;
        this.front = 0;
    }

    public CircularOreArray(Ore ore) {
    }

    public void add(E element) {
        if (size < capacity) {
            array[(front + size) % capacity] = element;
            size++;
        }
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        return array[(front + index) % capacity];
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        // Shift elements to fill the gap
        for (int i = index; i < size - 1; i++) {
            array[(front + i) % capacity] = array[(front + i + 1) % capacity];
        }
        size--;
    }

    public int size() {
        return size;
    }
    @Override
    public String toString() {
        String circularOreArrayContents = "There are " + size() + " ore in this array";

        return circularOreArrayContents;
        
    }
}
