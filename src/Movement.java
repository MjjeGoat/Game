import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Movement {
    CreateMap cm = new CreateMap();
    Scanner sc =new Scanner(System.in);

    public boolean moving() {
        String where = " ";
        cm.loadMap();
        while (!where.equals("konec")) {
            for (Location lokace : cm.getMap().values()) {
                int a = 0;
                if (lokace.getName().equals(cm.getCurrentpos())) {
                    System.out.println("Zadejte kam chcete jit: " + Arrays.toString(lokace.getLocations()));
                    where = sc.nextLine().trim();
                    if (where.equals("konec")) {
                        break;
                    }
                    for (int i = 0; i < lokace.getLocations().length; i++) {
                        if (where.equals(lokace.getLocations()[i])){
                            cm.setCurrentpos(lokace.getLocations()[i]);
                            i = lokace.getLocations().length;
                            a++;
                        }
                    }
                    if (a < 1) {
                        System.out.println("Spatne zkus to znovu");
                    }
                    break;
                }
            }
            System.out.println("Nachazite se v :" + cm.getCurrentpos());
        }
        return true;
    }


}
