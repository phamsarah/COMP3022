
import java.util.Scanner;

public class GuessingGameTester {
	public static void main(String[] args){
		Scanner scnr = new Scanner(System.in);
		int maximum = 0;
		int maxGuess = 0; 
		int userGuess = 0;
		String repeat = "";
		
		do {
			System.out.println("Enter the maximum number: ");
				maximum = scnr.nextInt();
		
				GuessingGame play = new GuessingGame(maximum);
			
			System.out.println("Enter the number of guesses allowed: ");
				maxGuess = scnr.nextInt();
			
				play.newGame(maxGuess);
			
			System.out.println("Enter your guess, remember it must be between 0 and " + maxGuess);
				userGuess = scnr.nextInt();
				
				play.guess(userGuess);
			
			}while(repeat.equalsIgnoreCase("Y"));
				}
}


