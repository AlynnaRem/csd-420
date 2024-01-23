/*     
       Name: Alynna Rem
       Course: CSD-420
       Course Description: Advanced Java Programming 
       Instructor: Darrell Payne
       File Name: FileReader.java
       Date: 8/13/2022
       Assignment: Module 1 Programming Assignment Part 2
       Instructions: 
            1. Write a program that stores:
                An array of five random integers
                A Data objective instance using the current date
                An array of five random double values
            2. Append the data in a file titled <yourname> datafile.dat.
            3. Write a second program that will read the file and display the data.
            4. Test the code to ensure the code functions correctly.
        
        Program Details: This program will read and display the contents of the file titled alynnarem_datafile.dat.
*/

// Import Java packages
import java.io.*;
import java.util.*;
import java.text.*;

// Declare a class called FileReader
public class FileReader {

    // Declare the main method to test/execute the program
	public static void main(String[] args) throws IOException {

        Scanner input = null;
        try {
            // Create a file object for the file
            File file = new File("alynnarem_datafile.dat"); 

            // Use the java.util.Scanner instance to read the file specified in the file object
            input = new Scanner(file);

            // Display message for readability
            System.out.println("\n\nHere are the contents of the file titled " + file + "\n\n");

            // Process the lines of the file and display the contents until there are no more lines
            String line;
            while (input.hasNextLine()) {
              System.out.println(input.nextLine());
            }
          }

          // Throw an exception
          catch(FileNotFoundException e)
          {
              e.printStackTrace();
          }
          finally {

            // if there are no more lines, close the scanner
            if (input != null) input.close();
          }
    }
}