/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

/**
 *Class for administrator in the system.
 */
public class Admin extends User{
     /**
     * Constructs a new Admin object with specified ID, name, and password.
     * 
     * @param adminID The ID for for the admin.
     * @param name The name of the admin.
     * @param password The password for admin account access.
     */
    public Admin(int adminID, String name, String password)
    {
        super(adminID, name, password);
    }
    
}
