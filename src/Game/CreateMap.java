package Game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class CreateMap {

    private HashMap<String, Location> map = new HashMap<>();
    private HashMap<String, Structure> items = new HashMap<>();
    private HashMap<String, Person> persons = new HashMap<>();

    private String start = "Alexova Loznice";
    private String currentpos = start;

    public void setCurrentpos(String currentpos) {
        this.currentpos = currentpos;
    }

    public String getCurrentpos() {
        return currentpos;
    }

    public String getStart() {
        return start;
    }

    public boolean loadMap() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/Game/Mapa"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] lines = line.split(", ");
                Location location = new Location(Integer.parseInt(lines[0]), lines[1], lines[2], lines[3], lines[4], Arrays.copyOfRange(lines, 6, lines.length), lines[5]);
                map.put(lines[1], location);
            }
            return true;
        } catch (
                IOException e) {
            return false;
        }
    }

    public boolean loadPersons() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/Game/Persons"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] lines = line.split(", ");
                Person person = new Person(lines[0], lines[1], lines[2]);
                persons.put(lines[0], person);
            }
            return true;
        } catch (
                IOException e) {
            return false;
        }
    }


    public boolean loadItems() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/Game/Struktury"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] lines = line.split(", ");
                Structure structure = new Structure(lines[0], lines[1], Arrays.copyOfRange(lines, 2, lines.length));
                items.put(lines[1], structure);
            }
            return true;
        } catch (
                IOException e) {
            return false;
        }
    }

    public HashMap<String, Location> getMap() {
        return map;
    }

    public HashMap<String, Structure> getItems() {
        return items;
    }

    public HashMap<String, Person> getPersons() {
        return persons;
    }
}
