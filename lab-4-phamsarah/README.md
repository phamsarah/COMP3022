# Exception-al
In this lab, we'll play around with the concepts related to exceptions that were discussed in the lecture.

## Outcomes
* Create a custom exception class
* Throw an exception from deep within a call stack
* Catch it in main
* Handle the exception
* Perform the same action whether an exception is thrown or not (finally).

## Steps
1. Create a new Class that "is an" Exception
	1. Call the base (super) constructor with the same message, but append " - my exception" to the text
1. Create a main function in a driver class
	1. Inside a loop, call a function to prompt the user to input miles driven and gallons used
		1. If either number is negative, do not add the values to the totals
		1. If something other than an integer is entered, assume the user intended to display the output and exit the program.
		1. After each pass of the loop, display "------------", even after the user has exited by typing in a string
1. Display miles per gallon calculation
	1. This should be a separate function

_Don't forget to consider the case when the very first value the user enters is a string_

_**Sample**_
```
Enter miles driven on this tank: 527
Enter number of gallons: 23
------------
Enter miles driven on this tank: 403
Enter number of gallons: 16
------------
Enter miles driven on this tank: -200
Negative value detected - my exception
------------
Enter miles driven on this tank: 494
Enter number of gallons: 21
------------
Enter miles driven on this tank: 475
Enter number of gallons: -12
Negative value detected - my exception
------------
Enter miles driven on this tank: 488
Enter number of gallons: foo
------------
Average miles per gallon: (527+403+494)/(23+16+21) = 23
```