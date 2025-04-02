package Game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Represents the story in the game, managing the flow of dialogues and the game's progression.
 * Provides methods for starting the story, controlling the story's end, and displaying the ending.
 */
public class Story {

    Scanner sc = new Scanner(System.in);

    public CreateMap cm = new CreateMap();

    /**
     * Updates the current position of the player from the saved file.
     */
    private void rewrite() {
        File file = new File("src/Res/position");
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = br.readLine();
            cm.setCurrentpos(line);
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Starts the story by displaying the initial dialogue to the player.
     * The dialogue is read from a file and displayed line by line, awaiting user input to continue.
     */
    public void startStory() {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("src/Dialogues/telefonRozhovor"));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                System.out.println("Stisknete ENTER pro pokracovani");
                sc.nextLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Checks whether the story should end based on the player's current position.
     * The story ends when the player reaches the location "Jeskyne".
     * @return true if the story should end, false otherwise
     */
    public boolean controlEndStory() {
        rewrite();
        if (cm.getCurrentpos().equals("Jeskyne")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Ends the story by displaying the ending dialogue to the player.
     * The dialogue is read from a file and displayed line by line, awaiting user input to continue.
     */
    public void endStory() {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("src/Dialogues/ending"));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                System.out.println("Stisknete ENTER pro pokracovani");
                sc.nextLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        sc.close();
    }

}

