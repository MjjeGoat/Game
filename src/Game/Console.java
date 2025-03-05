import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Console {

    private Scanner sc = new Scanner(System.in);
    private boolean exit = false;
    private HashMap<String, Command> prikazy;

    private void inicializace(){
        prikazy = new HashMap<>();
        prikazy.put("jdi", new Movement());

    }

    private void doCommand(){
        System.out.print(">");
        String prikaz = sc.next();
        if (prikazy.containsKey(prikaz)){
            System.out.println(prikazy.get(prikaz).execute());
            exit = prikazy.get(prikaz).exit();
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
