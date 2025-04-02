package Tests;

import Game.CreateMap;
import Game.Location;
import Game.Person;
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
        boolean result = createMap.loadMap();
        assertTrue(result);
        Map<String, Location> map = createMap.getMap();
        assertEquals(12, map.size());
        assertTrue(map.containsKey("Alexova Loznice"));
        assertTrue(map.containsKey("Alexova Kuchyne"));
        assertTrue(map.containsKey("Alexova Chodba"));
        assertTrue(map.containsKey("Vlakove Nadrazi"));
        assertTrue(map.containsKey("Zahrada Jamese Hammera"));
        assertTrue(map.containsKey("Alexova Kuchyne"));
        assertTrue(map.containsKey("Alexova Kuchyne"));
        assertTrue(map.containsKey("Alexova Kuchyne"));
        assertTrue(map.containsKey("Alexova Kuchyne"));
        assertTrue(map.containsKey("Alexova Kuchyne"));
        assertTrue(map.containsKey("Alexova Kuchyne"));
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

        boolean result = createMap.loadPersons();

        assertTrue(result);

        Map<String, Person> persons = createMap.getPersons();
        assertEquals(7, persons.size());
        assertTrue(persons.containsKey("Televize"));
        assertTrue(persons.containsKey("Budik"));
        assertTrue(persons.containsKey("Drez"));
        assertTrue(persons.containsKey("Kolemjdouci"));
        assertTrue(persons.containsKey("Dealer"));
        assertTrue(persons.containsKey("Zahradnik"));
        assertTrue(persons.containsKey("Zvonek"));
    }
}
