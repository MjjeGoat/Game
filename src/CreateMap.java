import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class CreateMap {


    BufferedReader br;

    {
        try {
            br = new BufferedReader(new FileReader("src/Mapa"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
