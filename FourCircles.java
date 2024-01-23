/*     
       Name: Alynna Rem
       Course: CSD-420
       Course Description: Advanced Java Programming 
       Instructor: Darrell Payne
       File Name: FourCircles
       Date: 9/11/2022
       Assignment: Module 7 Programming Assignment Part 2
       Instructions:
           Write a program that displays four circles and uses the style class and ID. 
           The sample run of the program is shown in the following image. 
           Use the mystyle.css found early in Chapter 31
*/

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.geometry.Pos;

public class FourCircles extends Application { // Declare a class titled FourCircles that extends Application

  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {

    HBox hBox = new HBox(5); // Create a new HBox
    hBox.setAlignment(Pos.CENTER);

    Scene scene = new Scene(hBox, 300, 250); // Create a new Scene
    
    scene.getStylesheets().add("stylesheet.css"); // Load the style sheet from the file stylesheet.css 

    Pane pane1 = new Pane(); // Create pane 1
    Circle circle1 = new Circle(40, 125, 30); // create circle 1
    pane1.getChildren().addAll(circle1); // add circle 1 to pane 1
    pane1.getStyleClass().add("border"); // add a style class
    circle1.getStyleClass().add("plaincircle"); // add a style class

    Pane pane2 = new Pane(); // Create pane 2
    Circle circle2 = new Circle(30, 125, 30); // create circle 2
    pane2.getChildren().addAll(circle2); // add circle 2 to pane 2
    circle2.getStyleClass().add("plaincircle"); //add a style class

    Pane pane3 = new Pane(); // Create pane 3
    Circle circle3 = new Circle(30, 125, 30); // create circle 3
    pane3.getChildren().addAll(circle3); // add circle 3 to pane 3
    circle3.setId("redcircle"); //add a style ID

    Pane pane4 = new Pane(); // Create pane 4
    Circle circle4 = new Circle(30, 125, 30); // create circle 4
    pane4.getChildren().addAll(circle4); // add circle 3 to pane 3
    circle4.setId("greencircle"); //add a style ID

    hBox.getChildren().addAll(pane1, pane2, pane3, pane4); // add StackPanes to the main pane
    
    primaryStage.setTitle("Four Circles"); // Set the window title
   
    primaryStage.setScene(scene); // Place the scene in the window

    primaryStage.show(); // Display the window
  }

  public static void main(String[] args) { // Declare main method to execute the program

    launch(args);
  }
}
