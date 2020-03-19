# Lab 2 - Arrays

## Purpose
This lab will introduce you to working with multi-dimensional arrays and the enhanced for loop.
We'll be creating a function signature that will return a multi-dimensional array taking a one-dimensional array as its argument.

## Options
To test your function, you can either call print (or println) to output the array contents and verify them manually, or you can compare the array contents in a unit test.

## Task
For this lab, create code that will generate a repeater of a given integer.
You should pass in a one-dimensional array to a function that you create and return a two-dimensional array.

For your output (or test comparison) use the enhanced for (foreach) loop rather than the for loop.

## Example
Given input to your function of `{2,4,3,1}`, the result should be a two-dimensional array like this:\
`{{2,2},{4,4,4,4},{3,3,3},{1}}`

## Sample code
```java
int foo[] = {2, 4, 3, 1};
int repeatedArray[][] = MyClass.repeat(foo);
// repeatedArray[2] is an int array containing 3, 3, 3
```