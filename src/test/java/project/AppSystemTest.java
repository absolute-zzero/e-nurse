/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package project;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author ycorrales2016
 */
public class AppSystemTest {
    
    private AppSystem appSystem;

    @BeforeEach
    public void setUp() {
        appSystem = AppSystem.getInstance();
        int testID = 123;
        Nurse expectedNurse = new Nurse(testID, "TestName", "TestPassword");
       
    }
    
    /**
     * Test of getInstance method, of class AppSystem.
     */
    @Test
    public void testGetInstance() {
        AppSystem firstInstance = AppSystem.getInstance();
        AppSystem secondInstance = AppSystem.getInstance();
        assertSame(firstInstance, secondInstance, "Singleton instances should be the same");
    }

    /**
     * Test of getCurrentNurse method, of class AppSystem.
     */
    @Test
    public void testGetCurrentNurse() {
        assertNull(appSystem.getCurrentNurse(), "Should return null if no current nurse is set");
    }

    /**
     * Test of setCurrentID method, of class AppSystem.
     */
    @Test
    public void testSetCurrentID() {
        int testID = 123;
        Nurse expectedNurse = new Nurse(testID, "TestName", "TestPassword");
        appSystem.addNurse(expectedNurse); 

        appSystem.setCurrentID(testID); 
        Nurse actualNurse = appSystem.getCurrentNurse(); 

        assertNotNull(actualNurse, "Current nurse should not be null");
        assertEquals(expectedNurse.getID(), actualNurse.getID(), "The IDs should match");
}

    /**
     * Test of getNurseList method, of class AppSystem.
     */
    @Test
    public void testGetNurseList() {
        int testID = 123;
        Nurse expectedNurse = new Nurse(testID, "TestName", "TestPassword");
        appSystem.addNurse(expectedNurse); 
        ArrayList<Nurse> nurses = appSystem.getNurseList();
        assertNotNull(nurses, "Nurse list should not be null");
        assertTrue(nurses.contains(expectedNurse), "Nurse list should contain the added nurse");
    
    }

    /**
     * Test of getAvailableShifts method, of class AppSystem.
     */
    @Test
    public void testGetAvailableShifts() {

        assertNotNull(appSystem.getAvailableShifts(), "Available shifts list should not be null");

    }

    /**
     * Test of getAdminID method, of class AppSystem.
     */
    @Test
    public void testGetAdminID() {
        //AdminID is hard coded to be 1000
        assertEquals(appSystem.getAdminID(), 1000, "The IDs should match");
    }

    /**
     * Test of verifyLogin method, of class AppSystem.
     */
    @Test
    public void testVerifyLogin() {
        assertEquals(appSystem.verifyLogin(123, "TestPassword"), true, "Return of login and true should match");
    }

    /**
     * Test of verifyOldPass method, of class AppSystem.
     */
    @Test
    public void testVerifyOldPass() {
        
        appSystem.setCurrentID(123); 
        boolean changeResult = appSystem.verifyOldPass("TestPassword", "NewPassword"); 
        assertTrue(changeResult, "Password change should be successful with correct old password");
    }


    /**
     * Test of deleteNurse method, of class AppSystem.
     */
    @Test
    public void testDeleteNurse() {
        Nurse expectedNurse = new Nurse(1002, "TestName", "TestPassword");
        appSystem.addNurse(expectedNurse); 
        int sizeBeforeDeletion = appSystem.getNurseList().size();
        appSystem.deleteNurse(123); 
        assertEquals(sizeBeforeDeletion - 1, appSystem.getNurseList().size(), "Nurse list should decrease by 1 after deletion");
    }


    /**
     * Test of getShiftList method, of class AppSystem.
     */
    @Test
    public void testGetShiftList() {
        assertNotNull(appSystem.getAvailableShifts(), "Shift list should not be null");
    }

    
}


