/**
 * This is the Account class that encrypts a password with given information
 * and prints out all data in a string.
 * Account is also the superclass for the classes Bot and User.
 * 
 * @author Sarah Pham
 * @version 1.0
 * 
 * COP3022 Project #: 2
 * File name: Account.java
 * 
 * 
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account {
	private String plaintextPassword; 
	private int salt;
	private int accountID;
	private static int nextIDNum = 1000; 
	private String encryptedPass;
	private String criticalState = "";
	
	/**
	 * Default constructor that sets the given password by calling setPlaintextPassword and sets salt to the private instance variable
	 * also assigns an accountID
	 * 
	 * @param pass plain text password input from the file
	 * @param salt shift number input from the file
	 */
	
	public Account(String pass, int salt) {
		this.salt = salt; 
		this.accountID = nextIDNum++; 
		this.setPlaintextPassword(pass);
	}
	
	
	/**
	 * Set's the plain text password from the file input and check's minimum requirements
	 * also call's the encrypt method to encrypt the given password
	 * @param password the password variable passed on from the default constructor
	 */
	
	public void setPlaintextPassword(String password) {
		boolean upperCase = false;
		boolean lowerCase = false;
		boolean specialChar = false;
		boolean hasNumber = false;	

			
		Pattern special = Pattern.compile("[$&+,:;=?@#|'<>.^*()%!-]");
		Matcher matching = special.matcher(password);
		specialChar = matching.find();
				
		char passCharacter;	
		for(int i = 0; i < password.length(); i++) {
			passCharacter = password.charAt(i);
				
			if(Character.isUpperCase(passCharacter) == true)
				upperCase = true;
				
			if(Character.isLowerCase(passCharacter) == true)
				lowerCase = true;
				
			if(Character.isDigit(passCharacter) == true)
				hasNumber = true;
		}
		
		// If the minimum requirement's are not met, then the password is pronounced unsafe and instance variable critical state is set
			
			if(upperCase == false || lowerCase == false || hasNumber == false || specialChar == false) {
				this.criticalState = "(@@@ UNSAFE @@@).";
			}
		
		
		this.plaintextPassword = password;
		this.encrypt();
	}
	
	/**
	 * Encrypt's the plaintextPassword instance variable by converting the given password String into ascii characters, shifting by 
	 * using the given salt, and then converting the password back into an encrypted String. Then stores the encrypted password into an instance variable.
	 */
	
	public void encrypt() {
		
		int asciiChar;
		int shift;
		char encryptedChar;
		String encryptedPassword = "";		
		
		//Looping through each character of the string, converting it to ascii, shifting, and then converting back
		
		for(int i = 0; i < this.plaintextPassword.length(); i++) {
			asciiChar = this.plaintextPassword.charAt(i);
			
			
			shift = asciiChar + this.salt;
			
			// If the shift is past 122, the shift will continue from character 33
			
			if(shift > 122) 
				shift = (33 - 1) + (this.salt - (122 - asciiChar));
				
			encryptedChar = (char)(shift);
			
			// Concatenating each character into the string to be stored in the instance variable encryptedPass
			
			encryptedPassword = encryptedPassword.concat(Character.toString(encryptedChar));
			
			this.encryptedPass = encryptedPassword;
		 
	}
	}

	/**
	 * Returns the instance variable encrypted password, which was calculated and stored in the encrypt() method
	 * @return
	 */
	
	public String getEncryptedPass() {

		return this.encryptedPass;
	}
	
	
	/**
	 * Returns all information in a string, including the critical state of the password, account id, password, salt, and encrypted password
	 */
	
	public String toString() {
		return ("       Account info: " + this.criticalState + " Account ID : " + this.accountID + "   PWD:  " + this.plaintextPassword + " shifted " + this.salt + " digits has an encrypted PWD of: " + getEncryptedPass() + "\n");
	}
	
}
