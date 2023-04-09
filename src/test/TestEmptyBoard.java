package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import production.SOSGame;
public class TestEmptyBoard {
    private SOSGame game;
    @Before
    public void setUp() throws Exception {
        game = new SOSGame(3);
    }
    @After
    public void tearDown() throws Exception {
    }
    @Test
    public void testEmptyBoard() {
        new SOSGame(3);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}