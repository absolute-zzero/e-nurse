/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import static project.AppSystem.removeShiftFile;

/**
 *Class that manages the shifts. 
 */
public class ShiftManager 
{
    private Date date = new Date();
    AppSystem appsys = AppSystem.getInstance();
    /**
     * Constructor for the shift manager. 
     */
    public ShiftManager()
    {
        
    }
    /**
     * Method that creates the shift. 
     * @param availableShifts ArrayList of the available shifts. 
     * @param shift New shift object that will be added. 
     */
    public void createShift(ArrayList<Shift> availableShifts, Shift shift)
    {
        availableShifts.add(shift);
    }
    
    /**
     * Method that reserves shift. 
     * @param shift that will be reserved.
     */
    public void reserveShift( Shift shift)
    {

        Nurse currentNurse = appsys.getCurrentNurse();
        appsys.removeNurseFile(currentNurse);
        currentNurse.reserveShift(shift);
        appsys.setCurrentID(currentNurse.getID());
        appsys.removeShiftFile(shift);
        
       

    }
    /**
     * Method that cancels a shift on the nurse's schedule
     * @param shift that is being canceled
     */
    public void cancelReservation(Shift shift)
    {
        
        appsys.getCurrentNurse().cancelShift(shift);
    }
    
    
    /**
     * Method that deletes a shift from the available shifts array list
     * @param availableShifts
     * @param shiftID 
     */
    public void deleteShift(ArrayList<Shift> availableShifts, int shiftID)
    {
        for (Shift availableShift : availableShifts) 
        {
            if(availableShift.getShiftID() == shiftID)
            {
                availableShifts.remove(availableShift);
            }
        }
    }
    /**
     * Method to recreate a shift after nurse deletes it from schedule. 
     * @param availableShifts
     * @param shift 
     */
    public void recreateShift(ArrayList<Shift> availableShifts, Shift shift)
    {
        availableShifts.add(shift);
        try {
            shift.serializeShift(Integer.toString(shift.getShiftID()));
        } catch (IOException ex) {
            Logger.getLogger(ShiftManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * Method to add shift to available shifts. 
     * @param shift 
     */
    public void addShift(Shift shift) 
    {
        appsys.getAvailableShifts().add(shift);
    }
    /**
     * Method to delete shift from available shifts and delete the file. 
     * @param shift 
     */
    public void removeShift(Shift shift)
    {
        appsys.getAvailableShifts().remove(shift);
        removeShiftFile(shift);
    }
    
}
