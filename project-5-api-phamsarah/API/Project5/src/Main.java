
	public class Main
	{
		public static void main (String[] args)
		{
			// Note that the below should trigger data storage using a list of Double objects
			Web<Integer> server = new API<Integer>(12); // Using interface name to hold the object

			// Load some data
			server.Post(1);	//0
			server.Post(1);	//1
			server.Post(4);	//2
			server.Post(87);	//3
			server.Post(111);//4
			server.Post(23); //5
			server.Post(-13); //6
			server.Post(0);  //7
			server.Post(-2);  //8
			server.Post(-10); //9
			server.Post(-17); //10
			server.Post(-102);//11

			// Remove some things
			server.Delete(23);
			server.Delete(111);
			server.Delete(0);
			server.Delete(9999); // Not present in list, should be handled gracefully

			// Add some more
			server.Post(23);
			server.Post(111);
			server.Post(0);

			String xhrResponse = server.Get(1); // get first page of data (items 0-4)
			String expectedResponse = "{\"dataType\":\"Integer\",\"resultCount\":5,\"totalCount\":13,\"data\":[12,1,1,4,87]}";

			
			if (xhrResponse.equals(expectedResponse))
			{
				System.out.println("Wooohooo! Did it correctly");
			}
			else
			{
				System.out.println("SOMETHING WENT WRONG");
			}

			
			xhrResponse = server.Get(3); // get third page of data (items 10-12)
			expectedResponse = "{\"dataType\":\"Integer\",\"resultCount\":3,\"totalCount\":13,\"data\":[23,111,0]}";

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

