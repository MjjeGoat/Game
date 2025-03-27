package Game.Commands;


/**
 * Represents a command that displays the player's inventory.
 */
public class OpenInventory extends Command {
    PickedUp pickedUp = new PickedUp();

    public OpenInventory(PickedUp pickedUp) {
        this.pickedUp = pickedUp;
    }

    /**
     * Print the current inventory as a string.
     * @return a string representation of the player's inventory
     */
    @Override
    public String execute() {
        return String.valueOf(pickedUp.inv.getInventory());
    }

    /**
     * Determines whether the command should terminate the program.
     * @return always false, as opening the inventory does not exit the program
     */
    @Override
    public boolean exit() {
        return false;
    }
}

