import java.util.Random; 

public class GuessingGame {
	
	private int answer;

	private boolean gameOver;
	private int differential;
	private int max;
	private int maxGuessesAllowed; 
	private int numGuessesTaken; 
	
	public GuessingGame (){
		max = 0;  
		Random generator = new Random();
	}
	
	public GuessingGame(int userMax){
		max = userMax; 
		Random generator = new Random();
	}
	
	public void newGame(int max){
		maxGuessesAllowed = max; 
		answer = generator.nextInt(max);
		System.out.println(answer);
		
		gameOver = false; 
		differential = max; 
		numGuessesTaken = 0; 
	}
	
	public String guess(int userGuess){
		String repeat = "";
		int newGuess = 0; 
		int previousGuess = 0;
		int loop = 0;
		int compareOld = 0;
		int compareNew = 0;
		
		do{
			loop++;

			if(userGuess == answer){
				System.out.println("Congratulations");
				System.out.println("Would you like to play again, enter Y for yes, N for no: ");
			}
		
			else if (userGuess > answer)
				System.out.println("Too High");
			
			else if (userGuess < answer || userGuess > answer)
				System.out.println("Error, not in the range. ");
						
			else 
				System.out.println("Too Low");
		

		
			while(loop > 1){
				
				newGuess = userGuess; 
				compareOld = answer - previousGuess;
				compareNew = answer - userGuess; 
		
				if(compareNew < compareOld)
					System.out.println("Getting warmer");
				else if (compareNew > compareOld)
					System.out.println("Getting colder");
				
			}
			
			previousGuess = userGuess;
		
		}while(repeat.equalsIgnoreCase("y"));
	}
}



