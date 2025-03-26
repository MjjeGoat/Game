package Game.Commands;

import Game.CreateMap;
import Game.Inventory;
import Game.Structure;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class PickedUp extends Command {

    Inventory inv = new Inventory();
    Scanner sc = new Scanner(System.in);
    CreateMap cm = new CreateMap();

    private void rewrite() {
        if (counter == 0) {
            cm.setCurrentpos(cm.getStart());
        } else {
            File file = new File("src/Game/position");
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line = br.readLine();
                cm.setCurrentpos(line);
                br.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    @Override
    public String execute() {
        rewrite();
        cm.loadItems();
        System.out.println("Zadejte jaky predmet chcete sebrat");
        String which = sc.nextLine();
        if (inv.getInventory().size()<5){
            for (Structure structure : cm.getItems().values()) {
                if (structure.getLocation().equals(cm.getCurrentpos())) {
                    for (int i = 0; i < structure.getItems().length; i++) {
                        if (which.equals(structure.getItems()[i])) {
                            if (inv.getInventory().contains(structure.getItems()[i])||inv.getUsedItems().contains(structure.getItems()[i])){
                                return "Tento predmet jste uz sebrali";
                            } else {
                                inv.addItem(structure.getItems()[i]);
                                return "Sebrali jste : " + structure.getItems()[i];
                            }
                        }
                    }
                }
            }
        }else {
            return "Uz toho vice nepoberu";
        }
        return " Tento predmet se zde nenachazi";
    }
    @Override
    public boolean exit () {
        return false;
    }
}
