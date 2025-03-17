package Game.Commands;

public abstract class Command {
    public abstract String execute();
    public abstract boolean exit();
    public int counter;
}
