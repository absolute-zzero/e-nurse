
package project;

import javax.swing.JButton;
import javax.swing.JFrame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


/**
 *
 * @author ycorrales2016
 */
public class AShiftsFrameTest {
    
    private AShiftsFrame aShiftsFrame;

    @BeforeEach
    public void setUp() {
        aShiftsFrame = new AShiftsFrame();
    }
    
    /**
     * Test of GetFrame, of class AShiftsFrame.
     */
    @Test
    public void testGetFrame() {
        assertNotNull(aShiftsFrame.getFrame(), "Frame should not be null");
        assertTrue(aShiftsFrame.getFrame() instanceof JFrame, "Frame should be an instance of JFrame");
    }
     /**
     * Test of GetRemoveBtn, of class AShiftsFrame.
     */


}
