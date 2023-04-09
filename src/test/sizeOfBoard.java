package test;

import org.junit.jupiter.api.Test;
import production.SOSGame;

import static org.junit.jupiter.api.Assertions.*;
public class sizeOfBoard {
    @Test
    public void totalSquares() {
        int n = 5;

        SOSGame game = new SOSGame(n);

        assertEquals(n, game.getTotalRows());
        assertEquals(n, game.getTotalColumns());
        assertEquals(n * n, game.sizeBoard());
        assertNotNull(game.getGrid());
    }
}