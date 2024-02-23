/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.util.ArrayList;

/**
 *Implements the shift iterator and holds a collection of objects.
 */
public class ShiftCollection implements ShiftAggregator{
    private ArrayList<Shift> shifts;
    /**
     * Saves the ArrayList of shifts
     * @param shift objects that will be saved to the array list. 
     */
    public ShiftCollection(ArrayList<Shift> shifts) {
        this.shifts = shifts;
    }
    /**
     * Creates the shift iterator. 
     * @return The shift iterator. 
     */
    @Override
    public ShiftIterator createIterator() {
        return new ConcreteShiftIterator(shifts);
    }
}
