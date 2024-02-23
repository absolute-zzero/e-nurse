/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;


import java.util.ArrayList;

/**
 * The NurseApp class serves as the entry point for the nurse scheduling app.
 */
public class NurseApp {
     /**
     * The main method initializes the application systems and demonstrates functionality.
     * 
     * @param args
     */
    public static void main(String[] args)
    {
        AppSystem appsys = AppSystem.getInstance();
        ViewManager viewmanager = ViewManager.getInstance();
        
        viewmanager.refreshLoginFrame();
        
        System.out.println("Listing nurses");
        ArrayList<Nurse> nursesTest = appsys.getNurseList();
        for(Nurse nurse: nursesTest)
        {
            System.out.println(nurse.toString());
        }
        System.out.println("");
        
        System.out.println("Listing shifts");
        ArrayList<Shift> shiftsTest = appsys.getAvailableShifts();
        for(Shift shift: shiftsTest)
        {
            System.out.println(shift.toString());
        }
        
    }
}
