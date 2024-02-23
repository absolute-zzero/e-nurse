package project;

import javax.swing.JButton;
import javax.swing.JFrame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ShiftCreationFrameTest {

    private ShiftCreationFrame shiftCreationFrame;

    @BeforeEach
    public void setUp() {
        shiftCreationFrame = new ShiftCreationFrame();
    }
    /**
     * Test of getFrame method, of class ShiftCreationFrame.
     */
    @Test
    public void testGetFrame() {
        assertNotNull(shiftCreationFrame.getFrame(), "Frame should not be null");
        assertTrue(shiftCreationFrame.getFrame() instanceof JFrame, "Get Frame should be an instance of JFrame");

    }

}
