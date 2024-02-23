package project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ChangePasswordFrameTest {
    
    private ChangePasswordFrame changePasswordFrame;

    @BeforeEach
    public void setUp() {
        changePasswordFrame = new ChangePasswordFrame();
    }
    /**
     * Test of getFrame method, of class ChangePasswordFrame.
     */
    @Test
    public void testGetFrame() {
        assertNotNull(changePasswordFrame.getFrame(), "Frame should not be null");
    }
    /**
     * Test of getSubmitChangeBtn method, of class ChangePasswordFrame.
     */

}
