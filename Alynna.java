/*     
       Name: Alynna Rem
       Course: CSD-420
       Course Description: Advanced Java Programming 
       Instructor: Darrell Payne
       File Name: Alynna.java
       Date: 9/18/2022
       Assignment: Module 8 Programming Assignment
       Instructions:
           1. Create a class titled <your first name here> ThreeThreads.
               In this class, you are to use three threads to output three types of characters to a text area for display.
                   In the first thread, you are to output random letter characters 
                       such as a, b, c, d …
                   In the second thread, you are to output random number digits 
                       such as 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
                   In the third thread, you are to output random characters 
                       such as !, @, #, $, %, &, *
               Display a minimum of 10,000 of each of the three sets.
           2. Write test code that ensures all methods function correctly.
*/

// import Java packages
import java.util.*;
import java.lang.*;

// Java code for thread creation by extending the Thread class

class RandomCharacter extends Thread{ // thread 1 generates random letter characters (a-z)
    public void run(){ // use the run() method to execute the thread when an object of this class is created in the main method
        Random random = new Random(); // Create instance of Random class
        for(int i=0; i < 10000; i++){ // Use the for loop to add random letter characters to an array
            char randomCharacters = (char) (random.nextInt(26) + 'a');
        System.out.println("Thread 1 Random Characters: " + randomCharacters); // Print the thread that is running
        }
    }
}

class RandomNumber extends Thread{ // thread 2 generates random number digits (0-9)
    public void run(){ // use the run() method to execute the thread when an object of this class is created in the main method
        for(int i=0; i < 10000; i++){ // Use the for loop to add random numbers to an array
            int randomNumbers =  (int)(Math.random() * (9-0+1)+0); // generate random math numbers
        System.out.println("Thread 2 Random Numbers: " + randomNumbers); // Print the thread that is running
        }
    }
}

class RandomASCII extends Thread{ // thread 3 generates random characters (including !, @, #, $, %, &, *)
    public void run(){ // use the run() method to execute the thread when an object of this class is created in the main method
        for(int i=0; i < 10000; i++){ // Use the for loop to add random characters to an array
            Random random = new Random(); // Create instance of Random class
            System.out.println("Thread 3 ASCII: " + String.valueOf((char)(random.nextInt(95)+32))); // Print the thread that is running
        }
    }
}

public class Alynna{ // Declare main class

    public static void main(String[] args) { // Declare main method to execute the program

        RandomCharacter object1 = new RandomCharacter(); // Create new object for the RandomCharacter Class
        RandomNumber object2 = new RandomNumber(); // Create new object for the RandomNumber Class
        RandomASCII object3 = new RandomASCII(); // Create new object for the RandomCASCII Class

        object1.start(); // call the start() method to start the execution of thread 1. Start() invokes the run() method on the Thread object.
        object2.start(); // call the start() method to start the execution of thread 2. Start() invokes the run() method on the Thread object.
        object3.start(); // call the start() method to start the execution of thread 3. Start() invokes the run() method on the Thread object.
    }

}