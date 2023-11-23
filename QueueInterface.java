public interface QueueInterface<Ore> {

    public void enqueue(Ore element);

    public Ore dequeue();

    public Ore first();

    public boolean isEmpty();

    public int size();

    public String toString();
}
