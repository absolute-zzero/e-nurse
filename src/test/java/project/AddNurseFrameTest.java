
package project;

import javax.swing.JButton;
import javax.swing.JFrame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AddNurseFrameTest {
    
    private AddNurseFrame addNurseFrame;

    @BeforeEach
    public void setUp() {
        addNurseFrame = new AddNurseFrame();
    }
    /**
     * Test of GetFrame, of class AddNurseFrame.
     */
    @Test
    public void testGetFrame() {
        assertNotNull(addNurseFrame.getFrame(), "Frame should not be null");
        assertTrue(addNurseFrame.getFrame() instanceof JFrame, "Frame should be an instance of JFrame");

    }

}
