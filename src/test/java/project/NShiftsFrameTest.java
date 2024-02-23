package project;

import javax.swing.JFrame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NShiftsFrameTest {

    private NShiftsFrame nShiftsFrame;

    @BeforeEach
    public void setUp() {
        nShiftsFrame = new NShiftsFrame();
    }
    /**
     * Test of getFrame method, of class NShiftsFrame.
     */
    @Test
    public void testGetFrame() {
        assertNotNull(nShiftsFrame.getFrame(), "Frame should not be null");
        assertTrue(nShiftsFrame.getFrame() instanceof JFrame, "Frame should be an instance of JFrame");

    }


}
