/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import javax.swing.*;
import java.awt.*;

/**
 * An abstract class representing a dashboard frame. This class provides a common structure
 * for Nurse Dashboard and Admin Dashboard.
 * It includes a logout button, content panel, and a method for setting up the menu.
 */
public abstract class DashboardFrame {
    private JFrame frame = new JFrame("dashboard");
    private JButton logoutBtn = new JButton("Logout"); 
    private JPanel contentPanel = new JPanel(new BorderLayout());
    /**
     * Constructor for DashboardFrame. 
     */
    public DashboardFrame()
    {
        JLabel heading = new JLabel("eNurse");
        heading.setFont(new Font("Poppins", Font.BOLD, 20));
        JLabel subheading = new JLabel("Nurse Dashboard");
        subheading.setFont(new Font("Poppins", Font.ITALIC, 10));
        
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.add(heading);
        leftPanel.add(subheading);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(logoutBtn);    
       

        //The Header BorderLayout
        contentPanel.add(leftPanel, BorderLayout.WEST);
        contentPanel.add(buttonPanel, BorderLayout.NORTH);
        contentPanel.add(new JSeparator(), BorderLayout.CENTER); // Horizontal Line
        
        JLabel welcomeLabel = new JLabel("Welcome");
        welcomeLabel.setFont(new Font("Poppins", Font.BOLD, 20));
        JPanel welcomePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        welcomePanel.add(welcomeLabel, BorderLayout.CENTER);
        contentPanel.add(welcomeLabel); 
        
        // Set layout manager for the frame
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        
        // Add the content panel to the frame
        frame.add(contentPanel);

        // This method sets the width and height of the frame
        frame.setSize(800, 800); // Adjust the size as needed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    /**
     * Method to be implemented by subclasses for adding menu items to the dashboard.
     * @param menu The JPanel to which the menu items will be added.
     */
    public JPanel menuSetup()
    {
        JPanel menu = new JPanel(new FlowLayout());
        addMenuItems(menu);
        int bottomPadding = 350;
        menu.setBorder(BorderFactory.createEmptyBorder(0, 0, bottomPadding, 0));
        return menu;
    }
     /**
     * Sets up the menu panel to be added to the dashboard.
     * @return A JPanel containing the menu items.
     */
    protected abstract void addMenuItems(JPanel menu);
     /**
     * Gets the frame of the dashboard.
     * @return The JFrame of the dashboard.
     */
    public JFrame getFrame()
    {
        return frame;
    }
    /**
     * Gets the logout button of the dashboard.
     * @return The logout JButton on the dashboard.
     */
    public JButton getLogoutBtn()
    {
        return logoutBtn;
    }
    /**
     * Gets the content panel of the dashboard.
     * @return The content JPanel of the dashboard.
     */
    public JPanel getContentPanel()
    {
        return contentPanel;
    }
    
    
}
