package Game;


/**
 * Represents a person in the game. Contains information about the person's name, location, and dialogue.
 */
public class Person {

    /** The location of the person. */
    private String location;

    /** The file containing the dialogue for the person. */
    private String dialogue;

    /** The name of the person. */
    private String name;

    /**
     * Returns the dialogue associated with the person.
     * @return the dialogue string
     */
    public String getDialogue() {
        return dialogue;
    }

    /**
     * Returns the location of the person.
     * @return the location string
     */
    public String getLocation() {
        return location;
    }

    /**
     * Returns the name of the person.
     * @return the name string
     */
    public String getName() {
        return name;
    }

    /**
     * Constructs a Person with the specified name, dialogue, and location.
     * @param name the name of the person
     * @param dialogue the dialogue associated with the person
     * @param location the location of the person
     */
    public Person(String name, String dialogue, String location) {
        this.location = location;
        this.dialogue = dialogue;
        this.name = name;
    }
}

