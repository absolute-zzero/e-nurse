/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *Represents the frame that shows the nurses their shifts. 
 * Implements the GUI functionality for the frame. 
 */
public class NShiftsFrame {
    AppSystem appsys = AppSystem.getInstance();
    private JFrame frame = new JFrame("Available Shifts"); 
    private JButton homeBtn = new JButton("Home");
    private JButton logoutBtn = new JButton("Logout");
    private JButton reserveShiftsBtn = new JButton("Reserve Shift");
    private ArrayList<Shift> shiftsList = appsys.getAvailableShifts();
    private Filter filter = new Filter(shiftsList);
    private Sort sort = new Sort();
    /**
     * Constructor for NShiftsFrame. Initializes the frame and sets up the user interface components.
     */
    public NShiftsFrame()
    {
        JLabel heading = new JLabel("eNurse");
        heading.setFont(new Font("Poppins", Font.BOLD, 20));
        JLabel subheading = new JLabel("Nurse Shifts Frame");
        subheading.setFont(new Font("Poppins", Font.ITALIC, 10));
                
      

        // Creating a subpanel for horizontal buttons on the right
        JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        rightPanel.add(homeBtn);
        rightPanel.add(logoutBtn);
        
        
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.add(heading);
        leftPanel.add(subheading);
        
        // Set layout manager for the frame
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        
        // Creating a panel for the entire content with BorderLayout
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.add(leftPanel, BorderLayout.WEST);
        headerPanel.add(rightPanel, BorderLayout.EAST);
        headerPanel.add(new JSeparator(), BorderLayout.SOUTH); // Horizontal Line

        // Add the content panel to the frame
        frame.add(headerPanel);


        // Second Layer
        JPanel meepPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Use FlowLayout.CENTER for center alignment

        JLabel subheading2 = new JLabel("Welcome");
        subheading2.setFont(new Font("Poppins", Font.ITALIC, 30));
        meepPanel.add(subheading2);


        // Set layout manager for the frame
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.add(meepPanel);
        
        
        Schedule schedule = new Schedule();
        schedule.createScheduleFrame(frame.getContentPane());   
 

        frame.setSize(1000, 800); // Adjust the size as needed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ViewManager viewmanager = ViewManager.getInstance();
        AppSystem appsys = AppSystem.getInstance();
        
        //logout button action listener
        viewmanager.attachListener(logoutBtn, 
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent event)
                {
                    viewmanager.setVisibility(frame, false);
                    frame.dispose();
                    viewmanager.refreshLoginFrame();
                    viewmanager.setVisibility(viewmanager.getLoginFrame().getFrame(), true);
                    appsys.setCurrentID(0);           
                }
            }
        );
        
        //home button action listener
        viewmanager.attachListener(homeBtn, 
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent event)
                {
                    viewmanager.setVisibility(frame, false);
                    frame.dispose();
                    viewmanager.refreshNDashboardFrame();
                    viewmanager.setVisibility(viewmanager.getNDashboardFrame().getFrame(), true); 
                }
            }
        );
    }
    /**
     * Returns the nurses shifts frame
     * @return 
     */
    public JFrame getFrame()
    {
        return frame;
    }
    
    /**
     * Inner class schedule that manages the display of the shifts. 
     */
    private class Schedule 
    {
        DefaultListModel<Shift> listModel = new DefaultListModel<>();
        JList<Shift> jList = new JList<>(listModel);    

        public void createScheduleFrame(Container container) {
            
            displayShifts();
            
         
            jList.setCellRenderer(new MiniGrid());

            // Create a JScrollPane to allow scrolling if the list is too long
            JScrollPane scrollPane = new JScrollPane(jList);


            JButton addShiftBtn = new JButton("addShift");
            addShiftBtn.addActionListener(e -> addShift());
            
            filter.getSubmitBtn().addActionListener(e -> filterShifts());
            
            sort.getSubmitBtn().addActionListener(e -> sortShifts());   

            JPanel westPanel = new JPanel();
            westPanel.setLayout(new BoxLayout(westPanel, BoxLayout.Y_AXIS));
            westPanel.add(filter);
            westPanel.add(sort);

            JPanel eastPanel = new JPanel();
            eastPanel.setLayout(new BoxLayout(eastPanel, BoxLayout.Y_AXIS));
            eastPanel.add(addShiftBtn);
            
            // Create a panel to hold the JList and the Remove Shift button
            JPanel mainPanel = new JPanel(new BorderLayout());
            mainPanel.add(westPanel,BorderLayout.WEST);
            mainPanel.add(scrollPane, BorderLayout.CENTER); // Place JList at the top
            mainPanel.add(eastPanel, BorderLayout.EAST); // Remove button on the bottom of th 
            container.add(mainPanel);


        }
        /**
         * Customizes the format of the minigrid. 
         */
        private class MiniGrid extends DefaultListCellRenderer 
        {

            private static final int CELL_PADDING = 5; 
            private static final int BORDER_THICKNESS = 1; 
            private static final Color BORDER_COLOR = Color.BLACK;
            

            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) 
            {
                Shift shift = (Shift) value;

                JPanel panel = new JPanel(new GridLayout(4, 2, CELL_PADDING, CELL_PADDING));
                panel.setBackground(isSelected ? list.getSelectionBackground() : list.getBackground());
                 //The Details of the panel                                           
                
                panel.add(createLabel("Shift ID:"));
                panel.add(createLabel(Integer.toString(shift.getShiftID())));
                panel.add(createLabel("Date:"));
                panel.add(createLabel(shift.getShiftDateString()));
                panel.add(createLabel("Time:"));
                panel.add(createLabel(shift.getTimeString()));
                panel.add(createLabel("Hospital:"));
                panel.add(createLabel(shift.getHospital()));
                

                //The Border around the Panel
                panel.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createMatteBorder(0, 0, BORDER_THICKNESS, BORDER_THICKNESS, BORDER_COLOR),
                        BorderFactory.createEmptyBorder(CELL_PADDING, CELL_PADDING, CELL_PADDING, CELL_PADDING)
                ));
                return panel;
            }
            /**
            * Method to create a JLabel with specified text.
            * @param text Text for the label.
            * @return A JLabel with the given text.
            */
            private JLabel createLabel(String text) 
            {
                JLabel label = new JLabel(text);
                label.setHorizontalAlignment(SwingConstants.LEFT);
                return label;
            }
        }
        /**
         * Populates the JList with available shifts.
         */
        private void displayShifts() 
        {        
            var shifts = appsys.getAvailableShifts();
            System.out.println("here");
            ShiftCollection shiftCollection = new ShiftCollection(shifts);

            ShiftIterator shiftIterator =shiftCollection.createIterator();
            while (shiftIterator.hasNext()) 
            {
                Shift shift = shiftIterator.next();
                listModel.addElement(shift);
            }
        }
        /**
        * Adds the selected shift from the list.
        */
        private void addShift() 
        {
            int selectedIndex = jList.getSelectedIndex();
            if (selectedIndex != -1) 
            {
                Shift selectedShift = listModel.get(selectedIndex);
                
                ShiftManager shiftManager = new ShiftManager();
                //shiftManager.reserveShift(AppSystem.getAvailableShifts(), AppSystem.getCurrentNurse(), selectedShift); // Implement this method in NurseManager
                shiftManager.reserveShift(selectedShift); 
                listModel.remove(selectedIndex);
                
            }
            
        }
        /**
         * Applies filter to the shift list based on the selected filter options.
        */
        private void filterShifts()
        {
            listModel.clear();
            
            var shifts = appsys.getAvailableShifts();
            
            
            if(filter.getNoneBtn().isSelected())
            {
                System.out.println("radio button none");
                shifts = appsys.getAvailableShifts();
            }
            else if(filter.getABtn().isSelected())
            {
                System.out.println("radio button A");
                shifts = filter.filterShiftsByHospital(1);
            }
            else if(filter.getBBtn().isSelected())
            {
                System.out.println("radio button B");
                shifts = filter.filterShiftsByHospital(2);
            }
            else if(filter.getCBtn().isSelected())
            {
                System.out.println("radio button C");
                shifts = filter.filterShiftsByHospital(3);
            }
            else if(filter.getDBtn().isSelected())
            {
                System.out.println("radio button D");
                shifts = filter.filterShiftsByHospital(4);
            }
            else if(filter.getDayBtn().isSelected())
            {
                System.out.println("radio button day");
                shifts = filter.filterShiftsByType(1);
            }
            else if(filter.getNightBtn().isSelected())
            {
                System.out.println("radio button night");
                shifts = filter.filterShiftsByType(2);
            }
            
       
            ShiftCollection shiftCollection = new ShiftCollection(shifts);

            ShiftIterator shiftIterator =shiftCollection.createIterator();
            while (shiftIterator.hasNext()) 
            {
                Shift shift = shiftIterator.next();
                listModel.addElement(shift);
            }    
        }
        /**
        * Sorts the shift list based on the selections.
        */
        private void sortShifts()
        {
            listModel.clear();
            
            var shifts = appsys.getAvailableShifts();
            
            if(sort.getHospitalOpt().isSelected())
            {
                sort.sortCollection(shifts, sort.getCompByShiftHospital());
            }
            else if(sort.getTimeOpt().isSelected())
            {
                sort.sortCollection(shifts, sort.getCompByShiftType());
            }
            else if(sort.getDateOpt().isSelected())
            {
                sort.sortCollection(shifts, sort.getCompByShiftDate());
            }
            
            ShiftCollection shiftCollection = new ShiftCollection(shifts);

            ShiftIterator shiftIterator =shiftCollection.createIterator();
            while (shiftIterator.hasNext()) 
            {
                Shift shift = shiftIterator.next();
                listModel.addElement(shift);
            }
            
            
        }
    }
}
