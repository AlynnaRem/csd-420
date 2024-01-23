/*     
       Name: Alynna Rem
       Course: CSD-420
       Course Description: Advanced Java Programming 
       Instructor: Darrell Payne
       File Name: Module3.java
       Date: 8/28/2022
       Assignment: Module 3 Programming Assignment
       Instructions: 
            1. Write a test program that contains a static method that returns a new ArrayList.
                    The new ArrayList returned will contain all original values with no duplicates from the original ArrayList.
                    Fill the Original ArrrayList with 50 random values from 1 to 20.
                    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list)
            2. Write test code that ensures the code functions correctly.
*/

// import java.util package
import java.util.*;

// Declare a class named Module 3
public class Module3 {

    // Declare a static generic method that takes an array list and returns a new ArrayList containing the values from the original array list with no duplicates
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        
        // Create a generic empty array list
        ArrayList <E> newArrayList = new ArrayList<E>();
        
        // Loop through list
        for(int i=0;i<list.size();i++){
            
            // check if value is present in ArrayList or not*/
            if(!newArrayList.contains(list.get(i))){
                
                // if it's not in list, add it.
                newArrayList.add(list.get(i));
            }
        }
        
        /// return list
        return newArrayList;
        }
        
    // Declare main method to test the program
    public static void main(String[] args) {
        
        // Create object to generate random values
        Random randomNumber = new Random();
        
        // Create the originalArrayList
        ArrayList<Integer> originalArrayList = new ArrayList<Integer>();

        System.out.println("\nThis program will create an original array list of 50 random values ranging from 1 to 20.");
        System.out.println("Then it will pass the original array list to a method that will remove duplicates and assign the values to a new array list.\n");

        // Print a message for input of the originalArrayList 
        System.out.println("\noriginalArrayList:");
        
        // Loop through originalArrayList to add 50 random values from 1 to 20.
        for(int i=0;i<50;i++){
            // generate and add random numbers to originalArrayList 
            originalArrayList.add(randomNumber.nextInt(20)+1);
            // print the random numbers that are being added to the originalArrayList
            System.out.print(originalArrayList.get(i)+" ");
        }
        
        // Pass originalArrayList to the removeDuplicate method and store output as the newArrayList
        ArrayList<Integer> newArrayList = removeDuplicates(originalArrayList);

        // Print newArrayList by looping through each value
        System.out.println("\n\nnewArrayList:");
        for(int i=0;i<newArrayList.size();i++){
            System.out.print(newArrayList.get(i)+" ");
        }
    }
}