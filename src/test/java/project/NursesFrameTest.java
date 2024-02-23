/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package project;

import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author ycorrales2016
 */
public class NursesFrameTest {
    private NursesFrame nursesFrame;

    @BeforeEach
    public void setUp() {
        this.nursesFrame = new NursesFrame(); 

    }
    
    public NursesFrameTest() {
    }

    /**
     * Test of getFrame method, of class NursesFrame.
     */
    @Test
    public void testGetFrame() {
        assertNotNull(nursesFrame.getFrame(), "getFrame should return a non-null JFrame object");
        assertTrue(nursesFrame.getFrame() instanceof JFrame, "getFrame should return an instance of JFrame");
}



    
}
