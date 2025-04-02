package Game.Commands;

import Game.CreateMap;
import Game.Inventory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


/**
 * Represents a command that allows the user to delete an item from their inventory.
 */
public class Delete extends Command {

    private PickedUp pickedUp;
    private Scanner sc = new Scanner(System.in);
    
    public Delete(PickedUp pickedUp) {
        this.pickedUp = pickedUp;
    }

    /**
     * Executes the delete command, prompting the user to specify an item to remove.
     * @return a message indicating whether the item was successfully removed from inventory or not
     */
    @Override
    public String execute() {
        System.out.println("Zadejte jaky predmet chcete vyhodit:");
        System.out.println("Tvuj inventar: " + pickedUp.inv.getInventory());
        String which = sc.nextLine();

        if (pickedUp.inv.getInventory().contains(which)) {
            pickedUp.inv.getInventory().remove(which);
            return "Vyhodili jste predmet: " + which;
        } else {
            return "Tento predmet nemate v inventari.";
        }
    }

    /**
     * Determines whether the command should terminate the program.
     * @return always false, as deleting an item doesn´t end the game.
     */
    @Override
    public boolean exit() {
        return false;
    }
}

