/**
 * This is the Account tester class that tests the Account and uses
 * file inputs to receive an encrypted password
 * 
 * @author Sarah Pham
 * @version 1.0
 * 
 * COP3022 Project #: 2
 * File name: AccountTester.java
 * 
 * 
 */
import java.util.Scanner;

public class AccountTester {

	
	public static void main(String[] args) {
		
		String firstLetter, username, userAgent, fullName, plainPassword;
		String category, createdBy;
		String fileInput;
		int firstComma, secondComma, thirdComma, fourthComma, fifthComma;		
		int departmentCode; 
		int salt;
		
		Scanner file = new Scanner(System.in);
		
		// Set in a do-while loop to keep the input running until file inputs a "q" to quit
		
		do {
		
			fileInput = file.nextLine();
	
			// Each variable is determined between certain commas
			
			firstLetter = fileInput.substring(0, 1);	
			
			firstComma = fileInput.indexOf(",");
			secondComma = fileInput.indexOf(",", firstComma + 1);
			thirdComma = fileInput.indexOf(",", secondComma + 1);
			fourthComma = fileInput.indexOf(",", thirdComma + 1);
			fifthComma = fileInput.indexOf(",", fourthComma + 1);
			
			// If the first letter is a U, then it must be a user, so a user object is created

			if(firstLetter.equalsIgnoreCase("u")) {
			
				// username is the input between the first comma and second comma

					username = fileInput.substring(firstComma + 1, secondComma);	// the plus one is to get rid of the comma and not have it stored
					

				//Full name is between the second and third comma and so forth
			
					fullName = fileInput.substring(secondComma + 1, thirdComma);
			
					departmentCode = Integer.parseInt(fileInput.substring(thirdComma + 1, fourthComma));  // taking the string between third and fourth comma, storing it as an int in departmentCode
				
					plainPassword = fileInput.substring(fourthComma + 1, fifthComma); 
			
					salt = Integer.parseInt(fileInput.substring(fifthComma + 1));
			
				User someUser = new User(username, fullName, departmentCode, plainPassword, salt);
			
					System.out.println(someUser.toString());

	
			}
		
		
			else if(firstLetter.equalsIgnoreCase("b")) {
			
				// if the first letter is a B, then there is a USERAGENT instead of username 
		
					userAgent = fileInput.substring(firstComma + 1, secondComma);  
			
					category = fileInput.substring(secondComma + 1, thirdComma);
			
					createdBy = fileInput.substring(thirdComma + 1, fourthComma);  
			
					plainPassword = fileInput.substring(fourthComma + 1, fifthComma); 
			
					salt = Integer.parseInt(fileInput.substring(fifthComma + 1));
			
			Bot someBot = new Bot(userAgent, category, createdBy, plainPassword, salt);
				
				System.out.println(someBot.toString());
	
		}
				//until the first letter is q, the loop will keep running
		}while(firstLetter.equalsIgnoreCase("u") || firstLetter.equalsIgnoreCase("b"));			
		}}
