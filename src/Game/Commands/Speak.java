package Game.Commands;

import Game.CreateMap;
import Game.Person;

import java.io.*;
import java.util.Scanner;

public class Speak extends Command {

    CreateMap cm = new CreateMap();
    Scanner sc = new Scanner(System.in);

    private void rewrite() {
        if (counter == 0) {
            cm.setCurrentpos(cm.getStart());
        }else {
            File file = new File("src/Game/poloha");
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
        cm.loadPersons();
        System.out.println("Zadejte jakou osobu chcete oslovit");
        String who = sc.next();
        for (Person person:cm.getPersons().values()){
            if (person.getLocation().equals(cm.getCurrentpos())){
                if (person.getName().equals(who)){
                    try {
                        sc.nextLine();
                        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/Dialogues/" + person.getDialogue()));
                        String line;
                        while((line = bufferedReader.readLine()) != null){
                            System.out.println(line);
                            System.out.println("Stisknete ENTER pro pokracovani");
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
