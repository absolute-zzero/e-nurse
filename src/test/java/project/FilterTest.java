package project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class FilterTest {
    
    private Filter filter;
    private ArrayList<Shift> testShifts;

    @BeforeEach
    public void setUp() {
        // Create test shifts here
        testShifts = new ArrayList<>();
        testShifts.add(new Shift(1, true, "hospital a", null)); 
        filter = new Filter(testShifts);
    }
    /**
     * Test of filterShiftsByHospital method, of class Filter.
     */
    @Test
    public void testFilterShiftsByHospital() {
        ArrayList<Shift> filteredShifts = filter.filterShiftsByHospital(1);
        assertFalse(filteredShifts.isEmpty(), "Filtered list should not be empty");
    }
    /**
     * Test of filterShiftsByType method, of class Filter.
     */
    @Test
    public void testFilterShiftsByType() {
        ArrayList<Shift> filteredShifts = filter.filterShiftsByType(1); 
        assertFalse(filteredShifts.isEmpty(), "Filtered list should not be empty");
    }
    /**
     * Test of getNoneBtn method, of class Filter.
     */
    @Test
    public void testGetNoneBtn() {
        assertNotNull(filter.getNoneBtn(), "None button should not be null");
    }
    /**
     * Test of getABtn method, of class Filter.
     */
    @Test
    public void testGetABtn() {
        assertNotNull(filter.getABtn(), "A button should not be null");
    }
    /**
     * Test of getBBtn method, of class Filter.
     */
    @Test
    public void testGetBBtn() {
        assertNotNull(filter.getBBtn(), "B button should not be null");
    }
    /**
     * Test of getCBtn method, of class Filter.
     */
    @Test
    public void testGetCBtn() {
        assertNotNull(filter.getCBtn(), "C button should not be null");
    }
    /**
     * Test of getDBtn method, of class Filter.
     */
    @Test
    public void testGetDBtn() {
        assertNotNull(filter.getDBtn(), "D button should not be null");
    }
    /**
     * Test of getDayBtn method, of class Filter.
     */
    @Test
    public void testGetDayBtn() {
        assertNotNull(filter.getDayBtn(), "Day button should not be null");
    }
    /**
     * Test of getNightBtn method, of class Filter.
     */
    @Test
    public void testGetNightBtn() {
        assertNotNull(filter.getNightBtn(), "Night button should not be null");
    }

    /**
     * Test of getSubmitBtn method, of class Filter.
     */
    @Test
    public void testGetSubmitBtn() {
        assertNotNull(filter.getSubmitBtn(), "Submit button should not be null");
    }
}
