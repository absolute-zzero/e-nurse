package project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;

public class ShiftManagerTest {

    private ShiftManager shiftManager;
    private ArrayList<Shift> shifts;
    private Shift testShift;
    private Nurse testNurse;

    @BeforeEach
    public void setUp() {
        shiftManager = new ShiftManager();
        shifts = new ArrayList<>();
        testShift = new Shift(1, true, "Hospital A", new Date());
        testNurse = new Nurse(1, "Test Nurse", "password123");
        AppSystem.setCurrentID(1); 
    }
    /**
     * Test of createShift method, of class ShiftManager.
     */
    @Test
    public void testCreateShift() {
        shiftManager.createShift(shifts, testShift);
        assertTrue(shifts.contains(testShift), "Shift should be added to the list");
    }
    /**
     * Test of cancelReservation method, of class ShiftManager.
     */
    @Test
    public void testCancelReservation() {
        shiftManager.createShift(shifts, testShift);
        shiftManager.reserveShift(testShift);
        shiftManager.cancelReservation(testShift);
        assertFalse(testNurse.getNurseSchedule().contains(testShift), "Shift should be removed from the nurse's schedule");
    }

    /**
     * Test of recreateShift method, of class ShiftManager.
     */
    @Test
    public void testRecreateShift() {
        shiftManager.recreateShift(shifts, testShift);
        assertTrue(shifts.contains(testShift), "Shift should be re-added to the list");
    }
    /**
     * Test of addShift method, of class ShiftManager.
     */
    @Test
    public void testAddShift() {
        shiftManager.addShift(testShift);
        assertTrue(AppSystem.getInstance().getAvailableShifts().contains(testShift), "Shift should be added to available shifts");
    }
    /**
     * Test of removeShift method, of class ShiftManager.
     */
    @Test
    public void testRemoveShift() {
        shiftManager.addShift(testShift);
        shiftManager.removeShift(testShift);
        assertFalse(AppSystem.getInstance().getAvailableShifts().contains(testShift), "Shift should be removed from available shifts");
    }
}
