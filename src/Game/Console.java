package Game;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

import Game.Commands.*;

public class Console {

    Napoveda nap = new Napoveda();
    Story story = new Story();
    PickedUp p = new PickedUp();
    Use u = new Use(p);
    Movement m = new Movement(u);
    Search s = new Search(p);
    OpenInventory op = new OpenInventory(p);
    Speak sp = new Speak();
    private Scanner sc = new Scanner(System.in);
    private boolean exit = false;
    private HashMap<String, Command> prikazy;
    String prikaz;


    private void inicializace() {
        prikazy = new HashMap<>();
        prikazy.put("jdi", m);
        prikazy.put("inventar", op);
        prikazy.put("prohledej", s);
        prikazy.put("exit", new Exit());
        prikazy.put("seber", p);
        prikazy.put("pouzij", u);
        prikazy.put("interakce", sp);
        prikazy.put("help", new Help());
        prikazy.put("napoveda",nap);
        prikazy.put("vyhod",new Delete(p));
    }

    private void doCommand() {
        System.out.print(">");
        prikaz = sc.next();
        if (prikazy.containsKey(prikaz)) {
            System.out.println(prikazy.get(prikaz).execute());
            exit = prikazy.get(prikaz).exit();
            if (prikaz.equals("jdi")) {
                u.counter++;
                op.counter++;
                m.counter++;
                s.counter++;
                p.counter++;
                sp.counter++;
                nap.counter++;
            }
        } else {
            System.out.println("Pokud si nejste jisty s prikazy, zadejte prikaz help");
        }
    }

    private void writeStart(){
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/Game/position"));
            bufferedWriter.write(m.cm.getStart());
            bufferedWriter.newLine();
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void start() {
        writeStart();
        story.startStory();
        inicializace();
        do {
         doCommand();
            boolean end =  story.controlEndStory();
            if (end) {
                story.endStory();
                exit = true;
            }
        } while (!exit);
    }
}
