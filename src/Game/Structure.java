package Game;

/**
 * Represents a structure in the game, which may contain items and has a location.
 * Provides methods to retrieve the name, location, and items of the structure.
 */
public class Structure {

    private String[] items;

    private String location;

    private String name;

    /**
     * Constructs a Structure object with the given location, name, and items.
     * @param location the location of the structure
     * @param name the name of the structure
     * @param items an array of items contained within the structure
     */
    public Structure(String location, String name, String[] items) {
        this.items = items;
        this.name = name;
        this.location = location;
    }

    /**
     * Retrieves the items contained within the structure.
     * @return an array of items contained in the structure
     */
    public String[] getItems() {
        return items;
    }

    /**
     * Retrieves the location of the structure.
     * @return the location of the structure
     */
    public String getLocation() {
        return location;
    }

    /**
     * Retrieves the name of the structure.
     * @return the name of the structure
     */
    public String getName() {
        return name;
    }
}

