/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package project;

import javax.swing.JButton;
import javax.swing.JPanel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ycorrales2016
 */

public class ADashboardFrameTest {
    
    private ADashboardFrame aDashboardFrame;

    @BeforeEach
    public void setUp() {
        aDashboardFrame = new ADashboardFrame();
    }

     /**
     * Test of AddMenuItems, of class ADashboardFrame.
     */
    @Test
    public void testAddMenuItems() {
        JPanel menuPanel = new JPanel();
        aDashboardFrame.addMenuItems(menuPanel);
        assertTrue(menuPanel.getComponentCount() > 0, "Menu panel should have components added to it");
    }
}