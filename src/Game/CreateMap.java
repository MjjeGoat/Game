package Game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

/**
 * The CreateMap class is responsible for loading and managing the game map, structures, and characters.
 */
public class CreateMap {

    private HashMap<String, Location> map = new HashMap<>();
    private HashMap<String, Structure> items = new HashMap<>();
    private HashMap<String, Person> persons = new HashMap<>();

    private String start = "Alexova Loznice";
    private String currentpos = start;

    /**
     * Sets the current position of the player.
     * @param currentpos The new current position.
     */
    public void setCurrentpos(String currentpos) {
        this.currentpos = currentpos;
    }

    /**
     * Gets the current position of the player.
     * @return The current location name.
     */
    public String getCurrentpos() {
        return currentpos;
    }

    /**
     * Gets the starting position of the player.
     * @return The starting location name.
     */
    public String getStart() {
        return start;
    }

    /**
     * Loads the game map and other location information from a file.
     * @return True if the map was loaded successfully, false otherwise.
     */
    public boolean loadMap() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/Res/Mapa"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] lines = line.split(", ");
                Location location = new Location(
                        Integer.parseInt(lines[0]),
                        lines[1],
                        lines[2],
                        lines[3],
                        lines[4],
                        Arrays.copyOfRange(lines, 6, lines.length),
                        lines[5]
                );
                map.put(lines[1], location);
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * Loads the characters (persons) information in the game from a file.
     * @return True if the persons were loaded successfully, false otherwise.
     */
    public boolean loadPersons() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/Res/Persons"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] lines = line.split(", ");
                Person person = new Person(
                        lines[0],
                        lines[1],
                        lines[2]
                );
                persons.put(lines[0], person);
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * Loads objects (structures) information in the game from a file.
     * @return True if the items were loaded successfully, false otherwise.
     */
    public boolean loadItems() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/Res/Struktury"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] lines = line.split(", ");
                Structure structure = new Structure(
                        lines[0],
                        lines[1],
                        Arrays.copyOfRange(lines, 2, lines.length)
                );
                items.put(lines[1], structure);
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * Gets the map containing all locations.
     * @return The HashMap containing location names as keys and Location objects as values.
     */
    public HashMap<String, Location> getMap() {
        return map;
    }

    /**
     * Gets the map containing all structures.
     * @return The HashMap containing structure names as keys and Structure objects as values.
     */
    public HashMap<String, Structure> getItems() {
        return items;
    }

    /**
     * Gets the map containing all persons in the game.
     * @return The HashMap containing person names as keys and Person objects as values.
     */
    public HashMap<String, Person> getPersons() {
        return persons;
    }
}

