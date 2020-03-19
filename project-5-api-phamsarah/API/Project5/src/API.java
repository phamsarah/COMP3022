/**
 * This is the API class that stores data into an ArrayList
 * Outputs into a JSON file format
 * 
 * COP 3022: Project # 5
 * @author: Sarah Pham
 * @version: 1
 * 
 */
import java.util.ArrayList;

public class API<T> implements Web<T>{

	private ArrayList <T> data;
	private String dataType;
	
	/**
	 * Constructor that creates the ArrayList, sends first number into the database, and
	 * calls a method that will store the dataType of the given number
	 * @param number the number passing through when creating the API
	 */
	
	public API(T number)
	{
		this.data = new ArrayList<T>();
		this.dataType = "";
		Post(number);
		setDataType(number);
	}
	
	/**
	 * Adds in data into the ArrayList instance variable
	 */
	
	public void Post(T number)
	{
		this.data.add(number);
	}
	
	/**
	 * Sets the dataType, this method was also called from the constructor
	 * @param number
	 */
	
	private void setDataType (T number) 
	{
		Class dataType = number.getClass();
		String dataSimple = dataType.getSimpleName();
		this.dataType = dataSimple;
	}
	
	
	/**
	 * Returns the dataType instance variable for later use in the JSON string
	 * FOR THIS SPECIAL API CASE, setters/getters are included for the DataType 
	 * and not in the Interface, because maybe not all API's want to retrieve
	 * datatype information.
	 * 
	 * @return dataType
	 */
	
	private String getDataType()
	{
		return this.dataType;
	}
	
	/**
	 * Deletes the given number in the ArrayList and handles values that are not in the database
	 */
	
	public void Delete(T number)
	{
		try {
			
			int index = this.data.indexOf(number);
			data.remove(index);
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println(number + " is not present in the database.");
		}
		catch(Exception e)
		{
			System.out.println("This variable is not present in the database");
		} 
	}	
	
	/**
	 * Returns data from the database in a JSON string format 
	 */
	
	public String Get(int number)
	{
		int offset = (number - 1) * 5;
		int i = 0, resultCount = 0;
		int totalCount = this.data.size();

		String dataString = "[";
			
		for(i = offset; i <= offset + 4; i++) {
			try {

					if(i == offset) 
					{
						dataString = dataString + data.get(i);
						resultCount++;
					}
					
					else 
					{
						dataString = dataString + "," + data.get(i);
						resultCount++;
					}
					
				}
			catch(IndexOutOfBoundsException e)
			{
				
			}
	
		}

		
		String JSON = ("{\"dataType\":\"" + getDataType() + "\",\"resultCount\":" + resultCount + ",\"totalCount\":" + totalCount + ",\"data\":" + dataString + "]}");
		return JSON;
	}
}
