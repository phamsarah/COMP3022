# Interfaces and Nested Classes

## Background
**ZyBook Chapter on Interfaces**

## Outcomes
* Students have created a custom interface to use across a software package
* Students have implemented two unrelated classes that implement the same interface
* Students have implemented a nested class within Java

## Steps
1. Create an interface that will ensure that any conforming class will implement the "print" method.
2. Create a custom class to store an employee.
	1. This class should store the employee name given to it when constructed
		1. Note that an **Employee** name has two parts (first name and last name), so let's store that data in a **Name** class
		2. This employee name format will differ from other "names" that we might want to keep track of, such as department name, product name, etc.
	2. Additionally, the **Employee** class should store its own salary.
	3. The class should implement the interface you created in step 1.
3. Create a basic test to create an employee and print out their details.

## Advice
1. Think about the problem and make sure that you clearly understand what is being asked.
	1. How many files will you need?
	2. How many classes (or interfaces) are needed?
	3. What constraints were given that might change one or both of the answers to the previous questions?
2. Sketch out your program on a sheet of paper in basic wire-frame UML.
3. Create a way to test your code.
	1. The test should fail since you haven't written any code yet.
	2. Write out a way to test everything that you want the class to do.
4. Create skeleton versions of your files.
	1. What variables are needed within the class?
	2. What functions are needed by your testing approach?
	3. Just create declarations at first, not actual implementations.
5. Start writing the code to make your tests pass (one at a time).

# Don't forget to commit often

## This Was Too Easy
If the above didn't challenge you or get you to learn anything new, try exploring other aspects of what we've discussed.
For example:
* What if you wanted to be able to "print" a vendor (company) too?
* In a JUnit or driver program, create an array of **Printable** things and test out the polymorphic attitude of the array.
* Nest a class within an already nested class.