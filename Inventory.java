import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Inventory {
    private static Inventory inventory;
    private List<Stack<Item>> inventoryList = new ArrayList<>();
    private Stack<Item> itemStack = new Stack<>();

    public Inventory() {

    }

    public static Inventory getInventoryInstance() {
        if (inventory == null) {
            return inventory = new Inventory();
        } else {
            return inventory;
        }
    }

    //Method to addItem to inventory
    public void addItem(Item item, int quantity) {
        for (Stack<Item> stack : inventoryList) {
            if (stack.peek().getItemType() == item.getItemType()) {
                for (int i = 0; i < quantity; i++) {
                    stack.push(item);
                }
                return;
            }
        }
        Stack<Item> newStack = new Stack<>();
        for (int i = 0; i < quantity; i++) {
            newStack.push(item);
        }
        inventoryList.add(newStack);
    }

    //Method to removeItem from inventory
    public void removeItem(Item item) {
        for (Stack<Item> stack : inventoryList) {
            if (stack.peek().getItemType() == item.getItemType()) {
                stack.pop();
                return;
            }
        }
    }

    //Not fully working yet, the sorting by type is broken.
    public void sortInventory() {
        // Custom comparator for sorting by type and then by name
        Comparator<Stack<Item>> comparator = new Comparator<Stack<Item>>() {
            @Override
            public int compare(Stack<Item> stack1, Stack<Item> stack2) {
                Item item1 = stack1.peek();
                Item item2 = stack2.peek();
    
                // Compare by type
                String type1 = item1.getItemType().getSimpleName();
                String type2 = item2.getItemType().getSimpleName();
                int typeComparison = type1.compareTo(type2);
    
                if (typeComparison != 0) {
                    return typeComparison;
                }
    
                // If types are the same, compare by name
                return item1.getItemName().compareTo(item2.getItemName());
            }
        };
    
        // Sort the inventory using the comparator
        Collections.sort(inventoryList, comparator);
    }

    public void printInventoryAsList() {
        System.out.println("Inventory:");
        for (Stack<Item> stack : inventoryList) {
            for (Item item : stack) {
                System.out.println("Type: " + item.getItemType().getSimpleName() +
                        ", Name: " + item.getItemName());
            }
            System.out.println("------");
        }
    }

    public void printInventory() {
        System.out.println("\nInventory: \n");
      
        for (Stack<Item> stack : inventoryList) {
            Item item = stack.peek();
            int itemCount = stack.size();
            String itemType = itemCount + "x " + item.getItemName();
            System.out.println(itemType);
            System.out.println("--------");
        }
    }

    public void writeInventoryToFile(String filePath) {
        // Create content to write to the file
        StringBuilder content = new StringBuilder();
        content.append("Inventory:\n");

        for (Stack<Item> stack : inventoryList) {
            Item item = stack.peek();
            int itemCount = stack.size();
            String itemType = itemCount + "x " + item.getItemName();
            content.append(itemType).append("\n--------\n");
        }

        // Write to the file
        try {
            // Specify the file path as a Path object
            Path path = Path.of(filePath);

            // Convert the content to bytes
            byte[] contentBytes = content.toString().getBytes();

            // Write the content to the file, create the file if it doesn't exist
            Files.write(path, contentBytes, StandardOpenOption.CREATE);

            System.out.println("File written successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
}
