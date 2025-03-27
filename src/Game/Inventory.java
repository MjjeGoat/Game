package Game;

import java.util.ArrayList;

/**
 * Manages the player's inventory, including the list of collected and used items.
 */
public class Inventory {

    /**
     * List of items currently owned by the player (maximum capacity is not enforced).
     */
    private ArrayList<String> inventory = new ArrayList<>(5);

    /**
     * List of items that the player has already used.
     */
    private ArrayList<String> usedItems = new ArrayList<>();

    /**
     * Returns the list of used items.
     * @return the list of used items
     */
    public ArrayList<String> getUsedItems() {
        return usedItems;
    }

    /**
     * Returns the list of items currently in the inventory.
     * @return the list of items in the inventory
     */
    public ArrayList<String> getInventory() {
        return inventory;
    }

    /**
     * Adds a new item to the inventory.
     * @param item the name of the item to add
     */
    public void addItem(String item) {
        inventory.add(item);
    }

    /**
     * Adds an item to the list of used items.
     * @param item the name of the item that was used
     */
    public void addUsedItem(String item) {
        usedItems.add(item);
    }

    /**
     * Removes an item from the inventory.
     * @param item the name of the item to remove
     */
    public void removeItem(String item) {
        inventory.remove(item);
    }

}

