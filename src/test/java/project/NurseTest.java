package project;

import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NurseTest {

    private Nurse nurse;
    private Shift testShift;

    @BeforeEach
    public void setUp() {
        nurse = new Nurse(1, "Test Nurse", "password123");
        testShift = new Shift(101, true, "Hospital A", new Date());
    }
    /**
     * Test of getNurseSchedule method, of class Nurse.
     */
    @Test
    public void testGetNurseSchedule() {
        assertTrue(nurse.getNurseSchedule().isEmpty(), "Initial schedule should be empty");
    }
    /**
     * Test of changePassword method, of class Nurse.
     */
    @Test
    public void testChangePassword() {
        String newPassword = "newPassword";
        nurse.changePassword(newPassword);
        assertEquals(newPassword, nurse.getPassword(), "Password should be changed to the new one");
    }
    /**
     * Test of reserveShift method, of class Nurse.
     */
    @Test
    public void testReserveShift() {
        nurse.reserveShift(testShift);
        assertTrue(nurse.getNurseSchedule().contains(testShift), "Schedule should contain the reserved shift");
    }
    /**
     * Test of cancelShift method, of class Nurse.
     */
    @Test
    public void testCancelShift() {
        nurse.reserveShift(testShift);
        nurse.cancelShift(testShift);
        assertFalse(nurse.getNurseSchedule().contains(testShift), "Schedule should not contain the canceled shift");
    }
    /**
     * Test of toString method, of class Nurse.
     */
    @Test
    public void testToString() {
        String expectedString = "1 Test Nurse password123"; 
        assertEquals(expectedString, nurse.toString(), "toString method should return the correct string representation");
    }

}
