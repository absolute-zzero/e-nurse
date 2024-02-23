/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


/**
 * The ViewManager class is a singleton that manages the different frames in the application.
 * It offers methods to get and refresh these frames, change their visibility, and attach action listeners to buttons.
 */
public class ViewManager {
  
    private static ViewManager instance = new ViewManager();
    
    private LoginFrame loginframe;
    private NDashboardFrame ndashboard;
    private ADashboardFrame adashboard;
    private NShiftsFrame nshiftsframe;
    private AShiftsFrame ashiftsframe;
    private ScheduleFrame scheduleframe;
    private ChangePasswordFrame changepasswordframe;
    private NursesFrame nursesframe;
    private ShiftCreationFrame shiftcreationframe;
    private AddNurseFrame addnurseframe;
    /**
     * Private constructor for singleton pattern. 
     */
    private ViewManager()
    {   
    }
    /**
     * Creates a single instance of view manager.
     * @return 
     */
    
    public static ViewManager getInstance()
    {
        if(instance == null)
        {
            instance = new ViewManager();
        }
        return instance;
    }
    /**
     * sets the visibility of a frame depending on the boolean. 
     * @param frame
     * @param bool 
     */
    public void setVisibility(JFrame frame, boolean bool)
    {
        frame.setVisible(bool);
    }
    /**
     * Attaches action listener to the button. 
     * @param btn
     * @param listener 
     */
   
    public void attachListener(JButton btn, ActionListener listener)
    {
        btn.addActionListener(listener);
    }
    
    /**
     * Returns the login frame. 
     * @return 
     */
    public LoginFrame getLoginFrame()
    {
        return loginframe;
    }
    /**
     * Returns the NDashboardframe
     * @return 
     */
    public NDashboardFrame getNDashboardFrame()
    {
        return ndashboard;
    }
    /**
     * Returns the ADashboardFrame
     * @return 
     */
    public ADashboardFrame getADashboardFrame()
    {
        return adashboard;
    }
    /**
     * Returns the NShifts Frame. 
     * @return 
     */
    public NShiftsFrame getNShiftsFrame()
    {
        return nshiftsframe;
    }
    /**
     * Returns the AShiftsFrame
     * @return 
     */
    public AShiftsFrame getAShiftsFrame()
    {
        return ashiftsframe;
    }
    /**
     * Returns the schedule frame
     * @return 
     */

    public ScheduleFrame getScheduleFrame()
    {
        return scheduleframe;
    }
    /**
     * Returns the change password frame. 
     * @return 
     */
    public ChangePasswordFrame getChangePasswordFrame()
    {
        return changepasswordframe;
    }
    /**
     * returns the nurses frame. 
     * @return 
     */
    public NursesFrame getNursesFrame()
    {
        return nursesframe;
    }
    /**
     * Returns the shift creation frame. 
     * @return 
     */
    public ShiftCreationFrame getShiftCreationFrame()
    {
        return shiftcreationframe;
    }
    /**
     * returns the add nurse frame 
     * @return 
     */

    public AddNurseFrame getAddNurseFrame()
    {
        return addnurseframe;
    }
    
    
    /**
     * refreshes the login frame
     */
    public void refreshLoginFrame()
    {
        loginframe = new LoginFrame();
    }
    /**
     * refreshes the NDashbaordFrame
     */
    public void refreshNDashboardFrame()
    {
        ndashboard = new NDashboardFrame();
    }
    /**
     * Refreshes the ADashboardFrame
     */
    public void refreshADashboardFrame()
    {
        adashboard = new ADashboardFrame();
    }
    /**
     * Refreshes the NShiftsFrame
     */
    public void refreshNShiftsFrame()
    {
        nshiftsframe = new NShiftsFrame();
    }
    /**
     * Refreshes the AShiftsFrame
     */
    public void refreshAShiftsFrame()
    {
        ashiftsframe = new AShiftsFrame();
    }
    /**
     * Refreshes the schedule frame
     */
    public void refreshScheduleFrame()
    {
        scheduleframe = new ScheduleFrame();
    }
    /**
     * Refreshes the change password frame 
     */
    public void refreshChangePasswordFrame()
    {
        changepasswordframe = new ChangePasswordFrame();
    }
    /**
     * refreshes the nurses frame
     */
    public void refreshNursesFrame()
    {
        nursesframe = new NursesFrame();
    }
    /**
     * refreshes the shift creation frame
     */
    public void refreshShiftCreationFrame()
    {
        shiftcreationframe = new ShiftCreationFrame();
    }
    /**
     * refreshes the add nurse frame
     */
    public void refreshAddNurseFrame()
    {
        addnurseframe = new AddNurseFrame();
    }
    
    
    
    
    
}
