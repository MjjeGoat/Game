package Game.Commands;
import Game.CreateMap;
import Game.Person;
import Game.Structure;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Search extends Command {
    Scanner scanner = new Scanner(System.in);
    private int howManySearch = 0;

    public void setHowMany(int howMany) {
        this.howManySearch = howMany;
    }

    public int getHowMany() {
        return howManySearch;
    }

    PickedUp p = new PickedUp();

    public Search(PickedUp p) {
        this.p = p;
    }


    private void rewrite() {
        if (counter == 0) {
            p.cm.setCurrentpos(p.cm.getStart());
        } else {
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
        p.cm.loadItems();
        p.cm.loadPersons();
        boolean foundS = false;
        boolean foundP = false;
        boolean correct = false;
        for (Person person : p.cm.getPersons().values()) {
            if (person.getLocation().equals(p.cm.getCurrentpos())) {
                System.out.println("V teto lokaci se nachazi osoba: " + person.getName());
                foundP = true;
            }
        }
        if (!foundP) {
            System.out.println("V teto lokaci se nenachazi zadna osoba");
        }

        for (Structure structure : p.cm.getItems().values()) {
            if (structure.getLocation().equals(p.cm.getCurrentpos())) {
                System.out.println("V teto lokaci se nachazi objekt: " + structure.getName());
                foundS = true;
            }
        }
        if (!foundS) {
            return "V teto lokaci se nenachazi zadny objekt na prohledani";
        }

        System.out.println("Zadejte co chcete prohledat");
        String search = scanner.nextLine().trim();

        for (Structure structure : p.cm.getItems().values()) {
            if (search.equals(structure.getName())) {
                ArrayList<String> dostupnePredmety = new ArrayList<>();

                for (String item : structure.getItems()) {
                    if (!p.inv.getInventory().contains(item)) {
                        dostupnePredmety.add(item);
                    }
                }

                if (dostupnePredmety.isEmpty()) {
                    System.out.println(structure.getName() + " je prázdný.");
                } else {
                    System.out.println(structure.getName() + " obsahuje " + dostupnePredmety);
                }

                correct = true;
            }
        }

        if (!correct) {
            return "Tento objekt se v mistnosti nenachazi";
        }

        return "";
    }


    @Override
    public boolean exit() {
        return false;
    }
}
