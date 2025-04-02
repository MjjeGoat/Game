package Game.Commands;

import Game.Commands.Command;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Represents a command that displays help instructions for commands from a file.
 */
public class Help extends Command {
    Scanner sc = new Scanner(System.in);

    /**
     * Executes the help command, reading and displaying instructions of each command from a file.
     * @return a message indicating that the user is now prepared for the game
     */
    @Override
    public String execute() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("src/Res/help"));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                System.out.println("Stisknete ENTER pro pokracovani");
                sc.nextLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "Ted uz by jste meli byt pripraveny na hru.";
    }

    /**
     * Determines whether the command should terminate the program.
     * @return always false, as this command does not exit the program
     */
    @Override
    public boolean exit() {
        return false;
    }
}

