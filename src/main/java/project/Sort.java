/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.util.Comparator;
import java.util.Collections;
import java.util.ArrayList;
import javax.swing.*;

/**
 *Provides a UI to sort the shifts. 
 */
public class Sort extends JPanel {
    private JLabel titleLabel = new JLabel("Sorting");
    private JRadioButton hospitalOpt = new  JRadioButton("Hospital");
    private JRadioButton timeOpt = new JRadioButton("Time");
    private JRadioButton dateOpt = new JRadioButton("Date");
    private JButton submitBtn = new JButton("Sort");
    /**
     * Constructor for the sort class that deals with the GUI and functionalities. 
     */
    public Sort()
    {
        int topPadding = 50;
        this.setBorder(BorderFactory.createEmptyBorder(topPadding,0,0,0));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        ButtonGroup sortGroup = new ButtonGroup();

        sortGroup.add(timeOpt);
        sortGroup.add(hospitalOpt);
        sortGroup.add(dateOpt);

        this.add(titleLabel);
        this.add(hospitalOpt);
        this.add(timeOpt);
        this.add(dateOpt);

        this.add(submitBtn);
    }
    /**
     * Returns a comparator to compare the shifts by date. 
     * @return 
     */
    public Comparator<Shift> getCompByShiftDate() {
        return new Comparator<Shift>() {
            @Override
            public int compare(Shift shift1, Shift shift2) {
                return shift1.getShiftDate().compareTo(shift2.getShiftDate());
            }
        };
    }
    /**
     * Returns a comparator to compare the shifts by hospital. 
     * @return 
     */
    public Comparator<Shift> getCompByShiftHospital() {
        return new Comparator<Shift>() {
            @Override
            public int compare(Shift shift1, Shift shift2) {
                return shift1.getHospital().compareTo(shift2.getHospital());
            }
        };
    }
    /**
     * Returns a comparator to compare the shifts by shift type. 
     * @return 
     */
    public Comparator<Shift> getCompByShiftType() {
        return new Comparator<Shift>() {
            @Override
            public int compare(Shift shift1, Shift shift2) {
                String s1;
                String s2;
                if (shift1.getIsDay() == true)
                {
                    s1 = "true";
                }
                else
                {
                    s1 = "false";
                }
                if (shift2.getIsDay() == true)
                {
                    s2 = "true";
                }
                else
                {
                    s2 = "false";
                }
                return s1.compareTo(s2);
            }
        };
    }
    /**
     * Method to pass in the array list that needs to be sorted. 
     * @param shifts
     * @param comp 
     */
    public void sortCollection(ArrayList<Shift> shifts, Comparator<Shift> comp)
    {
        Collections.sort(shifts, comp);
    }
    /**
     * Returns button for hospital option. 
     * @return 
     */
    public JRadioButton getHospitalOpt()
    {
        return hospitalOpt;
    }
    /**
     * returns button for time option 
     * @return 
     */
    public JRadioButton getTimeOpt()
    {
        return timeOpt;
    }
    /**
     * returns button for get date option 
     * @return 
     */
    public JRadioButton getDateOpt()
    {
        return dateOpt;
    }
    /**
     * returns button for submit to sort
     * @return 
     */
    public JButton getSubmitBtn()
    {
        return submitBtn;
    }
    
}
