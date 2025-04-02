package Tests;

import Game.CreateMap;
import Game.Story;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StoryTest {

    Story story = new Story();

    @Test
    void controlEndStory() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("src/Game/position", false));
            bw.write("Jeskyne");
            bw.newLine();
            bw.flush();
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        assertTrue(story.controlEndStory(),"Metoda by mela vracet true, protoze v souboru je zapsana jeskyne");
    }
}