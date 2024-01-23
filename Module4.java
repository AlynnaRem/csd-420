/*     
       Name: Alynna Rem
       Course: CSD-420
       Course Description: Advanced Java Programming 
       Instructor: Darrell Payne
       File Name: Module4.java
       Date: 10/08/2022
       Assignment: Redo Module 4 Programming Assignment
       Instructions:
           1. Write a test program that stores 50,000 integers in LinkedList and test the time to traverse the list using an iterator vs. using the get(index) method.
           2. Then, test your program storing 500,000 integers.
           3. After completing this program and having tested both values, in your comments, explain the results and discuss the time taken using both values and their difference with the get(index) approach.
           4. Write test code that ensures the code functions correctly.
*/

// import java.util package
import java.util.*;

// declare a class named Module4
public class Module4{
    
    // declare the main method to execute the program for testing
    public static void main(String[] args) {

        System.out.println("\nThis program will add values to a LinkedList");
        System.out.println("Display the number of values in the list");
        System.out.println("Traverse through the list using an iterator and display the time it took");
        System.out.println("Traverse through the list using the get(index) method and display the time it took\n");
        
        int value = 0; // create an integer variable named value and assign it a default value of 0
        long start; // create a long variable named start to hold the start time
        long stop; // create a long variable named stop to hold the stop time
        Random randomValue = new Random(); // create an instance of the Random class
        LinkedList<Integer> list = new LinkedList<Integer>(); // create a LinkedList of Integers
        
        for(int i = 0; i < 50000; i++){ // loop through the LinkedList and add 50,000 random integers

        /* remove // below and add to the for loop above to test the code with 500,000 random integers */
        //for(int i = 0; i < 500000; i++){ // loop through the LinkedList and add 500,000 random integers

            list.add(randomValue.nextInt(100) + 1);
        }

            // print the size of the list in a message
            System.out.printf("\nThe LinkedList contains %d values\n", list.size());

            // Use the list Iterator to traverse the list
            ListIterator<Integer> listIterator = list.listIterator();

            // Use the currentTimeMillis() method to capture the current time in milliseconds and assign it as the value of the start variable.
            start = System.currentTimeMillis();

            // Use the while loop to iterate through the LinkedList using the listIterator.
            while(listIterator.hasNext()){
                value = listIterator.next();
            }
            
            // At the end of the LinkedList, use the currentTimeMillis() method to capture the time and assign it as the value of the stop variable.
            stop = System.currentTimeMillis();

            // Print a message with the stop time minus the start time over 1000 to show how long it took
            System.out.println("The time in milliseconds it took to traverse the LinkedList using the iterator method is "+ (stop-start));

            // Use the currentTimeMillis() method to capture the current time in milliseconds and assign it as the value of the start variable.
            start = System.currentTimeMillis();

            // use the for loop to iterate through the Linkedlist  using the get(index) method.
            for(int i = 0; i<list.size(); i++){
                value =list.get(i);
            }
            
            // At the end of the LinkedList, use the currentTimeMillis() method to capture the time and assign it as the value of the stop variable.
            stop = System.currentTimeMillis();

            // Print a message with the stop time minus the start time over 1000 to show how long it took
            System.out.println("The time in milliseconds it took to traverse the LinkedList using the get(index) method is "+ (stop-start));
    }
}

/* Comments:

This program has been tested with the storage of 50,000 integers and 500,000 integers in a LinkedList.

The time it took to traverse through the LinkedList of 50,000 integers:
Using the iterator method, it took 0 milliseconds and using get(index) method, it took 697 milliseconds.
Based on the time, it appears the iterator method is much faster than the get(index) method to traverse the list.

The time it took to traverse through the LinkedList of 500,000 integers:
Using the iterator method, it took 4 milliseconds and using the get(index) method, it took 75356 milliseconds.
Based on the time, it appears the iterator method is still much faster than the get(index) method to traverse the list. 
However, the difference in time appears to be exponential as the number of values increase. 
Before testing the 500,000 interger list, I was assuming the time would increase as the number of values increased.
In example, If we multiplied 50,000 times 10, we get 500,000 and if we multiplied 697 milliseconds by 10, we would get 6,970 milliseconds. 
However, we got 75,356 milliseconds for the time it took to traverse the list using the get(index) method for the 500,000 integer list.

To conclude, it appears the iterator method is better for traversing a list because it's faster.

*/