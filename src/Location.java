import java.util.Arrays;

public class Location {
private String name;

    public String getName() {
        return name;
    }

    public String[] getLocations() {
        return locations;
    }

    private String[] locations;

    public Location(String name, String[] locations) {
        this.name = name;
        this.locations = locations;
    }


    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", locations=" + Arrays.toString(locations) +
                '}';
    }
}
