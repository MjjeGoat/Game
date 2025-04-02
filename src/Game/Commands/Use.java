package Game.Commands;

import Game.Commands.Command;
import Game.CreateMap;
import Game.Location;

import java.io.*;
import java.util.Scanner;

/**
 * Represents a command that allows the player to use an item from their inventory.
 */
public class Use extends Command {

    public PickedUp p = new PickedUp();
    Scanner sc = new Scanner(System.in);

    /**
     * Constructs a Use command with a specified inventory.
     * @param p the inventory and game state management object
     */
    public Use(PickedUp p) {
        this.p = p;
    }

    /**
     * Default constructor for the Use command.
     */
    public Use() {
    }

    private String what = " ";

    /**
     * Sets the item to be used.
     * @param what the name of the item
     */
    public void setWhat(String what) {
        this.what = what;
    }

    /**
     * Retrieves the item that is set to be used.
     * @return the name of the item
     */
    public String getWhat() {
        return what;
    }

    /**
     * Loads the last saved position of the player from a file.
     */
    private void rewrite() {
        File file = new File("src/Res/position");
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = br.readLine();
            p.cm.setCurrentpos(line);
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Executes the use command. The player selects an item from their inventory and attempts to use it.
     * If the item is useable, player can go to next location.
     * @return a message indicating whether the item was used successfully or not
     */
    @Override
    public String execute() {
        rewrite();
        p.cm.loadMap();
        System.out.println("Zadejte jaky predmet chcete pouzit");
        System.out.println("Vas inventar: " + p.inv.getInventory());
        what = sc.nextLine();

        if (p.inv.getInventory().contains(what)) {
            for (Location location : p.cm.getMap().values()) {
                if (location.getName().equals(p.cm.getCurrentpos())) {
                    if (location.getWhatItem().equals(what)) {
                        p.inv.getInventory().remove(what);
                        p.inv.addUsedItem(what);
                        return "Pouzili jste " + what;
                    } else {
                        return "Tady tento predmet opravdu nevyuziju";
                    }
                }
            }
        } else {
            return "Tento predmet nemate";
        }
        return "Neco je spatne";
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

