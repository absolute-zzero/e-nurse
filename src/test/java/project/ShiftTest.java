package project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

class ShiftTest {

    private Shift shift;
    private final int shiftID = 1;
    private final boolean isDay = true;
    private final String hospital = "Hospital A";
    private final Date shiftDate = new Date();
    private final int nurseID = 123;

    @BeforeEach
    void setUp() {
        shift = new Shift(shiftID, isDay, hospital, shiftDate);
    }
    /**
     * Test of getShiftID method, of class Shift.
     */
    @Test
    void testGetShiftID() {
        assertEquals(shiftID, shift.getShiftID());
    }
    /**
     * Test of getIsDay method, of class Shift.
     */
    @Test
    void testGetIsDay() {
        assertEquals(isDay, shift.getIsDay());
    }
   /**
     * Test of getHospital method, of class Shift.
     */
    @Test
    void testGetHospital() {
        assertEquals(hospital.toLowerCase(), shift.getHospital());
    }

    /**
     * Test of getShiftDate method, of class Shift.
     */
    @Test
    void testGetShiftDate() {
        assertEquals(shiftDate, shift.getShiftDate());
    }
    /**
     * Test of toString method, of class Shift.
     */
    @Test
    void testToString() {
        assertNotNull(shift.toString());
    }
    /**
     * Test of getShiftDateString method, of class Shift.
     */
    @Test
    void testGetShiftDateString() {
        assertNotNull(shift.getShiftDateString());
    }
    /**
     * Test of getTimeString method, of class Shift.
     */
    @Test
    void testGetTimeString() {
        assertNotNull(shift.getTimeString());
    }
}
