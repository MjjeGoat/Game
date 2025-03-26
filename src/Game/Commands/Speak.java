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
        cm.loadPersons();
        System.out.println("Zadejte s kym/cim chcete interagovat");
        String who = sc.next();
        boolean foundL = false;
        for (Person person:cm.getPersons().values()){
            if (person.getLocation().equals(cm.getCurrentpos())){
                if (person.getName().equals(who)){
                    foundL = true;
                    try {
                        sc.nextLine();
                        BufferedReader bufferedReader = new BufferedReader(new FileReader(person.getDialogue()));
                        String line;
                        while((line = bufferedReader.readLine()) != null){
                            System.out.println(line);
                            System.out.println("Stisknete ENTER pro pokracovani");
                            sc.nextLine();
                        }
                        break;
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                if (foundL == false){
                    return "Tato osoba se zde nenachazi";
                }
            }

        }
        if (foundL == false){
            return "V teto lokaci se nenachazi zadna osoba/vec na interakci";
        }
        return " ";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
