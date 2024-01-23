/*     
       Name: Alynna Rem
       Course: CSD-420
       Course Description: Advanced Java Programming 
       Instructor: Darrell Payne
       File Name: FileWriter.java
       Date: 8/13/2022
       Assignment: Module 1 Programming Assignment Part 1
       Instructions: 
            1. Write a program that stores:
                An array of five random integers
                A Data objective instance using the current date
                An array of five random double values
            2. Append the data in a file titled <yourname> datafile.dat.
            3. Write a second program that will read the file and display the data.
            4. Test the code to ensure the code functions correctly.

        Program Details: This program will write the current date, an array of five random integers, and an array of five random double values to a file titled alynnarem_datafile.dat.
*/

// Import Java packages
import java.io.*;
import java.util.*;
import java.text.*;

// Declare a class called FileWriter
public class FileWriter {
    // Declare the main method to test/execute the program
	public static void main(String[] args) throws IOException {
        
        // Use the PrintWriter instance for writing to a file titled alynnarem_datafile.dat
        try (PrintWriter output = new PrintWriter(new FileOutputStream("alynnarem_datafile.dat", true))) {

            // Create instance of Random class
	        Random random = new Random(); 

            // Create an array to store 5 random integers.
            int[] intArray = new int[5];

            // Create an array to store 5 random doubles.
            double[] doubleArray = new double[5];

            // Create instance of date object
            Date obj = new Date();
            // Append date to file.
            output.println("Date: " + obj.toString() + "\n");
            
            output.println("intArray = ");
            // Use a for loop to generate 5 random integers and add them to the intArray.
            for (int i = 0; i < 5; i++) {
                intArray[i] = random.nextInt(); 
                //Append intArray to file
                output.println(intArray[i]);
                }
            
            output.println("\ndoubleArray = ");
            // Use a for loop to generate 5 random doubles and add them to the doubleArray.
            for (int i = 0; i < 5; i++) {
                doubleArray[i] = random.nextDouble(); 
                //Append doubleArray to file
                output.println(doubleArray[i]);
                }
        }
    }
}