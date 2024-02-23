package project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

class SortTest {

    private Sort sort;
    private ArrayList<Shift> shifts;

    @BeforeEach
    void setUp() {
        sort = new Sort();
        shifts = new ArrayList<>();
        shifts.add(new Shift(1, true, "Hospital A", new Date(2023, 1, 1)));
        shifts.add(new Shift(2, false, "Hospital B", new Date(2023, 1, 2)));
        shifts.add(new Shift(3, true, "Hospital A", new Date(2023, 1, 3)));
    }
    /**
     * Test of getCompByShiftDate method, of class Sort.
     */
    @Test
    void testGetCompByShiftDate() {
        Collections.sort(shifts, sort.getCompByShiftDate());
        assertTrue(shifts.get(0).getShiftDate().before(shifts.get(1).getShiftDate()));
    }

    /**
     * Test of sortCollection method, of class Sort.
     */
    @Test
    void testSortCollection() {
        sort.sortCollection(shifts, sort.getCompByShiftDate());
        assertTrue(shifts.get(0).getShiftDate().before(shifts.get(1).getShiftDate()));
    }
    /**
     * Test of getHospitalOpt method, of class Sort.
     */
    @Test
    void testGetHospitalOpt() {
        assertNotNull(sort.getHospitalOpt());
    }
    /**
     * Test of getTimeOpt method, of class Sort.
     */
    @Test
    void testGetTimeOpt() {
        assertNotNull(sort.getTimeOpt());
    }
    /**
     * Test of getDateOpt method, of class Sort.
     */
    @Test
    void testGetDateOpt() {
        assertNotNull(sort.getDateOpt());
    }
    /**
     * Test of getSubmitBtn method, of class Sort.
     */
    @Test
    void testGetSubmitBtn() {
        assertNotNull(sort.getSubmitBtn());
    }
}
