package project;

import javax.swing.JButton;
import javax.swing.JFrame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ViewManagerTest {

    private ViewManager viewManager;

    @BeforeEach
    void setUp() {
        viewManager = ViewManager.getInstance();    }
    /**
     * Test of getInstance method, of class ViewManager.
     */
    @Test
    void testGetInstance() {
        assertNotNull(viewManager, "ViewManager instance should not be null");
    }
    /**
     * Test of setVisibility method, of class ViewManager.
     */
    @Test
    void testSetVisibility() {
        JFrame testFrame = new JFrame();
        viewManager.setVisibility(testFrame, true);
        assertTrue(testFrame.isVisible(), "Frame should be visible");

        viewManager.setVisibility(testFrame, false);
        assertFalse(testFrame.isVisible(), "Frame should not be visible");
    }
    /**
     * Test of attachListener method, of class ViewManager.
     */
    @Test
    void testAttachListener() {
        JButton testButton = new JButton();
        viewManager.attachListener(testButton, e -> {});
        assertFalse(testButton.getActionListeners().length == 0, "Button should have an action listener attached");
    }
    /**
     * Test of getLoginFrame method, of class ViewManager.
     */
    @Test
    void testGetLoginFrame() {
        viewManager.refreshLoginFrame(); 
        assertNotNull(viewManager.getLoginFrame(), "LoginFrame should not be null");
    }
    /**
     * Test of getNDashboardFrame method, of class ViewManager.
     */
    @Test
    void testGetNDashboardFrame() {
        viewManager.refreshNDashboardFrame();
        assertNotNull(viewManager.getNDashboardFrame(), "NDashboardFrame should not be null");
    }
    /**
     * Test of refreshLoginFrame method, of class ViewManager.
     */
    @Test
    void testRefreshLoginFrame() {
        viewManager.refreshLoginFrame();
        assertNotNull(viewManager.getLoginFrame(), "After refresh, LoginFrame should not be null");
    }
    /**
     * Test of refreshNDashboardFrame method, of class ViewManager.
     */
    @Test
    void testRefreshNDashboardFrame() {
        viewManager.refreshNDashboardFrame();
        assertNotNull(viewManager.getNDashboardFrame(), "After refresh, NDashboardFrame should not be null");
    }
}
