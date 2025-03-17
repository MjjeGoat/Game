package Game;

import java.util.ArrayList;

public class Inventory {
     private ArrayList<String> inventory = new ArrayList<>();
     private ArrayList<String> usedItems = new ArrayList<>();

    public ArrayList<String> getUsedItems() {
        return usedItems;
    }

    public ArrayList<String> getInventory() {
        return inventory;
    }

    public void addItem(String item) {
        inventory.add(item);
    }

    public void addUsedItem(String item) {
        usedItems.add(item);
    }

    public void removeItem(String item) {
        inventory.remove(item);
    }



}
