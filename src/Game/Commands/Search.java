package Game.Commands;
import Game.CreateMap;
import Game.Person;
import Game.Structure;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents a command that allows the player to search for objects and people who can interact with player in the current location.
 */
public class Search extends Command {
    Scanner scanner = new Scanner(System.in);
    PickedUp p = new PickedUp();

    public Search(PickedUp p) {
        this.p = p;
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
     * Author: 50% ChatGPT
     * Executes the search command. The player can search for objects and people who can interact with player in the current location.
     * @return a message indicating the result of the search
     */
    @Override
    public String execute() {
        rewrite();
        p.cm.loadItems();
        p.cm.loadPersons();
        boolean foundS = false;
        boolean foundP = false;
        boolean correct = false;

        for (Person person : p.cm.getPersons().values()) {
            if (person.getLocation().equals(p.cm.getCurrentpos())) {
                System.out.println("V teto lokaci muzu interagovat s: " + person.getName());
                foundP = true;
            }
        }
        if (!foundP) {
            System.out.println("V teto lokaci se nenachazi zadna osoba");
        }

        for (Structure structure : p.cm.getItems().values()) {
            if (structure.getLocation().equals(p.cm.getCurrentpos())) {
                System.out.println("V teto lokaci se nachazi objekt: " + structure.getName());
                foundS = true;
            }
        }
        if (!foundS) {
            return "V teto lokaci se nenachazi zadny objekt na prohledani";
        }

        System.out.println("Zadejte jaky objekt chcete prohledat");
        String search = scanner.nextLine().trim();

        for (Structure structure : p.cm.getItems().values()) {
            if (search.equals(structure.getName())) {
                ArrayList<String> availableItems = new ArrayList<>();

                for (String item : structure.getItems()) {
                    if (!p.inv.getInventory().contains(item) && !p.inv.getUsedItems().contains(item)) {
                        availableItems.add(item);
                    }
                }

                if (availableItems.isEmpty()) {
                    System.out.println(structure.getName() + " je prázdný.");
                } else {
                    System.out.println(structure.getName() + " obsahuje " + availableItems);
                }

                correct = true;
            }
        }

        if (!correct) {
            return "Tento objekt se v mistnosti nenachazi";
        }

        return "";
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

