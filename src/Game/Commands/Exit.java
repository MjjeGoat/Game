package Game.Commands;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Represents a command that ends the program.
 */
public class Exit extends Command {

    /**
     * Executes the exit command.
     * @return a message indicating that the program is ending
     */
    @Override
    public String execute() {
        return "Konec hry";
    }

    /**
     * Determines whether the command should terminate the program.
     * @return always true, as this command is exiting the programme.
     */
    @Override
    public boolean exit() {
        return true;
    }
}

