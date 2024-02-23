package project;

import javax.swing.JButton;
import javax.swing.JFrame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginFrameTest {
    
    private LoginFrame loginFrame;

    @BeforeEach
    public void setUp() {
        loginFrame = new LoginFrame();
    }

    /**
     * Test of getFrame method, of class LoginFrame.
     */
    @Test
    public void testGetFrame() {
        assertNotNull(loginFrame.getFrame(), "Frame should not be null");
    }
}
