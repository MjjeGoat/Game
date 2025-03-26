package Game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Story {

    Scanner sc = new Scanner(System.in);
    CreateMap cm = new CreateMap();

    private void rewrite() {
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

    public void startStory() {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("src/Dialogues/telefonRozhovor"));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                System.out.println("Stisknete ENTER pro pokracovani");
                sc.nextLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean controlEndStory() {
        rewrite();
        if (cm.getCurrentpos().equals("Jeskyne")) {
            return true;
        } else {
            return false;
        }
    }

    public void endStory() {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("src/Dialogues/ending"));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                System.out.println("Stisknete ENTER pro pokracovani");
                sc.nextLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
