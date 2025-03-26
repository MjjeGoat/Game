package Game;

import Game.Commands.Use;

import java.util.Arrays;

public class Location {
private String name;
private String hint;

    public String getName() {
        return name;
    }

    public String[] getLocations() {return locations;
    }

    private String[] locations;
    private String whatItem;

    public boolean isLock() {
        return lock;
    }

    public void setLock(boolean lock) {
        this.lock = lock;
    }

    public String getMsg() {
        return msg;
    }

    public String getOpenDoor() {
        return openDoor;
    }

    public String getWhatItem() {
        return whatItem;
    }

    public int getIndex() {
        return index;
    }

    public String getHint() {
        return hint;
    }

    private boolean lock = false;
    private String msg;
    private String openDoor;
    private int index;


    public Location(int index,String name, String openDoor, String msg,String whatItem, String[] locations,String hint) {
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

    @Override
    public String toString() {
        return "Game.Location{" +
                "name='" + name + '\'' +
                ", locations=" + Arrays.toString(locations) +
                '}';
    }
}
