# Java Project # 2 - Cipher Accounts

## Project Outcomes:
Use Java to:
1. Implement a super class in Java to produce reusable classes.
1. Develop a program with several classes.
1. Extend the functionality of existing classes.
1. Use method calls to perform logic steps.

## Prep Readings:
ZyBooks Chapters 1 - 8.

## Background Information:
1. An internet bot, also known as a crawler, scraper or simply bot, is a software application that runs automated tasks (scripts) over the Internet.
1. Typically, bots perform tasks that are both simple and structurally repetitive, at a much higher rate than would be possible for a human alone.
More than half of all web traffic is made up of bots.
1. It turns out that Bots use passwords similar to the way users do.
1. Both User and Bots need passwords to access system.
The basic objective of Programming Project 2 is to create classes that enable you to develop an application that can manage both types of accounts.
1. This functionality can be realized by implementing inheritance.
1. Encryption Algorithm:
	1. Implement a simple shift cipher.
	1. A shift cipher is a form of substitution cipher in which each letter in the plaintext is replaced by a letter some fixed number of positions down the alphabet.
	For example, with shift of 3, A would be replaced by D, B would become E, and so on.
	1. The shift for this program will be (possibly) different for each user.
	This type of individual shift is typically referred to as a salt.
	1. The password may be any of the characters in the [ASCII table](http://www.asciitable.com/) from character 33 the exclamation point '!' to character 122 the lower case 'z'.
	1. If the shift causes the character to be greater than 122, the shift will continue starting with character 33.
	1. For example, if the salt for a given Account is 8 and a letter in the password is lower case 'x' (char 120) a shift of 8 would result in the character '&' (char 38).

## Project Requirements:
### Account class
1. Superclass
1. Instance variables
	1. plaintextPassword 
		1. String 
			1. Must be at least 8 characters long.
			1. Must contain at least one of each type of character: uppercase, lowercase, number, and special character.
	1. salt
		1. int
		1. Must be between 1 and 10(inclusive)
	1. accountID - A unique integer that identifies each account.
	1. nextIDNum - a static int that starts at 1000 and is used to generate the accountID.
1. Parameterized constructor
	1. Takes in plaintextPassword, salt.
	2. Calls 
1. setPlaintextPassword method
	1. Takes in a string and verifies that it meets the minimum password requirements.
1. encrypt method
	1. Uses the instance variables plaintextPassword and salt to encrypt the password.
1. toString - returns a nicely formatted String representing the instance variables of the Account class and the encrypted version of the password.

**NOTE:  Your Account class should ensure the plaintextPassword is valid as described in the requirements.
If not write an error message to the standard output and continue.
Set the plaintextPassword and encyrptedPassword to the empty String.**

### User Class
1.	Subclass of Account class.
2.	Instance variables
	1. username - String
	1. fullName - String
	1. deptCode - int representing the department code
1. Methods
	1. Parameterized constructors
		1. Call the super class constructor passing appropriate parameters to it.
		1. Set the rest of the variables to the remaining parameters.
	1. Accessor and mutator methods for all variables in this class.
	1. toString
		1. Calls super class methods as needed.
		1. Returns a nicely formatted String representing the user to include fullName, username, and deptartmentCode.

### Bot Class
1. Subclass of Account class.
1. A class that stores information about an application that performs an automated task.
1. Instance Variables
	1. userAgent - String representing the user-agent string for the bot.
	1. category - String providing the Bot category which will be either searchEngine, sysAdmin, malicious.
	1. createdBy - String representing the creator name or handle.
1. Methods
	1. Parameterized Constructor 
		1. Takes in all parameters required to set the instance variables.
		1. Call the super class constructor passing appropriate parameters to it.
		1. Set the rest of the variables to the remaining parameters.
	1. Accessor and mutator methods for all variables in this class.
	1. toString
		1. Calls super class methods as needed.
		1. Returns a nicely formatted String representing the Bot to include Bot user-agent string, purpose, and creator name.

### The AccountTester
1. This class should consists of a main method that tests all the methods in each class, either directly by calling the method from the Tester or indirectly by having another method call a method.
1. User and Bot information will be read from a file.
A sample file is provided.
Use this file format to aid in grading.
Using file processing makes entering and testing program with data sets much more efficient.
1. The file created should include valid and invalid passwords that fully tests the application.
1. Included is file called data.csv which contains Account data.
Your project will be graded using a similar input file.
Your project must run with an input file formatted as data.csv is formatted.
Note the file format is as follows (taken from [data.csv](data.csv)):
	1. Character designation of type of player (u - User, b - Bot, q - quit the application).
	1. User - username, fullname, deptCode.
	1. Bot - userAgent, category, createdBy.
	1. Account data - common data for both types.
	This data will only include the plaintext password and thhe salt since the other values are computed.
	```
	u,ADMHops,ADM Grace Hopper,12498,P@55w0Rd,8
	u,average-joe,Joe Jones,12377,123,3
	b,Googlebot,searchEngine,Sergey Brin,12345678,2
	b,cw1noonbot,malicious,Some Rascal,asdf1234AAA@@@,6
	q
	```

## Tips to Run a Program with an Input File
Later in the course, we'll be learning about file input and output, but in the meantime you can configure Eclipse to use an input file as though you typed the file at the command prompt.
1. In the top menu, select "Run"->"Run Configurations"
1. Change the Name at the top of the panel to something like "RunWithFileNotKeyboard".
1. Click on the "Common" tab.
1. Check the box next to "Input File" and navigate to the file containing the text you want to use.

The file that you select will replace the keyboard and it will become `System.in`.
Therefore, you'll want the file to include everything that you would normally type in at each prompt while your program was running; from start to finish.

## Sample run (using [data.csv](data.csv))
```
ADM Grace Hopper (username: ADMHops) works in department 12498.
	Account info: PWD: P@55w0Rd shifted 8 digits has an encrypted PWD of: XH==%8Zl
Joe Jones (username: average-joe) works in department 12377.
	Account info: (@@@ UNSAFE @@@) PWD: 123 shifted 3 digits has an encrypted PWD of: 456
searchEngine bot, User-Agent string=Googlebot was created by Sergey Brin.
	Account info: (@@@ UNSAFE @@@) PWD: 12345678 shifted 2 digits has an encrypted PWD of: 3456789:
malicious bot, User-Agent string=cw1noonbot was created by Some Rascal.
	Account info: PWD: asdf1234AAA@@@ shifted 6 digits has an encrypted PWD of: gyjl789:GGGFFF
```


### Create UML Class Diagram To Help Develop your Project
The diagram should be created before you start coding and should include:
1. All instance variables, including type and access specifier (+, -).
1. All methods, including parameter list, return type and access specifier (+, -).
1. Proper connection types between the classes.
1. The AccountTester does not need to be included.
1. Your final implementation will probably not match, and that is OK.
The process of creating the UML ensures that you've thought out and understand the project before trying to write the code.
1. The UML must be an image file in gif, png, or jpg format.
You can use software tools for creating your diagram, or just draw them with pen and paper and take a picture with your phone and save the image to your repo.

## Submission Requirements:
Your project must be submitted using the instructions below.
Any submissions that do not follow the stated requirements will not be graded.
1. You should have 5 files for this assignment:
	1. User\.java - The User class.
	1. Bot\.java - The Bot class.
	1. Account\.java - The Account class.
	1. AccountTester\.java  A driver program for your project.
	1. A UML Class diagram of your 3 classes, do not include the Tester (must be an image file: jpg, gif, pdf, or png).
1. Remember to compile and run your program one last time before you submit it.
If your program will not compile, the graders will not be responsible for trying to test it.
 
## Important Notes:
1. Projects will be graded on whether they correctly solve the problem, and whether they adhere to good programming practices.
1. Projects must be submitted by the time specified on the due date.
Projects submitted after that time will get a grade of zero.
1. Please review UWF's academic conduct policy.
Note that viewing another student's solution, whether in whole or in part, is considered academic dishonesty.
Also note that submitting code obtained through the Internet or other sources, whether in whole or in part, is considered academic dishonesty.
All programs submitted will be reviewed for evidence of academic dishonesty, and all violations will be handled accordingly.