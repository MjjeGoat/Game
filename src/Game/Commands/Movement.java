package Game.Commands;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

import Game.*;
import Game.Console;

public class Movement extends Command {
    public CreateMap cm = new CreateMap();
    Scanner sc = new Scanner(System.in);
    PickedUp pickedUp = new PickedUp();
    Use use = new Use(pickedUp);



    public boolean lockedDoor(Location location) {
        if (location.getName().equals(cm.getCurrentpos())) {
            if (use.p.inv.getUsedItems().contains(location.getOpenDoor())) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public Movement(Use use) {
        this.use = use;
    }

    private void rewrite() {
        if (counter == 0){
            cm.setCurrentpos(cm.getStart());
        }else {
            try {
                File file = new File("src/Game/position");
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line = br.readLine();
                cm.setCurrentpos(line);
                br.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void writeLocation() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("src/Game/position", false));
            bw.write(cm.getCurrentpos());
            bw.newLine();
            bw.flush();
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String execute() {
        String where = " ";
        rewrite();
        writeLocation();
        cm.loadMap();
        System.out.println("Nachazite se v: " + cm.getCurrentpos());
        for (Location lokace : cm.getMap().values()) {
            int a = 0;
            if (lokace.getName().equals(cm.getCurrentpos())) {
                System.out.println("Zadejte kam chcete jit: " + Arrays.toString(lokace.getLocations()));
                where = sc.nextLine().trim();
                    for (int i = 0; i < lokace.getLocations().length; i++) {
                        if (where.equals(lokace.getLocations()[i])) {
                            for(Location loc : cm.getMap().values()) {
                                if (loc.getName().equals(where)){
                                    if (lokace.getIndex()>=loc.getIndex()) {
                                        cm.setCurrentpos(lokace.getLocations()[i]);
                                        i = lokace.getLocations().length;
                                        a++;
                                        writeLocation();
                                        return "Nachazite se v :" + cm.getCurrentpos();
                                    } else if (lockedDoor(lokace)) {
                                        cm.setCurrentpos(lokace.getLocations()[i]);
                                        i = lokace.getLocations().length;
                                        a++;
                                        writeLocation();
                                        return "Nachazite se v :" + cm.getCurrentpos();
                                    }else {
                                        writeLocation();
                                        return lokace.getMsg();
                                    }                                }
                            }
                        }
                    }
                    if (a < 1) {
                        writeLocation();
                        return "Spatne zkus to znovu";
                    }
            }
        }
        return "cestovani dokonceno";
    }

    @Override
    public boolean exit() {
        return false;
    }

    public String position() {
        return cm.getCurrentpos();
    }
}
