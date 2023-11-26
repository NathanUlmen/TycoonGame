public interface StackADT<Ore> {
    
    public void push(Ore ore);

    public Ore pop();

    public Ore peek();

    public boolean isEmpty();

    public int size();

    public String toString();
}
