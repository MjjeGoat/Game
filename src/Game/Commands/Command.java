package Game.Commands;

/**
 * Represents an abstract command that can be executed.
 */
public abstract class Command {

    /**
     * Executes the command and returns the result of the command as the string.
     * @return the result of the command execution
     */
    public abstract String execute();

    /**
     * Determines whether the command should cause the program to exit.
     * @return true if the program should exit, false otherwise
     */
    public abstract boolean exit();

}

