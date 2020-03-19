import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account {
	private String plaintextPassword; 
	private int salt;
	private int accountID;
	private static int nextIDNum = 1000; 
	private String encryptedPass;
	
	public Account(String pass, int saltNum) {
		this.setPlaintextPassword(pass);
		this.salt = saltNum; 
	}
	
	public void setPlaintextPassword(String password) {
		
		boolean upperCase = false;
		boolean lowerCase = false;
		boolean specialChar = false;
		boolean hasNumber = false;	

			
		if(password.length() < 8) {
			System.out.println("Error, not a minimum of 8 characters");
		}
		
		else {
			
			Pattern special = Pattern.compile("[$&+,:;=?@#|'<>.^*()%!-]");
		    Matcher matching = special.matcher(password);
			specialChar = matching.find();
			
				if(specialChar == false) {
					System.out.println("Error, no special character");
					return;
				}
				
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
			
				if(upperCase == false || lowerCase == false || hasNumber == false) {
					System.out.println("Error, does not contain an upper case, lower case, or number");
					return;
				}
		}	
		
		
		this.plaintextPassword = password;
	}
	
	
	public void encrypt() {
		
		int asciiChar;
		int shift;
		char encryptedChar;
		String encryptedPassword = "";
		
		
		for(int i = 0; i < this.plaintextPassword.length(); i++) {
			asciiChar = plaintextPassword.charAt(i);
			shift = asciiChar + salt;
			
			if(shift > 122) 
				shift = 32 + (salt - (122 - asciiChar));
				
			encryptedChar = (char)(shift);
			encryptedPassword = encryptedPassword.concat(Character.toString(encryptedChar));
			
			this.encryptedPass = encryptedPassword;
		 
	}
	}
	
	
	public String toString() {
		return ("       Account info:   " + "PWD:  " + this.plaintextPassword + " shifted " + this.salt + " digits has an encrypted PWD of: " + this.encryptedPass + ".\n");
	}
	
}
