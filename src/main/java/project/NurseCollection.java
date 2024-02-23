package project;

import java.util.ArrayList;

/**
 *Implements the nurse iterator and holds a collection of objects.
 */
public class NurseCollection implements NurseAggregator {
    private ArrayList<Nurse> nurses;

    /**
     * Saves the ArrayList of nurses
     * @param nurses objects that will be saved to the array list. 
     */
    public NurseCollection(ArrayList<Nurse> nurses) {
        this.nurses = nurses;
    }
    /**
     * Creates the nurse iterator. 
     * @return The nurse iterator. 
     */

    @Override
    public NurseIterator createIterator() {
        return new ConcreteNurseIterator(nurses);
    }
}
