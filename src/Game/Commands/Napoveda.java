package Game.Commands;

import Game.Commands.Command;
import Game.CreateMap;
import Game.Location;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Napoveda extends Command {

    CreateMap cm = new CreateMap();
    Scanner sc = new Scanner(System.in);

    private void rewrite(){
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
    @Override
    public String execute() {
        rewrite();
        cm.loadMap();
        for (Location lokace : cm.getMap().values()){
            if (lokace.getName().equals(cm.getCurrentpos())){
                try {
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(lokace.getHint()));
                    String line;
                    while((line = bufferedReader.readLine()) != null){
                        System.out.println(line);
                        System.out.println("Stisknete ENTER pro pokracovani");
                        sc.nextLine();
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return "Snad vam to pomohlo";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
