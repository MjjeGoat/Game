package Game;

public class Structure {
    private String[] items;
    private String location;

    private String name;

    public Structure(String location, String name, String[] items) {
        this.items = items;
        this.name = name;
        this.location = location;
    }

    public String[] getItems() {
        return items;
    }

    public String getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }
}
