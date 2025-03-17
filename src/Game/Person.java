package Game;

import java.io.File;

public class Person {
    private String location;
    private String dialogue;
    private String name;

    public String getDialogue() {
        return dialogue;
    }

    public String getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public Person(String name, String dialogue, String location) {
        this.location = location;
        this.dialogue = dialogue;
        this.name = name;
    }
}
