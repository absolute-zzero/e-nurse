/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.util.ArrayList;

/**
 * A concrete iterator for iterating over a collection of Shift objects.
 * Implements the ShiftIterator interface and provides functionality
 * to iterate through the shifts.
 */
public class ConcreteShiftIterator implements ShiftIterator{
    private int idx;
    private ArrayList<Shift> shifts;
    
    /**
     * Constructor to initialize the ConcreteShiftIterator with a list of shifts.
     * @param shifts The list of Shifts objects to iterate over.
     */
    public ConcreteShiftIterator(ArrayList<Shift> shifts) {
        this.shifts = shifts;
        idx = 0;
    }
    /**
     * Checks if there is a next shift to iterate over. 
     * @return Returns a boolean if there is another shift next. 
     */
    @Override
    public boolean hasNext() {
        return idx < shifts.size();
    }
    /**
     * Returns the next shift in the iteration and advances. 
     * @return Returns the next shift object in the list. 
     */
    @Override
    public Shift next() {
        return shifts.get(idx++);
    }
    /**
     * Checks if the end of the list has been reached. 
     * @return Returns a boolean stating whether the end of the list has been reached.
     */
    @Override
    public boolean isDone()
    {
        return idx == shifts.size();
    }
}
