/**
 * This is the GuessingGameTester class that tests the GuessingGame class
 * with user input and loops.
 * 
 * @author Sarah Pham
 * @version 1.0
 * 
 * COP 3022 Project #:1
 * File Name: GuessingGameTester.java
 * 
 */
import java.util.Scanner;

public class GuessingGameTester {
	public static void main(String[] args){
		Scanner scnr = new Scanner(System.in);
		String repeat = ""; 			 // This string is used to keep the do-while loop running
		
		do {  								// Program is in a do-while loop to keep the user looping until they press N to quit when asked
		
			System.out.println("Enter the maximum number: ");
				int maximum = scnr.nextInt();
				
				GuessingGame play = new GuessingGame(maximum);                // Object play is created 
			
			
			System.out.println("Enter the number of guesses allowed: ");
				int maxGuess = scnr.nextInt();
			
				play.newGame(maxGuess);                                      // A new game is created with the maximum guesses
				
			while(play.isGameOver() == false) {             				// User guesses are in a while loop until the game is over
				
				System.out.println("Enter your guess, remember it must be between 0 and " + maximum);
					int userGuess = scnr.nextInt();
			
					System.out.println(play.guess(userGuess));
			}
			
			System.out.println("Would you like to play again, enter Y for yes, N for no. ");  
			repeat = scnr.next();
			
		}while(repeat.equalsIgnoreCase("Y"));
		
	}
}


