# Project 5 - Simple API

![The Internet](http://3.bp.blogspot.com/-ZIhlX_t23mQ/VPofXNUKMmI/AAAAAAAAEpI/tcTRLQP0QFY/s1600/IMG_20150306_082102.jpg)
## Outcomes
* Exposure to the basics of frontend/backend architecture separation.
* Implement a custom Interface in Java.
* Develop a Generic class in Java.

## Prep Readings:
ZyBooks Chapters on Generics and Interfaces.

## Description
An Application Programmer Interface (API) as we have discussed it so far in this course is the list of variables and methods that are marked as `public` within their declaration.
To software developers who utilize web technologies, the term API often means something different.

In the web context, an API is a remote service that you call from an application to read or write data.
For instance, the Google app on your phone obviously doesn't have the entire internet in it, unless you are a cast member of The IT Crowd.
The way that searches are conducted is through a frontend-backend exchange of data.
Essentially, your app (the frontend) sends an HTTP request, behind-the-scenes, to a server (the backend) and requests data.
The server then replies with the data and the frontend adjusts the display based on that data.
As you would expect, the utility and ubiquity of such an interaction is so vast that there are **many** ways of doing it.

**In this project** you will be writing a very simple version of an API.
To keep from having to learn too many things on a single project, we will just be simulating the use of HTTP.
You are provided with a main class which you can/should use to help develop your project.
The main class that will be used for grading will use different data types than the one given, so your API needs to be able to handle multiple data types.

Your API will need to respond to three different types of calls:
1. A _POST_ request will add new data to the set.
1. A _DELETE_ request will delete the specified data from the set.
1. A _GET_ request will return a subset of the data based on the `pageNumber` variable, [explained below](#pagination).

When the API class is instantiated, an initial piece of data will be sent so that the data type can be inferred.
You'll need to store that data type to use in the API response for the _GET_ request.
See https://docs.oracle.com/javase/7/docs/api/java/lang/Object.html#getClass() and https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html#getSimpleName--.
You can safely assume that all data will be the correct type, if the first piece of data in an integer, then the _Integer_ class would be fine for holding the data.

The storage of the data should use the ArrayList class.
This is partly for exposure to the container class itself, but mostly for your own sanity since adding and deleting within an array is easy to mess up.

### Pagination
If you are shopping online for some pants, you'll often see just 20 results and you need to click to go to the next page.
Typically, all of the results could just be shown at once, but that might be a large amount of data and the transfer time and time to render the images might make the site even more annoying to use.
So, pagination lets us break up our data into bite-sized chunks that allow for faster page loading and reduction of data transfer.

In our application, we are going to use a page size of 5.
Thus a _GET_ request for `pageNumber` 1 should return items 0-4 from our list.
A _GET_ request for `pageNumber` 13 should start at item `(13 - 1) * 5 = 60` and thus return 60-64.
Clearly a request at the end of the list might return fewer than 5 items, that is fine.

A request for a page that does not exist, such as page 13 of a list that has only 50 items should notify the user appropriately.

### JavaScript Object Notation (JSON)
JSON is one of the most common ways that data is transferred in APIs today.
JSON has gained popularity over older data exchanges such as XML because of how simple it is and how little overhead it involves.

A JSON string is simply a list of key:value pairs.
All keys must be contained within double-quotes.
All values that are numeric are not in double-quotes, everything else is.
JSON does not parse on most systems with any extra spaces or line breaks, the example below doesn't have any whitespace in it on purpose.

JSON allows nesting of objects and it allows arrays.
That is basically it, here is an example:
* `{"foo":"bar","baz":[{"a":12.43,"b":3},{"a":1.222,"b":-54}]}`
	* This has, at the top level, two keys, "foo" and "baz".
	* "foo" has a string value of "bar".
	* "baz" is an array of nested objects.
		* In this example the objects in the array are of the same type, but they do not need to be in order to be valid JSON.
	* Each object in the "baz" array has two keys, "a" and "b".
		* "a" is a floating point number, "b" is an integer.

Tons of JSON validators are out there for free, such as https://jsonlint.com/.
You can just paste in some text and it will tell you whether or not the JSON is valid.
It will also format it quite nicely so that you can see the structure quite clearly.
Note that pretty-printed JSON like what you see below is for display only and is not valid JSON due to the whitespace problems metioned above.
The same JSON string above pretty-printed:
```json
{
	"foo": "bar",
	"baz": [{
		"a": 12.43,
		"b": 3
	}, {
		"a": 1.222,
		"b": -54
	}]
}
```

### Interface
* The Main example given below requires that your API class have methods called `Post(data)`, `Delete(data)` and `Get(pageNumber)`.
* This quality should be guaranteed by creating a `Web` Interface and making your API implement that interface.
* The benefit to that is that on a larger project, many programmers across different teams might need to build new API "endpoints" and it would be critical to your frontend application or other consumers of your API that all new endpoints meet the "standard".

### [API/Main.java](API/Main.java)
```java
public class Main
{
	public static void main (String[] args)
	{
		// Note that the below should trigger data storage using a list of Double objects
		Web<Double> server = new API<Double>(12.3); // Using interface name to hold the object


		// Load some data
		server.Post(1.77);
		server.Post(1.02);
		server.Post(4.88);
		server.Post(87.65);
		server.Post(111.11);
		server.Post(23.53);
		server.Post(-13.9);
		server.Post(-0.5);
		server.Post(-2.9);
		server.Post(-10.7);
		server.Post(-17.2);
		server.Post(-102.7);

		// Remove some things
		server.Delete(23.53);
		server.Delete(111.11);
		server.Delete(-0.5);
		server.Delete(9999.99); // Not present in list, should be handled gracefully

		// Add some more
		server.Post(23.456);
		server.Post(111.11);
		server.Post(-0.5);

		String xhrResponse = server.Get(1); // get first page of data (items 0-4)
		String expectedResponse = "{\"dataType\":\"Double\",\"resultCount\":5,\"totalCount\":13,\"data\":[12.3,1.77,1.02,4.88,87.65]}";

		if (xhrResponse.equals(expectedResponse))
		{
			System.out.println("Wooohooo! Did it correctly");
		}
		else
		{
			System.out.println("SOMETHING WENT WRONG");
		}

		
		xhrResponse = server.Get(3); // get third page of data (items 10-12)
		expectedResponse = "{\"dataType\":\"Double\",\"resultCount\":3,\"totalCount\":13,\"data\":[23.456,111.11,-0.5]}";

		if (xhrResponse.equals(expectedResponse))
		{
			System.out.println("Even the pagination is working...fire!");
		}
		else
		{
			System.out.println("SOMETHING WENT WRONG WITH PAGINATED DATA");
		}
	}
}
```

### Sample Output
```
Wooohooo! Did it correctly
Even the pagination is working...fire!
```

## Submission Requirements:
1. Remember to compile and run your program one last time before you submit it.
	1. If your program will not compile, the graders will not be responsible for trying to test it.
1. All .java files (this should include unit tests, if any, you created).
1. A UML Class diagram of your classes including relationship arrows, do not include unit test files or your Main class (must be an image file: jpg, gif, pdf, or png).
 
## Important Notes:
1. Projects will be graded on whether they correctly solve the problem, and whether they adhere to good programming practices.
1. Projects must be submitted by the time specified on the due date.
Projects submitted after that time will get a grade of zero.
1. Please review UWF's academic conduct policy.
Note that viewing another student's solution, whether in whole or in part, is considered academic dishonesty.
Also note that submitting code obtained through the Internet or other sources, whether in whole or in part, is considered academic dishonesty.
All programs submitted will be reviewed for evidence of academic dishonesty, and all violations will be handled accordingly.
