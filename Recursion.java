/*     
       Name: Alynna Rem
       Course: CSD-420
       Course Description: Advanced Java Programming 
       Instructor: Darrell Payne
       File Name: Recursion.java
       Date: 8/13/2022
       Assignment: Module 2 Programming Assignment
       Instructions: 
            1. Create a program using a recursive method that returns the sum of the following type inputs.
                    m(i) = 1/2 + 2/3 + 3/4 + 4/5 + 5/6 … i/(i + 1)
                    ‘m’ is to be replaced with the method name you use.
            2. Use three different input finishing values, testing your code to ensure it functions correctly.
                    Examples: m(4), m(9), m(14).

        Program Details: This program will return the sum of fractions 
*/

// Declare a class named Recursion
public class Recursion{

  // Method for computing printSum(i)
  public static double printSum(double i){

    // base case
    if (i == 0){
        // if i == 0, return 0 and exit the function.
        return 0;
    }

    // recursive method
    else{
        // call to the printSum method until the base case is reached, while adding the value of i/(i+1) each time printSum function is called.
        double Fraction = i/(i+1);
        System.out.println(Fraction);
        return Fraction + printSum(i-1);
    }
  }

  // Declare the main method to execute and test the program
  public static void main(String [] args){

    // Print program details
    System.out.println("\nThis program will display the sum of the following type inputs using a recursive method.");
    System.out.println("printSum(i) = 1/2 + 2/3 + 3/4 + 4/5 + 5/6 … i/(i + 1) \n\n\n");
    

    // Three different input fininishing values used to test the program
    System.out.println("printSum(4) = " + printSum(4) + "\n\n"); // Validation: 1/2 + 2/3 + 3/4 + 4/5 = 2.71666666667
    System.out.println("printSum(9) = " + printSum(9) + "\n\n"); // Validation: 1/2 + 2/3 + 3/4 + 4/5 + 5/6 + 6/7 + 7/8 + 8/9 + 9/10 = 7.07103174603
    System.out.println("printSum(15) = " + printSum(15) + "\n\n"); // Validation: 1/2 + 2/3 + 3/4 + 4/5 + 5/6 + 6/7 + 7/8 + 8/9 + 9/10 + 10/11 + 11/12 + 12/13 + 13/14 + 14/15 + 15/16 = 12.6192710068

  }
}

// This program has been tested
// Referenced module examples 1 and 2 from Recursion Video Tutorials

