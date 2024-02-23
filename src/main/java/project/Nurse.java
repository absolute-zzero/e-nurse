/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.util.ArrayList;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *Makes the nurse object. 
 */
public class Nurse extends User implements Serializable{
    private  ArrayList<Shift> nurseSchedule = new ArrayList<>();
    private boolean serialized; 
    /**
     * Constructor for the nurse object. 
     * @param nurseID ID for the new nurse object. 
     * @param name Name for the new nurse object. 
     * @param password Password for the new nurse object. 
     */
    public Nurse(int nurseID, String name, String password)
    {
        
        super(nurseID, name, password);
        
        try {
            this.serializeNurse(Integer.toString(getID()));
        } catch (IOException e) {
            // Handle exception or propagate it
            System.err.println("Serialization failed: " + e.getMessage());
        }
    }
    /**
     * Returns the nurse's schedule. 
     * @return ArrayList of nurse schedule. 
     */
    public ArrayList<Shift> getNurseSchedule()
    {
        return this.nurseSchedule;
    }
    /**
     * Method to change the nurse's password. 
     * @param newPassword for the password to be changed to. 
     */
    public void changePassword(String newPassword)
    {
        this.password = newPassword;
    }
    /**
     * Method to reserialize the nurse object after a shift has been reserved. 
     * @param shift that is added. 
     */
    public void reserveShift(Shift shift)
    {
        this.nurseSchedule.add(shift);
        try {
            this.serializeNurse(Integer.toString(getID()));
            System.out.println("After reserve Shift");
        } catch (IOException e) {
            // Handle exception or propagate it
            System.err.println("Serialization failed: " + e.getMessage());
        }
        AppSystem appsys = AppSystem.getInstance();
        appsys.addNurse(this);
    }
    /**
     * Method that reserializes the nurse object after a shift has been canceled. 
     * @param shift that will be canceled. 
     */
    public void cancelShift(Shift shift)
    {
        this.nurseSchedule.remove(shift);
        try {
            this.serializeNurse(Integer.toString(getID()));
            System.out.println("After reserve Shift");
        } catch (IOException e) {
            // Handle exception or propagate it
            System.err.println("Serialization failed: " + e.getMessage());
        }
       
    }
    /**
     * Changes the format when printing a nurse object. 
     * @return the string format of the nurse object. 
     */
    @Override
    public String toString()
    {
        return Integer.toString(getID()) + " " + getName() + " " + getPassword();
    }
    /**
     * Serializes the nurse object after it has been created. 
     * @param filename that the serialized file will be given
     * @throws IOException 
     */
    public void serializeNurse(String filename) throws IOException {
 
        File directory = new File("nurses");
        if (!directory.exists()) {
            directory.mkdirs(); // Create the folder if it doesn't exist
        }

        // Combine the folder path and filename
        String fullPath = "nurses" + File.separator + filename;

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fullPath))) {
            this.serialized = true;
            out.writeObject(this);
        }
    }
}
