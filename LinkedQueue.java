public class LinkedQueue<E> implements QueueADT<E> {

    private LinearNode<E> front, rear;
    private int count;

    public LinkedQueue() {
        front = rear = null;
        count = 0;
    }

    @Override
    public void enqueue(E element) {
        LinearNode<E> node =  new LinearNode<E>(element);
        if (isEmpty()) {
            front = node;
        } else {
            rear.setNext(node);
        }
        rear = node;
        count++;
    }

    @Override
    public E dequeue() {
        E result = first();

        front = front.getNext();
        count--;

        if (isEmpty()) {
            rear = null;
        }
        return result;
    }

    @Override
    public E first() {
        if (this.isEmpty()) {
            //throw new Empty("queue");
        }
        return front.getElement();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return count;
    }
    
}
