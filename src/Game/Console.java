package Game;

import java.util.HashMap;
import java.util.Scanner;
import Game.Commands.*;

public class Console {


    PickedUp p = new PickedUp();
    Use u = new Use(p);
    Movement m = new Movement(u);
    Search s = new Search(p);
    OpenInventory op = new OpenInventory(p);
    Speak sp = new Speak();
    private Scanner sc = new Scanner(System.in);
    private boolean exit = false;
    private HashMap<String, Command> prikazy;


    private void inicializace(){
        prikazy = new HashMap<>();
        prikazy.put("jdi", m);
        prikazy.put("inventar", op);
        prikazy.put("prohledej", s);
        prikazy.put("exit", new Exit());
        prikazy.put("seber", p);
        prikazy.put("pouzij", u);
        prikazy.put("mluv",sp);

    }

    private void doCommand(){
        System.out.print(">");
        String prikaz = sc.next();
        if (prikazy.containsKey(prikaz)){
            System.out.println(prikazy.get(prikaz).execute());
            exit = prikazy.get(prikaz).exit();
            u.counter++;
            op.counter++;
            m.counter++;
            s.counter++;
            p.counter++;
        }else {
            System.out.println("neplati");
        }
    }


    public void start(){
        inicializace();
        do {
            doCommand();

        }while(!exit);
    }
}
