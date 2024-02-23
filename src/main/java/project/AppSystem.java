/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.util.ArrayList;
import java.util.Date;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
//import java.util.List;

/**
 * The AppSystem class is a singleton that manages the functionality of the application.
 * It handles the operations in the system.
 * This class ensures that there is only one instance of the system at any given time.
 */
public class AppSystem {
   
    private static AppSystem instance = null;
    
    private Admin systemAdmin;
    private static ArrayList<Shift> availableShifts = new ArrayList<>();
    private static ArrayList<Nurse> nurses = new ArrayList<>();
    private static int currentUserID;
    
    /**
     * Private constructor for AppSystem.
     * Initializes the system admin, loads nurses and shifts from serialized files.
     */
    private AppSystem()
    {
       currentUserID = 0 ;
       systemAdmin = new Admin(1000, "admin", "admin");
       
       
       //serialize nurses
       File nurseFolder = new File("nurses");
       File[] nurseFiles = nurseFolder.listFiles();
        
       for (File nurseFile : nurseFiles) 
       {
           if (nurseFile.isFile()) {
               try (ObjectInputStream nurseOis = new ObjectInputStream(new FileInputStream(nurseFile))) 
               {
                   Nurse nurseObject = (Nurse) nurseOis.readObject();
                   nurses.add(nurseObject);
                   System.out.println(nurseObject.getID());
                   ArrayList<Shift> nurseSchedule = nurseObject.getNurseSchedule();
                   for(Shift shift1 : nurseSchedule) {
                    System.out.println(shift1);
                    }
               } catch (IOException | ClassNotFoundException e) {
                   e.printStackTrace();
               }
           }
       }
       
        
       //serialize available shifts
       File shiftFolder = new File("shifts");
       File[] shiftFiles = shiftFolder.listFiles();

       for (File shiftFile : shiftFiles) 
       {
           if (shiftFile.isFile()) {
               try (ObjectInputStream shiftOis = new ObjectInputStream(new FileInputStream(shiftFile))) 
               {
                   Shift shiftObject = (Shift) shiftOis.readObject();
                   availableShifts.add(shiftObject);
                   System.out.println(shiftObject.getShiftID());
               } catch (IOException | ClassNotFoundException e) {
                   e.printStackTrace();
               }
           }
       }
        
        
    }
     /**
     * Returns the singleton instance of AppSystem.
     * @return The singleton instance of AppSystem.
     */
    public static AppSystem getInstance()
    {
       
        if (instance == null) 
        {
            instance = new AppSystem();
        }
      
        return instance;
    }
    /**
     * Returns the currently logged-in nurse.
     * @return The current Nurse object, or null if no nurse is logged in.
     */
    public Nurse getCurrentNurse()
    {
        System.out.println(currentUserID+ "From getCurrentNurse");
        
        for(Nurse nurse: nurses)
        { System.out.println(nurse.getID()+ "Get ID From getCurrentNurse");
            if(currentUserID == nurse.getID())
            {
                
                return nurse;
            }
        }
        return null;
    }
    /**
     * Sets the current user ID.
     * @param ID The user ID to set to the current userID
     */
    public static void setCurrentID(int ID)
    {
        currentUserID = ID;
    }
    /**
     * Returns a list of the nurse objects.
     * @return An ArrayList of Nurse objects.
     */
    public ArrayList<Nurse> getNurseList() {
        return nurses;
    }
    /**
     * Returns a list of the shift objects.
     * @return An ArrayList of shift objects.
     */
    public ArrayList<Shift> getAvailableShifts()
    {
        return availableShifts;
    } 

    /**
     * Returns the admin ID.
     * @return An integer representing the admin ID.
     */
    public int getAdminID()
    {
        return systemAdmin.getID();
    }
    
    /**
     * Verifies login credentials for users.
     * @param ID The user ID.
     * @param password The password.
     * @return true if credentials are valid, false otherwise.
     */
    public boolean verifyLogin(int ID, String password)
    {
        if (ID == systemAdmin.getID())
        {
            if(password.equals(systemAdmin.getPassword()))
            {
                setCurrentID(ID);
                System.out.println("Admin Login successful");
                return true;
            }
        }
        else
        {
            for(Nurse nurse: nurses)
            {
                if(ID == nurse.getID())
                {
                    if(password.equals(nurse.getPassword()))
                    {
                        setCurrentID(ID);
                        System.out.println("Nurse Login successful");
                        return true;
                    }
                    
                }
            }
        }
        return false;
    }
    /**
     * Verifies the old password is correct when changing password and changes the password.
     * @param oldPassword The old password.
     * @param newPassword The new password.
     * @return true if password is changed, false otherwise
     */
    public boolean verifyOldPass(String oldPassword, String newPassword)
    {
        for(Nurse nurse: nurses)
        {
            if(currentUserID == nurse.getID())
            {
                if (oldPassword.equals(nurse.getPassword()))
                {
                    nurse.changePassword(newPassword);
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * Adds nurse object to the nurses ArrayList. 
     * @param nurseID The nurseID to add. 
     * @param name The nurse name to add.
     * @param password The nurse password to add.
     */
    public void addNurse(int nurseID, String name, String password)
    {
        nurses.add(new Nurse(nurseID, name, password));
    }
    /**
     * Deletes nurse based on the nurseID. 
     * @param nurseID The nurseID to delete. 
     */
    public void deleteNurse(int nurseID)
    {
        for(Nurse nurse: nurses)
        {
            if(nurseID == nurse.getID())
            {
                nurses.remove(nurse);
            }
        }
    }
    
    /**
     * Removes the nurse file when deleting nurse. 
     * @param nurse Nurse to be deleted. 
     */
    
    public static void removeNurseFile(Nurse nurse){
        //nurses.remove(nurse);
        //System.out.println("removed");
        String directoryPath = "nurses";
        String filename = "nurses" + File.separator + String.valueOf(nurse.getID());
        File fileToDelete = new File(filename);
        if (fileToDelete.exists()) {
            boolean isDeleted = fileToDelete.delete();
            if (isDeleted) {
                System.out.println("Nurse file deleted successfully.");
            } else {
                System.out.println("Failed to delete the nurse file.");
            }
        }    
    }
    /**
     *Removes shift file for deleted shifts. 
     * @param shift Shift file to be deleted. 
     */
    public static void removeShiftFile(Shift shift){
        availableShifts.remove(shift);
        System.out.println("removed shift");
        String directoryPath = "shifts";
        String filename = "shifts" + File.separator + String.valueOf(shift.getShiftID());
        File fileToDelete = new File(filename);
        if (fileToDelete.exists()) {
            boolean isDeleted = fileToDelete.delete();
            if (isDeleted) {
                System.out.println("Shift file deleted successfully.");
            } else {
                System.out.println("Failed to delete the shift file.");
            }
        }    
    }
    /**
     * Adds nurse objects to nurses ArrayList. 
     * @param nurseObject 
     */
     
  
    public void addNurse(Nurse nurseObject)
    {
        nurses.add(nurseObject);
    }
    /**
     * Reserializes the nurse when password is changed. 
     */
    public void changePassword()
    {
        Nurse nurse = getCurrentNurse();
        removeNurseFile(nurse);
        try {
            nurse.serializeNurse(Integer.toString(nurse.getID()));
        } catch (IOException ex) {
            Logger.getLogger(AppSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
