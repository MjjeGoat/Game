package Game.Commands;

import Game.Commands.Command;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Help extends Command {
    Scanner sc = new Scanner(System.in);
    @Override
    public String execute() {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader("src/Game/help"));
                String line;
                while ((line = bufferedReader.readLine()) != null){
                    System.out.println(line);
                    System.out.println("Stisknete ENTER pro pokracovani");
                    sc.nextLine();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return "Ted uz by jste meli byt pripraveni na hru.";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
