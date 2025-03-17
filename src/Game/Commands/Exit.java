package Game.Commands;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Exit extends Command {

    @Override
    public String execute() {
        return "konec";
    }

    @Override
    public boolean exit() {
        return true;
    }
}
