/**
 * This is the User class that is a subclass of Account. It takes care of the user's username, full name,
 * and code. Also print's all information in a String. 
 * 
 * @author Sarah Pham
 * @version 1.0
 * 
 * COP3022 Project #: 2
 * File name: User.java
 * 
 * 
 */
public class User extends Account{
	private String username; 
	private String fullName;
	private int deptCode; 
	
	
/**
 * Parameterized constructor that sends the password and salt to the super class Account
 * and calls mutators to set variables username, full name, and code. 
 * @param user the username from the input file
 * @param name the full name of the user from input file
 * @param code the department code 
 * @param password plain text password being sent to super class to be encrypted
 * @param salt	the shift given to encrypt the password, sent to the super class as well
 */
	
	public User(String user, String name, int code, String password, int salt) {
		super(password, salt);
		this.setUsername(user);
		this.setfullName(name);
		this.setdeptCode(code);
	}
	
	/**
	 * Mutator method that set's the given username passed from the constructor to the instance variable username
	 * @param user the username from the input file
	 */
	
	public void setUsername(String user) {
		this.username = user;
	}
	
	/**
	 * Accessor method for the username	
	 * @return username 
	 */
	
	public String getUsername() {
		return this.username; 
	}
	
	/**
	 * Mutator method to set the given full name from the constructor to the instance
	 * variable fullName
	 * @param name the full name of the user
	 */
	
	public void setfullName(String name) {
		this.fullName = name;
	}
	
	/**
	 * Accessor method for the full name
	 * @return fullName 
	 */
	
	public String getfullName() {
		return this.fullName;
	}
	
	/**
	 * Mutator method to set the given department code from the constructor to instance variable deptCode
	 * @param code department code of the user
	 */
	
	public void setdeptCode(int code) {
		this.deptCode = code;
	}
	
	/**
	 * Accessor method for the department code
	 * @return deptCode
	 */
	
	public int getdeptCode() {
		return this.deptCode;
	}
	
	/**
	 * String method that returns all information in a nicely formatted string and calls
	 * the Account toString() to also include the password and encrypted password to the output
	 */
	
	public String toString() {
		return (this.getfullName() + " (username: " + this.getUsername() + ")" + " works in department " + this.getdeptCode() + ".\n" + super.toString());
	}
}
