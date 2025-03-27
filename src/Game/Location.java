package Game;

import Game.Commands.Use;

import java.util.Arrays;

/**
 * Represents a location in the game. Contains information about the location's name, items, status, and associated hints.
 */
public class Location {

    /** The name of the location. */
    private String name;

    /** A name of file with hint associated with the location. */
    private String hint;

    /** List of available locations to which the player can move. */
    private String[] locations;

    /** The item what can be used in the location. */
    private String whatItem;

    /** Flag indicating if the location is locked. */
    private boolean lock = false;

    /** A message associated with the location if has not been used item to go to next location. */
    private String msg;

    /** The item that must be used to go to next location. */
    private String openDoor;

    /** The index of the location. */
    private int index;

    public Location(int index, String name, String openDoor, String msg, String whatItem, String[] locations, String hint) {
        this.locations = locations;
        this.msg = msg;
        this.name = name;
        this.openDoor = openDoor;
        this.whatItem = whatItem;
        this.index = index;
        this.hint = hint;
    }

    public Location() {
    }

    /**
     * Returns the name of the location.
     * @return the name of the location
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the list of available locations to move to.
     * @return an array of location names
     */
    public String[] getLocations() {
        return locations;
    }

    /**
     * Returns the hint associated with the location.
     * @return the hint string
     */
    public String getHint() {
        return hint;
    }

    /**
     * Checks if the location is locked.
     * @return true if the location is locked, false otherwise
     */
    public boolean isLock() {
        return lock;
    }

    /**
     * Sets the lock status of the location.
     * @param lock the lock status of the location
     */
    public void setLock(boolean lock) {
        this.lock = lock;
    }

    /**
     * Returns the message associated with the location.
     * @return the message string
     */
    public String getMsg() {
        return msg;
    }

    /**
     * Returns the item that must be used to go to next location.
     * @return the door string
     */
    public String getOpenDoor() {
        return openDoor;
    }

    /**
     * Returns the item that can be used at the location.
     * @return the item string
     */
    public String getWhatItem() {
        return whatItem;
    }

    /**
     * Returns the index of the location.
     * @return the index
     */
    public int getIndex() {
        return index;
    }

    /**
     * Returns a string representation of the Location object.
     * @return a string describing the Location
     */
    @Override
    public String toString() {
        return "Game.Location{" +
                "name='" + name + '\'' +
                ", locations=" + Arrays.toString(locations) +
                '}';
    }
}

