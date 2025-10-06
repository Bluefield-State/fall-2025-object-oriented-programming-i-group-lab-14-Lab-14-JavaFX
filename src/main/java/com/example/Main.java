package com.example;


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.util.Random;


public class Main extends Application
{
   // Named constants
   private final int ROWS = 1;	      // Number of rows
   private final int COLS = 3;	      // Number of columns
   private final int SIZE = 10;	      // Number of Image objects
   private final double ZERO = 0.0;    // Zero matches multiplier
   private final double DOUBLE = 2.0;  // Two matches multiplier
   private final double TRIPLE = 3.0;  // Three matches multiplier
   
   // Arrays
   private int[] slotMemory;           // To hold the slot values
   private Image[] images;             // To hold the Image objects
   private ImageView[] slotImages;     // To hold the ImageView components
   
   // Betting-related fields
   private double amountBet;	         // To hold the amount bet
   private double amountWon;	         // To hold the amount won
   private double totalWinnings;       // To hold the total winnings
   private boolean isValidBet;         // To hold the status of a bet
   
   // Controls
   TextField insertedTextField;
   Label displayInfoLabel;
   Label wonThisSpinOutputLabel;
   Label totalWonOutputLabel;
   
   public static void main(String[] args)
   {
      // Launch the application.
      launch(args);
   }
   
   @Override
   public void start(Stage primaryStage)
   {
      // Set all amounts to zero.

      
      // Set the bet status to false.

      
      // Initialize the images array.

      
      // Create an array of ints to represent
      // the slot machine in memory.

      
      // Create an array of ImageView controls
      // to represent the visible slots.

      
      // Initialize the slotImages array with blank images.
 

      
      // Put the slot images in an HBox.

      
      // Create the controls for the amount inserted.

      
      // Create the output labels.

      
      // Create the Spin button.

      
      // Register the event handler.
      spinButton.setOnAction(e ->
      {
         // Get the amount bet.
         getAmountBet();
    
         // Determine if the bet was valid.
         if (isValidBet)
         {
            // Display the slots.
            displaySlots();
   
            // Determine the winnings.
            determineWinnings();
         }
      });
      
      // Create a Label for instructions and game results.
      displayInfoLabel = new Label("Insert an amount to play.");

      // Put everything into a VBox
    
      
      // Add the main VBox to a scene.
      
      // Set the scene to the stage aand display it.

   }
   
   // The getAmountBet method converts the text to
   // a double and stores it in the amountBet field.
   //this function is complete
   private void getAmountBet()
   {
      // Create a String object to hold the input 
      // from the TextField.
      String strAmountBet = insertedTextField.getText();

      // Convert the String to a double and store it
      // in the amountBet field.
      try
      {
         amountBet = Double.parseDouble(strAmountBet);
         
         // Set the bet status to true.
         isValidBet = true;
      }
      catch (NullPointerException | NumberFormatException ex)
      {
         // Display the an error message.
         displayInfoLabel.setText("Error. Try a different amount.");
      
         // Set the bet status to false.
         isValidBet = false;
      }
   } 

   // The displaySlots method displays the slots.
   //this function is complete
   private void displaySlots()
   {
      // Create a Random object.
      Random rand = new Random();
      
      // Create random slots.
      for (int col = 0; col < COLS; col++)
      {
         // Generate a random number.
         int val = rand.nextInt(SIZE);

         // Set the slot value in memory.
         slotMemory[col] = val;

         // Set the slot image to display.
         slotImages[col].setImage(images[val]);
      }
   }
   
   // The determineWinnings method determines the winnings.
  //this function is complete
   private void determineWinnings()
   {  
      // Determine the winnings.
      if (slotMemory[0] == slotMemory[1] && 
          slotMemory[0] == slotMemory[2])
      {
         // If three of the images match, the user has won 
         // three times the amount entered.
         amountWon = amountBet * TRIPLE;
         
         // Display the instructions.
         displayInfoLabel.setText("Jackpot! TRIPLE WIN x 3!!");       
      }
      else if (slotMemory[0] == slotMemory[1] ||
               slotMemory[0] == slotMemory[2] ||
               slotMemory[1] == slotMemory[2])
      {
         // If two of the images match, the user has won 
         // two times the amount entered.
         amountWon = amountBet * DOUBLE;
         displayInfoLabel.setText("Sweet! DOUBLE WIN x 2!!"); 
      }
      else
      {
         // If none of the randomly displayed images match, 
         // the user has won $0.
         amountWon = amountBet * ZERO;
         displayInfoLabel.setText("No Luck. Play again!");
      }
      
      // Keep a running total of the winnings.
      totalWinnings += amountWon;
      
      // Display the winnings.
      wonThisSpinOutputLabel.setText(String.format("%,.2f", amountWon));
      totalWonOutputLabel.setText(String.format("%,.2f", totalWinnings));
   }
}