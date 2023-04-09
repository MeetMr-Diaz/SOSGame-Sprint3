package test;
import org.junit.Test;
import production.SOSGame;
import production.SOSGameGetters;

import static org.junit.Assert.*;
public class TestWinnerDraw {
    @Test
    public void testBlueWonSimple() {
        SOSGame game = new SOSGame(3);

        //Simple game mode, blue won
        game.setCurrentGameType(SOSGameGetters.GameModeType.Simple);
        game.initGame();
        game.makeMove(0, 0, 0);
        game.checkWinner();
        game.makeMove(0, 2, 1);
        game.checkWinner();
        game.makeMove(0, 1, 0);
        game.checkWinner();
        game.makeMove(1, 1, 0);
        game.checkWinner();
        game.makeMove(1, 0, 1);
        game.checkWinner();
        game.makeMove(2, 0, 1);
        game.checkWinner();
        game.makeMove(2, 1, 0);
        game.checkWinner();
        game.makeMove(2, 2, 1);
        game.checkWinner();
        game.makeMove(1, 2, 0);
        game.checkWinner();

        assertEquals(SOSGameGetters.GameState.BLUE_WON, game.getGameState());
    }
    @Test
    public void testDrawSimple() {
        SOSGame game = new SOSGame(3);

        //Simple game mode, draw
        game.setCurrentGameType(SOSGameGetters.GameModeType.Simple);
        game.initGame();
        game.makeMove(0, 0, 0);
        game.makeMove(0, 1, 0);
        game.makeMove(0, 2, 1);
        game.makeMove(1, 0, 1);
        game.makeMove(1, 1, 1);
        game.makeMove(1, 2, 1);
        game.makeMove(2, 0, 0);
        game.makeMove(2, 1, 0);
        game.makeMove(2, 2, 0);

        assertEquals(SOSGameGetters.GameState.DRAW, game.getGameState());
    }
    @Test
    public void testRedWonSimple() {
        SOSGame game = new SOSGame(3);

        // Simple game mode, red won
        game.setCurrentGameType(SOSGameGetters.GameModeType.Simple);
        game.initGame();
        game.makeMove(0, 0, 0);
        game.checkWinner();
        game.makeMove(1, 0, 0);
        game.checkWinner();
        game.makeMove(0, 1, 1);
        game.checkWinner();
        game.makeMove(1, 1, 0);
        game.checkWinner();
        game.makeMove(2, 2, 1);
        game.checkWinner();
        game.makeMove(2, 1, 0);
        game.checkWinner();
        game.makeMove(0, 2, 1);
        game.checkWinner();
        game.makeMove(1, 2, 0);
        game.checkWinner();
        game.makeMove(2, 0, 1);
        game.checkWinner();

        assertEquals(2, game.checkWinner());
    }
    @Test
    public void testGeneralDraw() {
        SOSGame game = new SOSGame(3);
        // General game mode, draw
        game.setCurrentGameType(SOSGameGetters.GameModeType.General);
        game.initGame();
        game.makeMove(0, 0, 0);
        game.makeMove(0, 1, 0);
        game.makeMove(0, 2, 1);
        game.makeMove(1, 0, 1);
        game.makeMove(1, 1, 1);
        game.makeMove(1, 2, 0);
        game.makeMove(2, 0, 0);
        game.makeMove(2, 1, 1);
        game.makeMove(2, 2, 0);
        assertEquals(3, game.checkWinner());
    }
    @Test
    public void testGeneralRedWinner() {
        SOSGame game = new SOSGame(3);

        game.setCurrentGameType(SOSGameGetters.GameModeType.General);
        game.initGame();
        game.makeMove(0, 0, 0);
        game.checkWinner();
        game.makeMove(1, 0, 0);
        game.checkWinner();
        game.makeMove(0, 1, 1);
        game.checkWinner();
        game.makeMove(1, 1, 0);
        game.checkWinner();
        game.makeMove(2, 2, 1);
        game.checkWinner();
        game.makeMove(2, 1, 0);
        game.checkWinner();
        game.makeMove(0, 2, 1);
        game.checkWinner();
        game.makeMove(1, 2, 0);
        game.checkWinner();
        game.makeMove(2, 0, 1);
        game.checkWinner();

        assertEquals(2, game.checkWinner());
    }
    @Test
    public void testGeneralBlueWinner() {
        SOSGame game = new SOSGame(3);

        game.setCurrentGameType(SOSGameGetters.GameModeType.General);
        game.initGame();
        game.makeMove(0, 0, 0);
        game.checkWinner();
        game.makeMove(0, 2, 1);
        game.checkWinner();
        game.makeMove(0, 1, 0);
        game.checkWinner();
        game.makeMove(1, 1, 0);
        game.checkWinner();
        game.makeMove(1, 0, 1);
        game.checkWinner();
        game.makeMove(2, 0, 1);
        game.checkWinner();
        game.makeMove(2, 1, 0);
        game.checkWinner();
        game.makeMove(2, 2, 1);
        game.checkWinner();
        game.makeMove(1, 2, 0);
        game.checkWinner();
        game.checkWinner();

        assertEquals(SOSGameGetters.GameState.BLUE_WON, game.getGameState());


    }

}