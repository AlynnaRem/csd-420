/*     
       Name: Alynna Rem
       Course: CSD-420
       Course Description: Advanced Java Programming 
       Instructor: Darrell Payne
       File Name: Module5.java
       Date: 9/4/2022
       Assignment: Module 5 Programming Assignment
       Instructions:
           1. Write a test program that reads words from a text file and displays all non-duplicate words in ascending order and then in descending order.
                   The file is to be referenced in the program, not needing to be used as a command line reference.
                   The word file is to be titled collection_of_words.txt and included in your submission.
           2. Write test code that ensures the code functions correctly.
*/

// import java packages
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;

// declare a class named Module5
public class Module5{
    
    // declare the main method to execute the program for testing.
    // throw an exception if the file cannot be found.
    public static void main(String[] args) throws IOException{

        System.out.println("\nThis program will read words from a text file and display all non-duplicate words in ascending order and then in descending order.");

        // declare a variable titled file and assign the input file to the variable
        File file = new File("collection_of_words.txt");

        // Initialize a bufferedReader to read the file
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        
        // declare a variable titled word
        String line;

        // use treeSet to hold non-duplicate items and store them in ascending order
        TreeSet<String> treeSet = new TreeSet<>();
        
        // use while loop to iterate over the file and read the words
        while ((line = bufferedReader.readLine()) != null){
            String[] word = line.split(" "); // split string where there are spaces.
            for (int i = 0; i  < word.length; i++) // for (int i = word.length -1; i >= 0; i--)
            treeSet.add(word[i]); // add word to treeSet
   
            //treeSet.add(word); // adds words to the tree set through each iteration until there are no words remaining
        }

        // print words in ascending order
        System.out.println("\nWords in ascending order\n");

        // iterate over tree set to print the values.
        for (String value : treeSet)
        System.out.println(value);

        // print words in descending order
        System.out.println("\nWords in descending order\n");

        // use navigableSet to hold a copy the treeSet in descending order
        NavigableSet<String> treeReverse = treeSet.descendingSet();

        // iterate through the navigableSet
        Iterator<String> iterator = treeReverse.iterator();

        // use while loop to iterate through and print the words in the navigableSet
            while (iterator.hasNext()) {
                System.out.println(iterator.next());

        }
    }
}
