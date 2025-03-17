package Game.Commands;


public class OpenInventory extends Command{
    PickedUp pickedUp = new PickedUp();
    @Override
    public String execute() {
        return String.valueOf(pickedUp.inv.getInventory());
    }

    @Override
    public boolean exit() {
        return false;
    }

    public OpenInventory(PickedUp pickedUp) {
        this.pickedUp = pickedUp;
    }
}
