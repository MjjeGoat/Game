package Game.Commands;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

import Game.*;
import Game.Console;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Represents a movement command that allows the player to navigate through different locations in the game.
 */
public class Movement extends Command {
    public CreateMap cm = new CreateMap();
    Scanner sc = new Scanner(System.in);
    PickedUp pickedUp = new PickedUp();
    Use use = new Use(pickedUp);
    private String where;

    public void setWhere(String where) {
        this.where = where;
    }

    /**
     * Checks if the door to a given location is locked and whether the required item has been used to unlock it.
     * @param location the location to check
     * @return true if the door is unlocked, false otherwise
     */
    public boolean lockedDoor(Location location) {
        if (location.getName().equals(cm.getCurrentpos())) {
            if (use.p.inv.getUsedItems().contains(location.getOpenDoor())) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public Movement(Use use) {
        this.use = use;
    }

    /**
     * Loads the last saved position of the player from a file.
     */
    private void rewrite() {
            try {
                File file = new File("src/Res/position");
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line = br.readLine();
                cm.setCurrentpos(line);
                br.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }

    /**
     * Saves the player's current position to a file.
     */
    private void writeLocation() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("src/Res/position", false));
            bw.write(cm.getCurrentpos());
            bw.newLine();
            bw.flush();
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String movement(String where) {
        rewrite();
        for (Location lokace : cm.getMap().values()) {
            int a = 0;
            if (lokace.getName().equals(cm.getCurrentpos())) {
                for (int i = 0; i < lokace.getLocations().length; i++) {
                    if (where.equals(lokace.getLocations()[i])) {
                        for (Location loc : cm.getMap().values()) {
                            if (loc.getName().equals(where)) {
                                if (lokace.getIndex() >= loc.getIndex()) {
                                    cm.setCurrentpos(lokace.getLocations()[i]);
                                    i = lokace.getLocations().length;
                                    a++;
                                    writeLocation();
                                    return "Nachazite se v :" + cm.getCurrentpos();
                                } else if (lockedDoor(lokace)) {
                                    cm.setCurrentpos(lokace.getLocations()[i]);
                                    i = lokace.getLocations().length;
                                    a++;
                                    writeLocation();
                                    return "Nachazite se v :" + cm.getCurrentpos();
                                } else {
                                    writeLocation();
                                    return lokace.getMsg();
                                }
                            }
                        }
                    }
                }
                if (a < 1) {
                    writeLocation();
                    return "Spatne zkus to znovu";
                }
            }
        }
        return "";
    }

    /**
     * Executes the movement command, allowing the player to move to a new location if possible.
     * @return a message indicating the player's new location or an error message.
     */
    @Override
    public String execute() {
        rewrite();
        writeLocation();
        cm.loadMap();
        String output = " ";
        for (Location lokace : cm.getMap().values()) {
            if (lokace.getName().equals(cm.getCurrentpos())) {
                output = output + Arrays.toString(lokace.getLocations());
            }
        }
        System.out.println("Zadejte kam chcete jit: " + output);
        return movement(sc.nextLine());
    }

    /**
     * Determines whether the command should terminate the program.
     * @return always false, as movement does not exit the program
     */
    @Override
    public boolean exit() {
        return false;
    }

    /**
     * Retrieves the player's current position.
     * @return the current location name
     */
    public String position() {
        return cm.getCurrentpos();
    }
}

