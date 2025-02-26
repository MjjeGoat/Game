import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Movement {
    CreateMap cm = new CreateMap();
    Scanner sc = new Scanner(System.in);

    public boolean moving() {
        String where = " ";
        ArrayList<String> location = new ArrayList<>();
        cm.loadMap();
        while (where != "konec") {
        for (Location lokace : cm.getMap().values()) {
            if (lokace.getName().equals(cm.getCurrentpos())) {
                    System.out.println("Zadejte kam chcete jit: " + Arrays.toString(lokace.getLocations()));
                    where = sc.nextLine().trim();
                    for (int i = 0; i < lokace.getLocations().length; i++) {
                        location.add(lokace.getLocations()[i]);
                    }
                    for (int i = 0; i < location.size(); i++) {
                        if (where.equals(location.get(i))) {
                            cm.setCurrentpos(location.get(i));
                        }
                    }

                }
            }
            System.out.println("Nachazite se v :" + cm.getCurrentpos());
        }
        return true;
    }


}
