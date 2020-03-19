# Programming Project #1
## Due 2019-01-20 @ 11:59pm CST

## Project Outcomes:
1. To develop skills in using the Java selection constructs (if, and if else).
1. Use the Java iteration constructs (while, do, for).
1. Use Boolean variables and expressions to control iterations.
1. Random number generation.
1. Proper Design techniques

## Preparatory Readings:
Zybook for Java Chapters 1 - 4

## Background Information:
The Unified Modeling Language (UML) provides a useful notation for designing and developing object-oriented software systems.
One of the basic components of UML is a class diagram, which is used to depict the attributes and behaviors of a class.
A basic class diagram (as shown in the figure below) has three components.
The first is the class name.
The second component includes the class's attributes or fields.
Each attribute is followed by a colon (:) and its data type.
The third component includes the class's behaviors or methods.
If the method takes parameters, their types are included in parentheses.
Each behavior is also followed by a colon (:) and its return type.
If the return value of a method is void, the return type can be omitted.
For more information on UML, refer to https://www.uml.org/. 

## Project Requirements:
1.  Develop a simple class that represents a number guessing game.
The game is played by the program randomly generating a number and the user attempting to guess that number.
After each guess the program will provide a hint to the user identifying the relationship between the number and the guess.
If the guess is above the answer then "Too High" is returned, if the guess is below the answer then "Too Low" is returned.
If the difference between the answer and the guess is less than the difference between the answer and the previous guess, "Getting warmer" is returned.
If the difference between the answer and the guess is more than the difference between the answer and the previous guess, then "Getting Colder" is returned.\
![UML diagram of the GuessingGame class](http://www.plantuml.com/plantuml/png/NOv1RiCW44Ntd6AMjgfUW9Mxyh9IsmjCozX2XK5Ym8uKvUvXR2kHi_oFn_m_IC5SQWpcBw08Z9L4FCyZHW9pDU-0B2jbiE2vj3WJKyQIb7mXknH1QTC_bqtxJIaGibBdfuaoSV4OzWDA8rvEOQia-GWXhUGUHLpZyVA3_yHMwTjfNzU_0EYQr4EZJAk2BLjOadSDpghkYeNlajilTRsCn_gkV-utDpCGknh37G00)

1. The program will allow the user to play multiple games.
Once a game is completed the user will be prompted to play a new game or quit. 
1. Design and build a GuessingGame class. 
	1. Seven instance variables. 
		1. `answer` - an integer representing the randomly generated number. 
		1. `generator` - a random Generator object (created from the Java API Random class)(zyBooks Section 2.14).
		1. `gameOver` - a Boolean, false if game still in progress, true if the game is over. 
		1. `differential` - an integer representing the difference between a guess and the answer. 
		1. `max` - maximum value of the number to guess.  For example, if the maximum number is 100 then the number to guess would be between 0 and 100. (inclusive) 
		1. `maxGuessesAllowed` - the maximum number of guesses the user gets, once this value is passed the game is over. 
		1. `numGuessesTaken` - an integer that stores the number of guessed taken so far in any game. 
	1. Constructor and Methods 
		1. Default Constructor
			1. Sets max to zero.
			1. Creates the random number generator object.
		1. Parameterized Constructor
			1. Takes an integer parameter representing the maximum value of the number to guess. 
			1. Creates the random number generator object. 
		1. `newGame` method 
			1. Takes in an integer as a parameter representing the maximum number of guesses and sets maxGuessesAllowed.
			In other words, the parameter represents how many guesses the user gets before the game is over.
			1. Generates the answer using the random number generator. (0 - max). 
			1. Sets gameOver to false. 
			1. Sets differential to the max value. 
			1. Sets numGuessTaken to zero. 
		1. `guess` method 
			1. Takes in an integer as a parameter representing a new guess. 
			1. Compares the new guess with the answer and generates and returns a String representing an appropriate response. 
			1. The response is based on:
				1. The relation of the guess and answer (too high, too low or correct). 
				1. The comparison of difference between the current guess and the answer and the previous guess and the answer. (warmer, colder) .
				1. Guess out of range error, if the guess is not between 0 and the max number (inclusive) (see sample run below) .
			1. User has taken too many guesses because numGuessesTaken is greater than maxGuessesAllowed. If this is the case set isGameOver to true. 
		1. `isGameOver` method - returns the state of game.
			1. `true` if game is over.
			1. `false` if still in progress. 
		1. Accessor and mutator methods for all instance fields except the Random number generator.
		Use the Accessor or mutator methods within the other methods of the class rather than directly accessing the instance fields.
		For example, use mutator methods in the parameterized constructor to modify instance variables. 

1. Design and build GuessingGameTester class .
	1. This program will create GuessingGame objects and completely test the GuessingGame Class. 
	1. The tester will also provide two loops. 
		1. The first loop will allow the user to play a new game after the previous game is completed. 
		1. The second or nested loop will prompt the user for a new guess and provide a response based on the guess. 

## Sample Output:
```Welcome to the Guessing Game
Enter the maximum number
100
answer is: 8 (Included for testing only, should not be displayed in the final program)
Enter the number of guesses allowed:
6
Enter your guess, remember it must be between 0 and 100
50
Too High
Enter your guess, remember it must be between 0 and 100
25
Too High
Getting Warmer
Enter your guess, remember it must be between 0 and 100
12
Too High
Getting Warmer
Enter your guess, remember it must be between 0 and 100
6
Too low
Getting Warmer
Enter your guess, remember it must be between 0 and 100
8
Congratulations
Would you like to play again, enter y for yes, n for no.
y
Welcome to the Guessing Game
Enter the maximum number
50
answer is: 36
Enter the number of guesses allowed:
5
Enter your guess, remember it must be between 0 and 50
60
Guess out of range, The guess must be between 0 and 50
Enter your guess, remember it must be between 0 and 50
25
Too low
Enter your guess, remember it must be between 0 and 50
48
Too High
Getting Colder
Enter your guess, remember it must be between 0 and 50
37
Too High
Getting Warmer
Enter your guess, remember it must be between 0 and 50
36
Congratulation
Would you like to play again, enter Y for yes, N for no.
n 
```

Implementation Notes:
1. The inner loop, (request the next guess) should use the class's isGameOver method to determine if a new guess is needed. 
1. Boolean values and predicate method, (methods that return a Boolean) are essential in this project. 
1. No loops are required in the class's methods, they are only needed in the Tester. 

## Submission Requirements:
Your project should follow the instructions below. Any submissions that do not follow the stated requirements will not be graded. 
1. Projects must be submitted by committing your code and pushing to the Github repository.
1. You should have a minimum of two files for this assignment: 
	1. GuessingGame.java - The GuessingGame class, 
	1. GuessingGameTester.java - A driver program for your GuessingGame class. 
1. Remember to compile and run your program one last time before you submit it.
If your program will not compile, the graders will not be responsible for trying to test it. 

## Important Notes:
1. Projects will be graded on whether they correctly solve the problem, and whether they adhere to good programming practices.
1. Projects must be submitted by the time specified on the due date.
Projects submitted after that time will get a grade of zero. 
1. Please review UWF's academic conduct policy.
Note that viewing another student's solution, whether in whole or in part is considered academic dishonesty.
Also note that submitting code obtained through the Internet or other sources, whether in whole or in part, is considered academic dishonesty.
All programs submitted will be reviewed for evidence of academic dishonesty, and all violations will be handled accordingly.