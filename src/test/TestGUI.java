package test;

import org.junit.Test;
import production.GUI;
import production.SOSGame;
import javax.swing.*;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
public class TestGUI {
    @Test
    public void testGUIConstructor() {
        SOSGame game = new SOSGame(3);
        GUI gui = new GUI(game);

        assertEquals("SOS game", gui.getTitle());
        assertFalse(gui.isAlwaysOnTop());
        assertNotNull(gui.getContentPane());
        assertNotNull(gui.getName());
        assertEquals(JFrame.EXIT_ON_CLOSE, gui.getDefaultCloseOperation());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
