package Game.Commands;

import Game.Commands.Command;
import Game.CreateMap;
import Game.Location;

import java.io.*;
import java.util.Scanner;

public class Use extends Command {

    PickedUp p = new PickedUp();
    Scanner sc = new Scanner(System.in);

    public Use(PickedUp p) {
        this.p = p;
    }

    public Use() {
    }

    public void setWhat(String what) {
        this.what = what;
    }

    private String what = " ";

    public String getWhat() {
        return what;
    }



    private void rewrite() {
        if (counter == 0) {
            p.cm.setCurrentpos(p.cm.getStart());
        }else {
            File file = new File("src/Game/poloha");
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line = br.readLine();
                p.cm.setCurrentpos(line);
                br.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    @Override
    public String execute() {
        rewrite();
        p.cm.loadMap();
        System.out.println("Zadejte jaky predmet chcete pouzit");
        what = sc.nextLine();
        if (p.inv.getInventory().contains(what)) {
            for (Location location : p.cm.getMap().values()) {
                if (location.getName().equals(p.cm.getCurrentpos())){
                    if (location.getWhatItem().equals(what)) {
                        p.inv.getInventory().remove(what);
                        p.inv.addUsedItem(what);
                        return "pouzili jste " + what;
                    }else {
                        return "Tady tento predmet opravdu nevyuziju";
                    }
                }
            }
        } else {
            return "Tento predmet nemate";
        }
        return "Neco je spatne";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
