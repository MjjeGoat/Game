package Game.Commands;

import Game.Commands.Command;
import Game.CreateMap;
import Game.Location;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import java.io.*;
import java.util.Scanner;

/**
 * Represents a command that provides hints for the player based on their current location.
 */
public class Napoveda extends Command {

    CreateMap cm = new CreateMap();
    Scanner sc = new Scanner(System.in);

    /**
     * Loads the last saved position of the player from a file or sets the default starting position.
     */
    private void rewrite(){
            try {
                File file = new File("src/Game/position");
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line = br.readLine();
                cm.setCurrentpos(line);
                br.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    /**
     * Executes the hint command, loading and displaying hints based on the player's current location.
     * @return a message from file which is hint.
     */
    @Override
    public String execute() {
        rewrite();
        cm.loadMap();
        for (Location lokace : cm.getMap().values()) {
            if (lokace.getName().equals(cm.getCurrentpos())) {
                try {
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(lokace.getHint()));
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        System.out.println(line);
                        System.out.println("Stisknete ENTER pro pokracovani");
                        sc.nextLine();
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return "Snad vam to pomohlo";
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

