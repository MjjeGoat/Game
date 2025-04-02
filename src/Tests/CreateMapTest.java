package Game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CreateMapTest {


    private CreateMap createMap; //

    @BeforeEach
    void setUp() {
        createMap = new CreateMap();
    }

    @Test
    void testLoadMapSuccess() throws IOException {
        File tempFile = new File("src/Game/Mapa");
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        writer.write("1, Location1, Type1, Desc1, extra1, extra2, extra3\n");
        writer.write("2, Location2, Type2, Desc2, extra4, extra5, extra6\n");
        writer.close();

        boolean result = createMap.loadMap();

        assertTrue(result);

        Map<String, Location> map = createMap.getMap();
        assertEquals(2, map.size());
        assertTrue(map.containsKey("Location1"));
        assertTrue(map.containsKey("Location2"));

        tempFile.delete();
    }

    @Test
    void testLoadMapFailure() throws IOException {
        File nonExistentFile = new File("src/Game/NonExistentMapa");
        boolean result = createMap.loadMap();
        assertFalse(result);
    }


    @Test
    void testLoadPersonsFailure() {
        File nonExistentFile = new File("src/Game/NonExistentPersons");
        assertFalse(nonExistentFile.exists(), "The file should not exist!");

        boolean result = createMap.loadPersons();

        assertFalse(result, "loadPersons should return false when the file doesn't exist.");
    }

    @Test
    void testLoadPersonsSuccess() throws IOException {
        File tempFile = new File("src/Game/Persons");
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        writer.write("John Doe, jdoe@example.com, 123-456-7890\n");
        writer.write("Jane Smith, jsmith@example.com, 987-654-3210\n");
        writer.close();

        boolean result = createMap.loadPersons();

        assertTrue(result);

        Map<String, Person> persons = createMap.getPersons();
        assertEquals(2, persons.size());
        assertTrue(persons.containsKey("John Doe"));
        assertTrue(persons.containsKey("Jane Smith"));

        tempFile.delete();
    }
}
