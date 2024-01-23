/*     
       Name: Alynna Rem
       Course: CSD-420
       Course Description: Advanced Java Programming 
       Instructor: Darrell Payne
       File Name: BubbleSort.java
       Date: 9/11/2022
       Assignment: Module 6 Programming Assignment
       Instructions:
           1. Write a program with the two following generic methods using a bubble sort. 
              The first method sorts the elements using the Comparable interface, and the second uses the Comparator interface.
                  public static <E extends Comparable<E>>
                      void bubbleSort(E[] list)
                  public static <E> void bubbleSort(E[] list,
                      Comparator<? super E> comparator)
               Attached above is a solution zip file for your review. Ensure you actually write your own code, only using the attached solution as an example, and document your code.
           2. Write test code that ensures your code functions correctly.
*/


// Import Java Comparator interface
import java.util.Comparator;

// Declare a class titled BubbleSort
public class BubbleSort {
	
    // Declare a method that sorts a Comparable list of elements using bubble sort
	public static <E extends Comparable<E>> void bubbleSort(E[] list) {
        
        // use the CompareTo() method to sort the string in natural/alphabetical order
        bubbleSort(list, (e1, e2) -> ((Comparable<E>)e1).compareTo(e2));
    }

    // Declare a method that sorts a generic list using the Comparator interface 
	public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator) {
		
        // Declare a boolean variable titled needNextPass and assign it a value of true
        boolean needNextPass = true;

        // loop from j = 1 to list.length 
		for (int j = 1; j < list.length && needNextPass; j++) {
            
            // update variable needNextPass to false 
			needNextPass = false;

            // loop from i = 0 to list length - j
			for (int i = 0; i < list.length - j; i++) {

                // compare elements at i and i + 1 using the compare() method.
				if (comparator.compare(list[i], list[i + 1]) > 0) {
					
                    // create temp variable to hold element at i
					E temp = list[i];
                    // replace element at i with element at i + 1
					list[i] = list[i + 1];
                    // replace element i + 1 with element at i that was held in the temp variable
					list[i + 1] = temp;

                    // update variable needNextPass to true
					needNextPass = true;

				}
			}
		}
	}

  // Declare the main method for executing and testing the program
  public static void main(String[] args) {

    System.out.println("\n\nThis program will sort the following unordered lists: \n");

    System.out.println("list = 100, 90, 80, 70, 60, 50, 40, 30, 20, 10");

    System.out.println("list1 = red, blue, orange, yellow, green, purple, black");

    // Declare an unsorted integer list
    Integer[] list = {100, 90, 80, 70, 60, 50, 40, 30, 20, 10};

    // Pass the list to the bubbleSort method for sorting
    bubbleSort(list);

    System.out.println("\nOrdered list:");

    // loop from i = 0 to list.length and increment i by 1 through each iteration
    for (int i = 0; i < list.length; i++) {
        // print elements at i through each iteration and a space
        System.out.print(list[i] + " ");
    }

    // print empty line
    System.out.println();

    // Declare an unsorted string list
    String[] list1 = {"red", "blue", "orange", "yellow", "green", "purple", "black"};

    // pass list1 to the bubbleSort method using the comparable interface to sort the list
    bubbleSort(list1, (s1, s2) -> s1.compareToIgnoreCase(s2));

    System.out.println("\nOrdered list1:");

    // loop from i = 0 to list.length and increment i by 1 through each iteration
    for (int i = 0; i < list1.length; i++) {
        // print elements at i through each iteration and a space
        System.out.print(list1[i] + " ");
    }

    // print empty line
    System.out.println();   
  }
}
