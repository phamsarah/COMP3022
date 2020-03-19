/**
 * This is the GuessingGame class that creates a random number and 
 * compares the user's guess with the randomly generated answer. 
 * 
 * @author Sarah Pham
 * @version 1.0
 * 
 * COP3022 Project #:1
 * File Name: GuessingGame.java
 * 
 */

import java.util.Random; 
import java.lang.Math;

public class GuessingGame {
	
	private int answer;
	private Random generator;
	private boolean gameOver;
	private int differential;
	private int max;
	private int maxGuessesAllowed; 
	private int numGuessesTaken; 
	
	public GuessingGame (){
		max = 0;  
		generator = new Random();
	}
	
	public GuessingGame(int userMax){
		max = userMax; 
		generator = new Random();
	}
	
	/**
	 * Creates a new game with a new maximum number of guesses allowed. Also 
	 * creates a new generated answer and sets the number of guesses to zero.
	 * @param maxGuess the user's chosen maximum guess count
	 */
	
	public void newGame(int maxGuess){
		maxGuessesAllowed = maxGuess; 
		answer = generator.nextInt(max);
		// System.out.println(answer);  // Commented for your convenience
		
		gameOver = false; 
		differential = max; 
		numGuessesTaken = 0; 
	}
	
	/**
	 * Uses user guess to output if the guess was incorrect, correct, out of range, or reaching max guess limit.
	 * Also hints to the user if their guess is getting warmer or colder. 
	 * @param userGuess the user's guess to what the generated number is
	 * @return returnString string containing response to user's guess compared to the answer
	 */
	
	public String guess(int userGuess){
		int previousGuess = 0;
		String returnString = "";
		
			numGuessesTaken++;
			
			if(userGuess == answer){	    // this if statement is if the user guessed correctly, game is over so it is set to true
				gameOver = true;
				return ("Congratulations\n");
			}
			
			
			if(numGuessesTaken >= maxGuessesAllowed){     // this statement checks if the guesses has reached the limit of guesses allowed, game is over and set to true 
					gameOver = true;
					return ("Reached max limit of guesses");
				}
			
		
			else if (userGuess > answer)                   // this statement checks if the user guess is higher than the answer
				returnString = "Too High\n";
				
			
			else if (userGuess < 0 || userGuess > max)      // this statement checks if the user's guess is out of the minimum and maximum range of the possible answer
				return("Error, not in the range. ");
						
			else 
				returnString = "Too Low\n";                 // this statement is the last option, which is the user's guess being lower than the answer
	
			previousGuess = Math.abs(userGuess - answer);	  // a previous guess is used by obtaining the absolute value of the difference of the user's guess and the answer
		
			if(numGuessesTaken > 1){						// hints are only started after the first guess
		
				if(previousGuess < differential)					// comparing previous and current guess differences
					return(returnString + "Getting warmer");
				
				else if (previousGuess > differential)
					return(returnString + "Getting colder");
					
			}
			
			differential = previousGuess;
			return returnString; 
		}
	/**
	 * This method returns true or false depending on the status of the gameOver variable. Also is used in the tester class to keep looping the user for replays. 
	 * @return true if the game is over
	 * @return false if the game is not over
	 */
	
	public boolean isGameOver() {
		
		if(gameOver == true)
			return true;
		
		else
			return false;
	}

}
	




