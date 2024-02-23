/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import javax.swing.*;
import java.util.ArrayList;

/**
 * This class represents a filter panel used to filter shifts based on various criteria.
 */
public class Filter extends JPanel{
    
    private ArrayList<Shift> shifts; // Assuming you have a list of shifts
    private JRadioButton noneBtn = new JRadioButton("none");
    private JRadioButton ABtn = new JRadioButton("Hospital A");
    private JRadioButton BBtn = new JRadioButton("Hospital B");
    private JRadioButton CBtn = new JRadioButton("Hospital C");
    private JRadioButton DBtn = new JRadioButton("Hospital D");
    private JRadioButton dayBtn = new JRadioButton("Day");
    private JRadioButton nightBtn = new JRadioButton("Night");

    private JLabel titleLabel = new JLabel("Filter Shifts");
    private JButton submitButton = new JButton("Submit");
    
     /**
     * Constructor for the Filter class.
     * @param shifts An ArrayList of Shift objects to be filtered.
     */
    public Filter(ArrayList<Shift> shifts) {
        this.shifts = shifts;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        ButtonGroup hospitalGroup = new ButtonGroup();
        
        hospitalGroup.add(noneBtn);
        hospitalGroup.add(ABtn);
        hospitalGroup.add(BBtn);
        hospitalGroup.add(CBtn);
        hospitalGroup.add(DBtn);
        hospitalGroup.add(dayBtn);
        hospitalGroup.add(nightBtn);

        this.add(titleLabel);
        this.add(noneBtn);
        this.add(ABtn);
        this.add(BBtn);
        this.add(CBtn);
        this.add(DBtn);
        this.add(dayBtn);
        this.add(nightBtn);
        this.add(submitButton);
    }
    
    /**
     * Filters the provided list of shifts based on the specified hospital.
     * @param shifts The list of Shift objects to filter.
     * @param hospital The hospital criteria for filtering.
     * @return A filtered ArrayList of Shift objects based on the hospital criteria.
     */
    private ArrayList<Shift> filterShiftsByHospital(ArrayList<Shift> shifts, int hospital)
    {
        //filer by hospital, type, date
        
        ArrayList<Shift> filteredShifts = new ArrayList<>();
        
        for(Shift shift: shifts)
        {
            if( (hospital == 1 && shift.getHospital().equals("hospital a")) ||
                (hospital == 2 && shift.getHospital().equals("hospital b")) ||
                (hospital == 3 && shift.getHospital().equals("hospital c")) ||
                (hospital == 4 && shift.getHospital().equals("hospital d"))
            )
            {
                filteredShifts.add(shift);
            }
        }
        
        return filteredShifts;
    }
    /**
     * Filters the provided list of shifts based on the specified shift type (day or night).
     * @param shifts The list of Shift objects to filter.
     * @param type The shift type criteria for filtering.
     * @return A filtered ArrayList of Shift objects based on the shift type criteria.
     */
    private ArrayList<Shift> filterShiftsByType(ArrayList<Shift> shifts, int type)
    {
        //filer by hospital, type, date
        
        ArrayList<Shift> filteredShifts = new ArrayList<>();
        
        for(Shift shift: shifts)
        {
            if( (type == 1 && shift.getIsDay()==true) || (type == 2 && shift.getIsDay() ==false))
            {
                filteredShifts.add(shift);
            }
        }
        
        return filteredShifts;
    }
    /**
     * Filters the shifts by hospital using the class's instance variable.
     * @param hospital The hospital criteria for filtering.
     * @return A filtered ArrayList of Shift objects.
     */
     public ArrayList<Shift> filterShiftsByHospital(int hospital) {
        return filterShiftsByHospital(shifts, hospital);
    }
     /**
     * Filters the shifts by type (day or night) using the class's instance variable.
     * @param type The shift type criteria for filtering.
     * @return A filtered ArrayList of Shift objects.
     */
    // Method to filter shifts by type without passing a list (assumes use of instance variable)
    public ArrayList<Shift> filterShiftsByType(int type) {
        return filterShiftsByType(shifts, type);
    }
    
    /**
     * Returns the getNoneButton 
     * @return 
     */
    public JRadioButton getNoneBtn()
    {
        return noneBtn;
    }
    /**
     * Returns the getABtn 
     * @return 
     */
    public JRadioButton getABtn()
    {
        return ABtn;
    }
    /**
     * Returns the BBtn
     * @return 
     */
    public JRadioButton getBBtn()
    {
        return BBtn;
    }
    /**
     * Returns the CBtn
     * @return 
     */
    public JRadioButton getCBtn()
    {
        return CBtn;
    }
    /**
     * Returns the DBtn
     * @return 
     */
    public JRadioButton getDBtn()
    {
        return DBtn;
    }
    /**
     * Returns the DayBtn
     * @return 
     */
    public JRadioButton getDayBtn()
    {
        return dayBtn;
    }
    /**
     * Returns the getNightBtn
     * @return 
     */
    public JRadioButton getNightBtn()
    {
        return nightBtn;
    }
    /**
     * Returns the Submit Button 
     * @return 
     */
    public JButton getSubmitBtn()
    {
        return submitButton;
    }
    
}
