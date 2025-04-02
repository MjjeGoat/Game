package Game.Commands;

import Game.CreateMap;
import Game.Person;

import java.io.*;
import java.util.Scanner;

import java.io.*;
import java.util.Scanner;

/**
 * Represents a command that allows the player to interact with people and things in the game world.
 */
public class Speak extends Command {

    CreateMap cm = new CreateMap();
    Scanner sc = new Scanner(System.in);

    /**
     * Loads the last saved position of the player from a file.
     */
    private void rewrite() {
        File file = new File("src/Res/position");
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = br.readLine();
            cm.setCurrentpos(line);
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Executes the speak command. The player can interact with people if the people is in the current location.
     * @return a message indicating the result of the interaction
     */
    @Override
    public String execute() {
        rewrite();
        cm.loadPersons();
        System.out.println("Zadejte s kym/cim chcete interagovat");
        String who = sc.next();
        boolean foundL = false;
        for (Person person : cm.getPersons().values()) {
            if (person.getLocation().equals(cm.getCurrentpos())) {
                if (person.getName().equals(who)) {
                    foundL = true;
                    try {
                        sc.nextLine();
                        BufferedReader bufferedReader = new BufferedReader(new FileReader(person.getDialogue()));
                        String line;
                        while ((line = bufferedReader.readLine()) != null) {
                            System.out.println(line);
                            System.out.println("Stisknete ENTER pro pokracovani");
                            sc.nextLine();
                        }
                        break;
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        if (!foundL) {
            return "Tato osoba/vec se zde nenachazi";
        }
        if (!foundL) {
            return "V teto lokaci se nenachazi zadna osoba/vec na interakci";
        }

        return " ";
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

