/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.util.ArrayList;

/**
 * A concrete iterator for iterating over a collection of Nurse objects.
 * Implements the NurseIterator interface and provides functionality
 * to iterate through the nurses.
 */
public class ConcreteNurseIterator  implements NurseIterator{
    private int idx;
    private ArrayList<Nurse> nurses;
     /**
     * Constructor to initialize the ConcreteNurseIterator with a list of nurses.
     * @param nurses The list of Nurse objects to iterate over.
     */
    public ConcreteNurseIterator(ArrayList<Nurse> nurses) {
        this.nurses = nurses;
        idx = 0;
    }
    /**
     * Checks if there is a next nurse to iterate over. 
     * @return Returns a boolean if there is another nurse next. 
     */

    @Override
    public boolean hasNext() {
        return idx < nurses.size();
    }
    /**
     * Returns the next nurse in the iteration and advances. 
     * @return Returns the next nurse object in the list. 
     */

    @Override
    public Nurse next() {
        return nurses.get(idx++);
    }
    /**
     * Checks if the end of the list has been reached. 
     * @return Returns a boolean stating whether the end of the list has been reached.
     */
    @Override
    public boolean isDone()
    {
        return idx == nurses.size();
    }
}
