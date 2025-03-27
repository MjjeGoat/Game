package Game;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

import Game.Commands.*;


/**
 * Represents the main console for handling user commands in the game.
 */
public class Console {

    Napoveda nap = new Napoveda();
    Story story = new Story();
    PickedUp p = new PickedUp();
    Use u = new Use(p);
    Movement m = new Movement(u);
    Search s = new Search(p);
    OpenInventory op = new OpenInventory(p);
    Speak sp = new Speak();
    private Scanner sc = new Scanner(System.in);
    private boolean exit = false;
    private HashMap<String, Command> prikazy;
    String prikaz;

    /**
     * Initializes the command map and assigns available commands to their respective objects.
     */
    private void inicializace() {
        prikazy = new HashMap<>();
        prikazy.put("jdi", m); // Move command
        prikazy.put("inventar", op); // Open inventory command
        prikazy.put("prohledej", s); // Search command
        prikazy.put("exit", new Exit()); // Exit command
        prikazy.put("seber", p); // Pick up item command
        prikazy.put("pouzij", u); // Use item command
        prikazy.put("interakce", sp); // Interact command
        prikazy.put("help", new Help()); // Help command
        prikazy.put("napoveda", nap); // Hint command
        prikazy.put("vyhod", new Delete(p)); // Drop item command
    }

    /**
     * Processes user input and executes the corresponding command.
     */
    private void doCommand() {
        System.out.print(">");
        prikaz = sc.next();
        if (prikazy.containsKey(prikaz)) {
            System.out.println(prikazy.get(prikaz).execute());
            exit = prikazy.get(prikaz).exit();
        } else {
            System.out.println("Pokud si nejste jisty s prikazy, zadejte prikaz help");
        }
    }

    /**
     * Writes the starting position of the player to a file at the start of the game.
     */
    private void writeStart() {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/Game/position"));
            bufferedWriter.write(m.cm.getStart());
            bufferedWriter.newLine();
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Starts the game by initializing commands, handling user input, and controlling the game loop.
     */
    public void start() {
        writeStart();
        story.startStory();
        inicializace();
        do {
            doCommand();
            boolean end = story.controlEndStory();
            if (end) {
                story.endStory();
                exit = true;
            }
        } while (!exit);
    }
}

