//stored Items must implemenet the morph interface.
public class InventoryNode<E> {
    private ResourceManager resourceManager;
    private int totalOwned;
    private int numberInInventory;
    private int numberOwned;
    private final E heldItem;

    public InventoryNode(E itemToBeHeld, int totalOwned) {
        heldItem = itemToBeHeld;
        this.totalOwned = totalOwned;
    }

    public void increaseOwned() {
        numberOwned++;
    }

    public void decreaseOwned() {
        numberOwned--;
    }

    public void removeFromInventory() {
        numberInInventory++;
    }

    public E getHeldItem() {
        return resourceMangaer.popItem(heldItem).morphTo(heldItem);
    }

}
