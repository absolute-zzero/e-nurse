/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *Creates the shift object. 
 */
public class Shift implements Serializable{
    private int shiftID;
    private boolean isDay;
    private String hospital;
    private Date shiftDate = new Date();
    /**
     * Constructor to create the shift object. 
     * @param shiftID for the new shift objet
     * @param isDay whether the shift is during the day 
     * @param hospital where the shift is 
     * @param shiftDate when the shift is 
     */
    public Shift(int shiftID, boolean isDay, String hospital, Date shiftDate)
    {
        this.shiftID = shiftID;
        this.isDay = isDay;
        this.hospital = hospital.toLowerCase();
        this.shiftDate = shiftDate;
        
        try {
            this.serializeShift(Integer.toString(this.shiftID));
        } catch (IOException e) {
            // Handle exception or propagate it
            System.err.println("Serialization failed: " + e.getMessage());
        }
    }
    /**
     * Returns the shift ID. 
     * @return Shift ID
     */
    public int getShiftID()
    {
        return shiftID;
    }
    /**
     * Returns whether the shift is during the day. 
     * @return Boolean, true for day, false otherwise
     */
    public boolean getIsDay()
    {
        return isDay;
    }
    /**
     * Returns the hospital where the shift takes place. 
     * @return string of the hospital
     */
    public String getHospital()
    {
        return hospital;
    }
    /**
     * Returns the date of the shift. 
     * @return Date object with the shift date. 
     */
    public Date getShiftDate()
    {
        return shiftDate;
    }
    
    /**
     * Serializes the shift object. 
     * @param filename that the serialized object will have 
     * @throws IOException 
     */
    public void serializeShift(String filename) throws IOException {
    
        File directory = new File("shifts");
        if (!directory.exists()) {
            directory.mkdirs(); // Create the folder if it doesn't exist
        }

        // Combine the folder path and filename
        String fullPath = "shifts" + File.separator + filename;

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fullPath))) {
            out.writeObject(this);
        }
    }
    /**
     * Formats the shift object from when its printed. 
     * @return The formatted shift object. 
     */
    public String getShiftDateString()
    {
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
        return (formatter.format(getShiftDate()));
    }
    /**
     * Gets the time when the shift takes place. 
     * @return string with time
     */
    public String getTimeString()
    {
        if (this.getIsDay()==true)
        {
            return "7am-7pm";
        }
        else{
            return "7pm-7am";
        }
    }
}
