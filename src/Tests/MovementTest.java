package Tests;

import Game.Commands.Movement;
import Game.Commands.Use;
import Game.Location;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovementTest {

    @Test
    void lockedDoor() {
        Use use = new Use();
        Movement move = new Movement(use);
        use.p.inv.addUsedItem("Kolo");
        move.cm.setCurrentpos("Testovaci");
        Location l = new Location(0, "Testovaci", "Kolo", null, null, null, null);
        assertTrue(move.lockedDoor(l), "Metoda by mela vratit true");
    }
}