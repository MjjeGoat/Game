package Game.Commands;

import Game.CreateMap;
import Game.Person;

import java.io.*;
import java.util.Scanner;

public class Speak extends Command {

    PickedUp pickedUp = new PickedUp();
    Scanner sc = new Scanner(System.in);

    private void rewrite() {
        if (counter == 0) {
            pickedUp.cm.setCurrentpos(pickedUp.cm.getStart());
        }else {
            File file = new File("src/Game/poloha");
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line = br.readLine();
                pickedUp.cm.setCurrentpos(line);
                br.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void rewriteLocation() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("src/Game/poloha", false));
            bw.write(pickedUp.cm.getCurrentpos());
            bw.newLine();
            bw.flush();
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String execute() {
        rewrite();
        pickedUp.cm.loadPersons();
        System.out.println("Zadejte jakou osobu chcete oslovit");
        String who = sc.next();
        for (Person person:pickedUp.cm.getPersons().values()){
            if (person.getLocation().equals(pickedUp.cm.getCurrentpos())){
                if (person.getName().equals(who)){
                    System.out.println("k");
                    try {
                        sc.nextLine();
                        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/Game/" + person.getDialogue()));
                        String line;
                        while((line = bufferedReader.readLine()) != null){
                            System.out.println(line);
                            sc.nextLine();
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }else {
                    return "Tato osoba se zde nenachazi";
                }
            }
        }
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
