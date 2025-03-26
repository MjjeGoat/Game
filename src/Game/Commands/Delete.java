package Game.Commands;

import Game.CreateMap;
import Game.Inventory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Delete extends Command {

    PickedUp pickedUp = new PickedUp();
    Scanner sc = new Scanner(System.in);

    public Delete(PickedUp pickedUp) {
        this.pickedUp = pickedUp;
    }

    @Override
    public String execute() {
        System.out.println("Zadejte jaky predmet chcete vyhodit");
        System.out.println("Vas inventar: " + pickedUp.inv.getInventory());
        String which = sc.nextLine();
        if (pickedUp.inv.getInventory().contains(which)) {
            pickedUp.inv.getInventory().remove(which);
            return "Odstranili jste item " + which;
        }else {
            return "Tento predmet vas inventar neobsahuje";
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}
