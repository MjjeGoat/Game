import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class CreateMap {

    private HashMap<String, Location> map = new HashMap<>();

    private String start = "Alexova Loznice";
    private String currentpos = start;

    public void setCurrentpos(String currentpos) {
        this.currentpos = currentpos;
    }

    public String getCurrentpos() {
        return currentpos;
    }

    public boolean loadMap() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/Mapa"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] lines = line.split(", ");
                Location location = new Location(lines[0], Arrays.copyOfRange(lines,1,lines.length));
                map.put(lines[0],location);
            }


            return true;
        } catch (
                IOException e) {
             return false;
        }
    }

    public boolean loadItems() {
        return true;
    }

    public HashMap<String, Location> getMap() {
        return map;
    }
}
