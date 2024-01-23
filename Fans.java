
/*     
       Name: Alynna Rem
       Course: CSD-420
       Course Description: Advanced Java Programming 
       Instructor: Darrell Payne
       File Name: Fans.java
       Date: 10/2/2022
       Assignment: Module 10 Programming Assignment
       Instructions:
           1. Write a program that views and updates fan information stored in database titled "databasedb", user ID titled student1 with a password pass.
           2. The table name is to be fans with the fields of ID (integer, PRIMARY KEY), firstname (varchar(25)), lastname (varchar(25)), and favoriteteam (varchar(25)).
           3. Your interface is to have 2 buttons to display and update records.
                  The display button will display the record with the provided ID in the display (ID user provides).
                  The update button will update the record in the database with the changes made in the display.
           4. Your application is not to create or delete the table.
           5. To work on this using your home database, you can make the table and populate it.
           6. When the application is tested, the table will already be created and populated.
           7. Write test code that ensures all methods and the interface functions correctly.
*/

// Import Java Packages

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;

public class Fans { // Declare a class titled Fans
    
    int ID; // Create an int id variable
    
    String firstname, lastname, favoriteteam; // Create variables to hold the first name, last name, and favorite team
    
    public static void main(String[] args) { // Declare the main method to execute the program
        
        start(); // Call the start() method.
        
        }
        
        private static void start() {

            JFrame f = new JFrame(); // Create a new frame/window

            JLabel l1 = new JLabel("Enter Id :"); // Create a labe to prompt user to enter ID
            
            JTextField t1 = new JTextField(10); // Create text field for user to enter ID
            
            JButton display = new JButton("Display"); // Create display button
            
            JButton update= new JButton("Update"); // Create update button
            
            JLabel error = new JLabel(); // Create error label
            
            error.setForeground(Color.red); // set foreground color to red

            error.setVisible(false); // set visibility to false
            
            display.addActionListener(new ActionListener(){ // implement an action listener to define what should be done when an user performs certain operation.
                 
                @Override // override the parent class
                
                public void actionPerformed(ActionEvent e) { // implement a method titled actionPerformed to react to the action
                    
                    Fans f = null;  // set the frame to null
                    
                    try { // use the try/catch block to catch errors and display a message
                        
                        int ID = Integer.parseInt(t1.getText().toString()); // parse the string and return an integer
                        
                        f = getRecord(ID); // get ID
                        
                        if(f != null) {
                            
                            display(f); // if f is not equal to null, display f.
                            
                        }
                            
                        else {
                            
                            error.setText("No matched data found !!! Try Again."); // Display error message if no match is
                            
                            error.setVisible(true); // Set error message visible
                            
                        }
                    }
                    
                    catch(Exception e1) {
                                
                        error.setText("Please enter a valid numeric ID to be searched"); // Display exception message to user
                                
                        error.setVisible(true); // Set exception message visible
                                
                    }
                }
            }
        );
        
        update.addActionListener(new ActionListener(){ // Add ActionListener for update
            
            @Override // override the parent class
            
            public void actionPerformed(ActionEvent e) { // implement a method titled actionPerformed to react to the action
                
                Fans f = null; // set the frame to null
                
                try { // use the try/catch block to catch errors and display a message
                    
                    int ID = Integer.parseInt(t1.getText().toString()); // parse the string and return an integer
                    
                    f = getRecord(ID); // get ID
                    
                    if (f != null) { 
                        
                        update(f); // if f is not equal to null, display f.
                        
                    }
                    
                    else {
                        
                        error.setText("No matched data found !!! Try Again.");
                        
                        error.setVisible(true);
                        
                    }
                        
                }
                
                catch(Exception e1) {
                    
                    error.setText("Please enter a valid numeric ID to be searched");
                    
                    error.setVisible(true);
                    
                }    
            }
        }
    );
    
    JPanel p1 = new JPanel(); // create new panel
    
    p1.add(l1); // add 
    
    p1.add(t1);
    
    JPanel p2 = new JPanel();
    
    p2.add(display);
    
    p2.add(update);
    
    JPanel p3 = new JPanel();
    
    p3.add(error);
    
    f.setLayout(new GridLayout(3,1));
    
    f.add(p1);
    
    f.add(p2);
    
    f.add(p3);
    
    f.setVisible(true);
    
    f.setBounds(200, 200, 600, 400);
    
    f.setSize(400, 200);
    
    f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
    
}

private static Fans getRecord(int ID) throws SQLException {
    
    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","databasedb","pass"); // use the DriverManage class to connect to the database
        
        String QUERY = "select * from fans where ID = "+"'"+ ID +"'"; // Create query to return all from the fans table where id matches what the user entered
        
        Statement stmt = con.prepareStatement(QUERY); // use the PreparedStatement object for sending SQL statements to the database
        
        ResultSet rs = stmt.executeQuery(QUERY); // Execute the query
        
        Fans f = null; 
        
        while(rs.next()) {
            
            f = new Fans();
            
            f.ID = rs.getInt(1);
            
            f.firstname = rs.getString(2);
            
            f.lastname = rs.getString(3);
            
            f.favoriteteam = rs.getString(4);
        }
        
        con.close(); // Close the connection to the database
        
        return f; 
        
    }
    
    private static void updateRecord(int ID, String fname, String lname, String favTeam) throws SQLException {
        
        Connection con = DriverManager.getConnection( // use the DriverManage class to connect to the database
            
            "jdbc:oracle:thin:@localhost:1521:xe","databasedb","pass");
            
            String QUERY = "update fans set firstname="+"'"+fname+"'"+", lastname='"+lname+"', favoriteteam='"+favTeam+"' where ID="+ID; 
            
            Statement stmt = con.prepareStatement(QUERY); // use the PreparedStatement object for sending SQL statements to the database
            
            stmt.executeUpdate(QUERY); // Execute the query
            
            con.close(); // Close the connection to the database

}

private static void display(Fans f) {
    
    JFrame f1 =new JFrame();
    
    JLabel l1 = new JLabel(" ID : "+ f.ID);
    
    JLabel l2 = new JLabel(" First Name : " + f.firstname);
    
    JLabel l3 = new JLabel(" LastName : " + f.lastname);
    
    JLabel l4 = new JLabel(" Favorite Team : " + f.favoriteteam);
    
    JButton b = new JButton("OK");
    
    b.addActionListener(new ActionListener(){
        
        @Override
        
        public void actionPerformed(ActionEvent e) {
            
            f1.dispose();
        }
    }
);

JPanel p1 = new JPanel();

p1.add(l1);

JPanel p4 = new JPanel();

p4.add(l4);

JPanel p2 = new JPanel();

p2.add(l2);

JPanel p3 = new JPanel();

p3.add(l3);

JPanel p5 = new JPanel();

p5.add(b);

f1.add(p1);

f1.add(p2);

f1.add(p3);

f1.add(p4);

f1.add(p5);

f1.setLayout(new GridLayout(5,1));

f1.setVisible(true);

f1.setSize(400, 400);

}

private static void update(Fans f) {
    
    JFrame f1 =new JFrame();
    
    JLabel l1 = new JLabel(" First Name : ");
    
    JTextField t1 = new JTextField(f.firstname,20);
    
    JLabel l2 = new JLabel(" LastName : ");
    
    JTextField t2 = new JTextField(f.lastname,20);
    
    JLabel l3 = new JLabel(" Favorite Team : ");
    
    JTextField t3 = new JTextField(f.favoriteteam,20);
    
    JButton b = new JButton("update");
    
    b.addActionListener(new ActionListener(){
        
        @Override
        
        public void actionPerformed(ActionEvent e) {
            
            try {
                
                updateRecord(f.ID,t1.getText().toString(),t2.getText().toString(),t3.getText().toString());
                
                JOptionPane.showMessageDialog(null, "Record updated Successfully !!!");
                
            }
            
            catch(Exception e1) {
                
                JOptionPane.showMessageDialog(null, "Can not update record!!! Try Again");
                
            }
            
            f1.dispose();
        }
    }
);

JPanel p1 = new JPanel();

p1.add(l1);

p1.add(t1);

JPanel p2 = new JPanel();

p2.add(l2);

p2.add(t2);

JPanel p3 = new JPanel();

p3.add(l3);

p3.add(t3);

JPanel p4 = new JPanel();

p4.add(b);

f1.add(p1);

f1.add(p2);

f1.add(p3);

f1.add(p4);

f1.setLayout(new GridLayout(4,1));

f1.setVisible(true);

f1.setSize(400, 400);

}

}