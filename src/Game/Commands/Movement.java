import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Movement extends Command {
    CreateMap cm = new CreateMap();
    Scanner sc = new Scanner(System.in);

    @Override
    public String execute() {
        String where = " ";
        cm.loadMap();
        System.out.println("Nachazite se v: " + cm.getCurrentpos());
        for (Location lokace : cm.getMap().values()) {
            int a = 0;
            if (lokace.getName().equals(cm.getCurrentpos())) {
                System.out.println("Zadejte kam chcete jit: " + Arrays.toString(lokace.getLocations()));
                where = sc.nextLine().trim();
                if (where.equals("konec cestovani")) {
                    break;
                }
                for (int i = 0; i < lokace.getLocations().length; i++) {
                    if (where.equals(lokace.getLocations()[i])) {
                        cm.setCurrentpos(lokace.getLocations()[i]);
                        i = lokace.getLocations().length;
                        a++;
                        return "Nachazite se v :" + cm.getCurrentpos();
                    }
                }
                if (a < 1) {
                    return "Spatne zkus to znovu";
                }
            }
        }
        return "cestovani dokonceno";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
