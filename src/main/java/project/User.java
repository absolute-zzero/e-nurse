/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.io.Serializable;

/**
 *Abstract class user that is used for admin and nurse. 
 */
public abstract class User implements Serializable {
    private int id;
    private String name;
    protected String password;
    /**
     * Constructor for the user abstract class .
     * @param id
     * @param name
     * @param password 
     */
    public User(int id, String name, String password)
    {
        this.id = id;
        this.name = name;
        this.password = password;
    }
    /**
     * Returns user ID
     * @return 
     */
    public int getID()
    {
        return id;
    }
    /**
     * Returns user name
     * @return 
     */
    public String getName()
    {
        return name;
    }
    /**
     * Returns user password. 
     * @return 
     */
    public String getPassword()
    {
        return password;
    }
    
}
