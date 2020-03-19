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