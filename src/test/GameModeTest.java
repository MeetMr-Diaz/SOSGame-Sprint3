package test;

import org.junit.jupiter.api.Test;
import production.SOSGame;

import static org.junit.jupiter.api.Assertions.*;
public class GameModeTest {
    @Test
    public void simpleMode() {
        int n = 5;

        SOSGame game = new SOSGame(n);
        assertEquals(SOSGame.GameModeType.Simple, game.getCurrentGameType());
    }
    @Test
    public void generalMode() {
        int n = 5;

        SOSGame game = new SOSGame(n);
        game.setCurrentGameType(SOSGame.GameModeType.General) ;
        assertEquals(SOSGame.GameModeType.General, game.getCurrentGameType());
    }
}